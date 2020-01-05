import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.LinkedList;

/**
 * NetworkFlow - MaxFlow - Edmonds Karp Algorithm
 * This program is to find max flow in flow graph using Edmonds Karp method
 * Time Complexity : O(E^2V) E for Edge, V for Vertex
 * This Code was inspired by William fiset
 *
 * @author Lemidia
 */

public class EdmondsKarp {

    static int n; // The number of vertex
    static int m; // The number of Edge
    static int source;
    static int sink;
    static int maxFlow;
    static final int INF = Integer.MAX_VALUE;
    static int token; // Increasing Token
    static int visited[]; // Visited check
    static Edge prev[]; // Augmenting path for flow propagation
    static List<Edge>[] flowGraph;

    /**
     *
     * @param from Vertex where edge starts
     * @param to Vertex where edge ends
     * @param capacity Edge Capacity
     */

    static void addEdge(int from, int to, int capacity){
        Edge e1 = new Edge(from, to, 0, capacity);
        Edge e2 = new Edge(to, from, 0, 0); // Backward Edge
        e1.backward = e2; // Connecting each other
        e2.backward = e1;
        flowGraph[from].add(e1);
        flowGraph[to].add(e2);
    }

    /**
     *
     * @param e Edge
     * @return Remaining capacity of the edge
     */

    static int remainingCapacity(Edge e){ // if > 0 then residual Edge
        return e.capacity - e.flow;
    }

    static void augment(Edge e, int bottleNeck){
        e.flow+=bottleNeck;
        e.backward.flow-=bottleNeck;
    }

    static void creatFlowGraph(){
        maxFlow = 0;
        token = 0;
        visited = new int[n];
        prev = new Edge[n];
        flowGraph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            flowGraph[i] = new ArrayList<>();
        }
    }


    // Using Breath first search to find augmenting path
    static int getMaxFlow(){
        while (true){
            int bottleNeck = INF;
            prev[sink] = null;
            token++;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(source);
            visited[source] = token;
            while (!queue.isEmpty()){
                int node = queue.poll();
                if (node == sink) // Augmenting path exist!
                    break;
                for (Edge e : flowGraph[node]){
                    if (remainingCapacity(e) > 0 && visited[e.to] != token){
                        queue.offer(e.to);
                        visited[e.to] = token;
                        prev[e.to] = e;
                    }
                }
            }
            if (prev[sink] == null) // If there is no augmenting path
                break;

            // Finding BottleNeck flow
            for (Edge edge = prev[sink] ; edge != null ; edge = prev[edge.from]){
                int remainingCapacity = remainingCapacity(edge);
                if (remainingCapacity < bottleNeck)
                    bottleNeck = remainingCapacity;
            }

            // Propagating bottleNeck flow along the augmenting path
            for (Edge edge = prev[sink] ; edge != null ; edge = prev[edge.from]){
                augment(edge, bottleNeck);
            }
            maxFlow+=bottleNeck;
        }
        return maxFlow;
    }

    static void printEdge(Edge e){
        System.out.println(e.to + " " + e.from + " " + e.flow);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        n = 6;
        source = n - 1;
        sink = n - 2;
        creatFlowGraph();
        // Source edges
        addEdge(source, 0, 10);
        addEdge(source, 1, 10);

        // Sink edges
        addEdge(2, sink, 10);
        addEdge(3, sink, 10);

        // Middle edges
        addEdge(0, 1, 2);
        addEdge(0, 2, 4);
        addEdge(0, 3, 8);
        addEdge(1, 3, 9);
        addEdge(3, 2, 6);

        System.out.print(getMaxFlow());
    }
    static class Edge{
        int from;
        int to;
        int flow;
        int capacity;
        Edge backward;

        public Edge(int from, int to, int flow, int capacity) {
            this.from = from;
            this.to = to;
            this.flow = flow;
            this.capacity = capacity;
        }
    }
}
