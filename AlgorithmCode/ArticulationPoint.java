import java.util.ArrayList;

public class ArticulationPoint {
    int ids[];
    int lows[];
    int id;
    boolean visited[];
    boolean isArt[];
    int OutGoingEdge;

    int min (int a, int b) {
        return a < b ? a : b;
    }

    // 컷 에지 dfs 시작
    public void dfs (Graph graph, int cur, int parent, int root) {
        if (parent == root)
            OutGoingEdge++;
        visited[cur] = true;
        ids[cur] = id;
        lows[cur] = id;
        id++;

        for (int to : graph.graph[cur]) {
            if (parent == to)
                continue;
            if (!visited[to]) {
                dfs(graph, to, cur, root);
                lows[cur] = min(lows[cur], lows[to]);
                if (ids[cur] < lows[to]) {
                    isArt[cur] = true;
                }
                if (ids[cur] == lows[cur]) {
                    isArt[cur] = true;
                }
            }else {
                lows[cur] = min(ids[to], lows[cur]);
            }
        }
    }

    // 컷 에지 메소드, dfs 헬퍼 메소드
    void doArticulationPointAlgorithm(Graph graph, int n) {

        ids = new int[n];
        lows = new int[n];
        visited = new boolean[n];
        isArt = new boolean[n];

        // Seek Cut Edge
        int start = 0;
        dfs(graph, start, -1, -1);
        // 시작 점은 진출 차수가 0 또는 1이면 단절점이 될 수 없다.
        // 0 : 노드 1개, 자기 자신, 1: 사이클인 경우 갇힘, 사이클이 아니라면 단절점이 아니다.
        if (OutGoingEdge < 2)
            isArt[start] = false;
    }

    // For construct graph - 그래프 클래스
    static class Graph {
        ArrayList<Integer> graph[];

        public Graph(int n) {
            graph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
        }
        // 간선 추가 메소드
        public void addEdge(int a, int b) {
            graph[a].add(b);
            graph[b].add(a);
        }
    }

    /*

      Sample Graph - 코드에서 사용된 예제 그래프

        0       6
       / \     / \
      1 - 2 - 5   7   ==> Articulation point will be 2, 3, 5
          |    \ /
          3     8
           \
            4

     */

    public static void main(String[] args) {
        int n = 9;
        Graph graph = new Graph(n);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(5, 8);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);

        ArticulationPoint art = new ArticulationPoint();
        art.doArticulationPointAlgorithm(graph, n);
        
        // Output : 2 3 5
        for (int i = 0; i < art.isArt.length; i++) {
            if (art.isArt[i])
                System.out.print(i + " ");
        }
    }
}
