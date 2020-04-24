package ShortestPath;

import java.util.*;
import java.util.LinkedList;

public class ShortestPathOnDAG {

    private static int n;
    private static ArrayList<Integer> topologicalOrder;
    private static int dist[];
    private static int prev[];

    static class Graph {
        private ArrayList<Edge> adj[];

        public Graph(int n) {
            adj = new ArrayList[n];
            for (int i = 0; i < n; i++)
                adj[i] = new ArrayList<>();
        }

        public void addEdge(int a, int b, int weight) {
            adj[a].add(new Edge(b, weight));
        }
    }

    static class Edge {
        private int to;
        private int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
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
        for (Edge edge : graph.adj[at]) {
            if (!visited[edge.to])
                dfs(graph, edge.to, visited);
        }
        topologicalOrder.add(at);
    }

    public static void seekShortestPathOnDAG(Graph graph, int start) {
        dist = new int[n];
        prev = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            prev[i] = -1;
        }
        dist[start] = 0;

        for (int order : topologicalOrder) {
            for (Edge edge : graph.adj[order]) {
                int newDist = dist[order] + edge.weight;
                if (newDist < dist[edge.to]){
                    dist[edge.to] = newDist;
                    prev[edge.to] = order;
                }
            }
        }
    }

    public static void pathReconstruction() {
        LinkedList<Integer> path = new LinkedList<>();
        int endNode = topologicalOrder.get(n-1);
        path.addFirst(endNode);
        for (int i = prev[endNode]; i != -1 ; i = prev[i]) {
            path.addFirst(i);
        }

        for (int next : path)
            System.out.print(next + " ");
    }

    // Sample Graph : https://www.youtube.com/watch?v=TXkDpqjDMHA at 4:20

    public static void main(String[] args) {
        n =  8;
        Graph graph = new Graph(n);
        graph.addEdge(0, 1, 3);
        graph.addEdge(0, 2, 6);
        graph.addEdge(1, 2, 4);
        graph.addEdge(1, 3, 4);
        graph.addEdge(1, 4, 11);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 6, 11);
        graph.addEdge(3, 4, -4);
        graph.addEdge(3, 5, 5);
        graph.addEdge(3, 6, 2);
        graph.addEdge(4, 7, 9);
        graph.addEdge(5, 7, 1);
        graph.addEdge(6, 7, 2);

        topologicalSort(graph, 0);
        seekShortestPathOnDAG(graph, 0);
        System.out.println(dist[7]);
        pathReconstruction();
    }
}
