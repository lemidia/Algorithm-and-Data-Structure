import java.util.*;

public class TopologicalSortUsingDFS{

    private static int n;
    private static ArrayList<Integer> topologicalOrder;

    static class Graph {
        private ArrayList<Integer> adj[];

        public Graph(int n) {
            adj = new ArrayList[n];
            for (int i = 0; i < n; i++)
                adj[i] = new ArrayList<>();
        }

        public void addEdge(int a, int b) {
            adj[a].add(b);
        }
    }

    public static void topologicalSort (Graph graph, int start) {
        topologicalOrder = new ArrayList<>();
        boolean visited[] = new boolean[n];
        dfs(graph, start, visited);
        Collections.reverse(topologicalOrder);
    }

    public static void dfs(Graph graph, int at, boolean visited[]) {
        visited[at] = true;
        for (int to : graph.adj[at]) {
            if (!visited[to])
                dfs(graph, to, visited);
        }
        topologicalOrder.add(at);
    }

    // Sample Graph : https://www.youtube.com/watch?v=TXkDpqjDMHA at 4:20

    public static void main(String[] args) {
        n =  8;
        Graph graph = new Graph(n);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 6);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 7);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);

        topologicalSort(graph, 0);
        for (int node : topologicalOrder)
            // Output will be :  0 1 2 3 6 5 4 7
            System.out.print(node + " ");
    }
}
