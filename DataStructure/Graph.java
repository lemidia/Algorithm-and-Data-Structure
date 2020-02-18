import java.util.LinkedList;

public class Graph {
    private int V; // 그래프의 정점 갯수
    LinkedList<Integer> adjListArray[]; // 그래프의 정점을 저장할 인접리스트 배열

    public Graph(int V) { // 그래프 생성자, 정점과 인접리스트 배열을 초기화 한다.
        this.V = V;
        adjListArray = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }
    // 그래프 출력 메소드
    public void printGraph() {
        for (int v = 0; v < V; v++) {
            System.out.print(v);
            for (Integer i : adjListArray[v]) {
                System.out.print(" => " + i);
            }
            System.out.print("\n");
        }
    }
    // 양방향 간선 생성 메소드
    static void addEdge(Graph graph, int src, int dest) {
        graph.adjListArray[src].add(dest);
        graph.adjListArray[dest].add(src);
    }


    public static void main(String[] args) {
        int V = 5; // 정점의 갯수는 5개 (0, 1, 2, 3, 4)
        Graph graph = new Graph(V); // 그래프 초기화

        addEdge(graph, 0, 1); // 0번과 1번을 정점으로 하는 간선을 생성한다.
        addEdge(graph, 0, 2); // 0번과 2번을 정점으로 하는 간선을 생성한다.
        addEdge(graph, 1, 2); // 1번과 2번을 정점으로 하는 간선을 생성한다.
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 4);
        addEdge(graph, 3, 4);

        graph.printGraph();
    }
}