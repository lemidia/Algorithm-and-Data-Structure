import java.io.*;
import java.util.*;
import java.util.LinkedList;

/**
 * NetworkFlow - MaxFlow : Ford Fulkerson method
 * This program is to find max flow in flow graph using Ford Fulkerson method
 * Time Complexity : O(Ef) E for Edge, f for flow
 *
 * @author Lemidia
 */

public class FordFulkersonMethod{

    static List<Edge>[] flowGraph; // AdjacenyList for flow graph
    static int visited[]; // Visit check for dfs to prevent from making visit same node twice or more
    static int visitedToken = 1; // Increasing token for duplicating visited node which used in dfs
    static int source;
    static int sink;
    static int n; // The number of vertex
    static final long INF = Long.MAX_VALUE/2;

    public static void creatGraph(){
        visited = new int[n];
        flowGraph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            flowGraph[i] = new ArrayList<>();
        }
    }

    public static void addEdge(int from, int to, int capacity){
        Edge forward = new Edge(from, to, 0, capacity);
        Edge residual = new Edge(to, from, 0, 0);
        forward.residual = residual; // pair forward and residual;
        residual.residual = forward; // pair residual and forward;
        flowGraph[from].add(forward);
        flowGraph[to].add(residual);
    }

    // Add a bottleneck flow to All edge in Augmenting path.
    public static void augment(Edge e, long bottleNeck){
        e.flow+=bottleNeck;
        e.residual.flow-=bottleNeck;
    }

    public static long getMaxFlow(){
        long maxFlow = 0;
        // Find Augmenting path
        for (long f = dfs(source, INF); f!=0 ; f = dfs(source, INF)){
            maxFlow+=f;
            visitedToken++;
        }
        return maxFlow;
    }

    public static long remainingCapacity(Edge e){
        return e.capacity - e.flow;
    }

    public static long dfs(int node, long flow){
        if (node == sink)
            return flow;
        visited[node] = visitedToken;
        for (Edge e : flowGraph[node]){
            if (remainingCapacity(e) > 0 && visited[e.to] != visitedToken){
                long bottleNeck =  dfs(e.to, min(flow, remainingCapacity(e)));
                if (bottleNeck>0) {
                    augment(e, bottleNeck);
                    return bottleNeck;
                }
            }
        }
        return 0;
    }

    static long min(long a, long b){
        return a<b?a:b;
    }

    static int transfer(char a){
        if (a<='Z')
            return a-'A';
        return 26+(a-'a');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = 6;
        source = n - 1;
        sink = n - 2;
        creatGraph();
        // Source edges
        addEdge(source, 0, 10);
        addEdge(source, 1, 10);

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
        Edge residual;

        public Edge(int from, int to, int flow, int capacity) {
            this.from = from;
            this.to = to;
            this.flow = flow;
            this.capacity = capacity;
        }
    }
}