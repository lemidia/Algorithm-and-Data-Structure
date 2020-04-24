import java.util.ArrayList;

public class CutEdge {

    int ids[];
    int lows[];
    int id;
    boolean visited[];
    ArrayList<Edge> cutEdgeList;

    int min (int a, int b) {
        return a < b ? a : b;
    }

    static class Edge {
        int from;
        int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    public void dfs (Graph graph, int cur, int parent) {
        visited[cur] = true;
        ids[cur] = id;
        lows[cur] = id;
        id++;

        for (int to : graph.graph[cur]) {
            if (parent == to)
                continue;
            if (!visited[to]) {
                dfs(graph, to, cur);
                lows[cur] = min(lows[cur], lows[to]);
                if (ids[cur] < lows[to])
                    cutEdgeList.add(new Edge(cur, to));
            }else {
                lows[cur] = min(ids[to], lows[cur]);
            }
        }
    }

    void doCutEdgeAlgorithm(Graph graph, int n) {

        ids = new int[n];
        lows = new int[n];
        visited = new boolean[n];
        cutEdgeList = new ArrayList<>();

        // Seek Cut Edge
        dfs(graph, 0, -1);

        // Print Cut Edge
        // Output will be : 3-4 2-3 2-5
        for (Edge cutEdge : cutEdgeList) {
            System.out.print(cutEdge.from + "-" + cutEdge.to + " ");
        }
    }

    // For construct graph
    static class Graph {
        int n;
        ArrayList<Integer> graph[];

        public Graph(int n) {
            this.n = n;
            graph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
        }

        public void addEdge(int a, int b) {
            graph[a].add(b);
            graph[b].add(a);
        }
    }

    /*

      Sample Graph

        0       6
       / \     / \
      1 - 2 - 5   7   ==> Cut Edge will be 3-4, 2-3, 2-5
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
        
        CutEdge cutEdge = new CutEdge();
        cutEdge.doCutEdgeAlgorithm(graph, n);
    }
}
