package ShortestPath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This program is to find Shortest path in All same weighted graph using BFS
 * Time Complexity : Worst case : O(V+E)
 *
 * @author Lemidia(Gyeong)
 */

public class ShortestPathOnAllSameWeightedGraph {
    static int dist[];
    static int pred[];
    static int visited[];
    static int n;
    static ArrayList<Edge>[] graph;
    static final int INF = 1000000000;

    static void createGraph(){
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
    }

    static void addEdge(int from, int to, int cost){
        Edge e = new Edge(to, cost);
        graph[from].add(e);
    }

    static void shortestPathOnAllSameWeighted(int s){
        dist = new int[n];
        pred = new int[n];
        visited = new int[n];
        Arrays.fill(dist, INF);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        dist[s] = 0;
        visited[s] = 1;

        while (!queue.isEmpty()){
            int cur = queue.poll();
            for (Edge e : graph[cur]){
                dist[e.to] = dist[cur] + e.cost;
                if (visited[e.to] != 1){
                    visited[e.to] = 1;
                    pred[e.to] = cur;
                    queue.offer(e.to);
                }
            }
        }
    }

    static void pathReconstruction(int start, int end){
        if (end == start) {
            System.out.print(start);
            return;
        }
        pathReconstruction(start, pred[end]);
        System.out.print(" -> " + end );
    }

    public static void main(String[] args) throws IOException {

        // Sample Input:

        n = 6;
        int start = 0;
        int end = 5;
        createGraph();
        addEdge(0, 1, 1);
        addEdge(0, 2, 1);
        addEdge(1, 2, 1);
        addEdge(1, 3, 1);
        addEdge(2, 4, 1);
        addEdge(3, 5, 1);
        addEdge(4, 3, 1);

        shortestPathOnAllSameWeighted(start);

        System.out.println("Shortest path distance : " + dist[5]);
        System.out.print("Shortest path : ");
        pathReconstruction(start, end);

        // Output:
        // Shortest path distance : 3
        // Shortest path : 0 -> 1 -> 3 -> 5
    }

    static class Edge{
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
