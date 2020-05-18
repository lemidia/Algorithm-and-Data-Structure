import java.util.*;
import java.util.LinkedList;

public class MinCostMaxFlow {

    static int n;
    static int m;
    static int source;
    static int sink;
    static ArrayList<Edge>[] flowGraph;
    static Edge prev[];
    static int dist[];
    static boolean onQueue[];
    static final int INF = Integer.MAX_VALUE;
    static int maxFlow;
    static int minCostMaxFlow;

    static void createGraph(){
        prev = new Edge[n];
        dist = new int[n];
        onQueue = new boolean[n];
        flowGraph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            flowGraph[i] = new ArrayList<>();
        }
    }

    static void addEdge(int from, int to, int capacity, int cost){
        Edge e1 = new Edge(from, to, 0, capacity, cost);
        Edge e2 = new Edge(to, from, 0, 0, -1 * cost);
        e1.backward = e2;
        e2.backward = e1;
        flowGraph[from].add(e1);
        flowGraph[to].add(e2);
    }

    static int remainingCapacity(Edge e){
        return e.capacity - e.flow;
    }

    static void augment(Edge e, int bottleNeck){
        minCostMaxFlow += e.cost * bottleNeck;
        e.flow += bottleNeck;
        e.backward.flow -= bottleNeck;
    }

    // Shortest Path Faster Algorithm is used.
    static void getMinCostMaxFlow(){
        while (true) {
            Arrays.fill(dist, INF);
            prev[sink] = null;
            Deque<Integer> queue = new LinkedList<>();
            queue.offer(source);
            onQueue[source] = true;
            dist[source] = 0;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                onQueue[cur] = false;
                for (Edge e : flowGraph[cur]) {
                    int newDist = e.cost + dist[cur];
                    // Remaining Capacity and Unvisited and Can be Edge Relaxation
                    if (remainingCapacity(e) > 0 && newDist < dist[e.to]) {
                        dist[e.to] = newDist;
                        prev[e.to] = e;
                        if (!onQueue[e.to]) {
                            onQueue[e.to] = true;
                            queue.offer(e.to);
                            // Small Label First
                            if (dist[e.to] < dist[queue.peekFirst()]) {
                                queue.offerFirst(queue.pollLast());
                            }
                        }
                    }
                }
            }
            if (prev[sink] == null)
                break;
            int bottleNeck = INF;
            for (Edge e = prev[sink]; e != null; e = prev[e.from]) {
                int remainingCapacity = remainingCapacity(e);
                if (remainingCapacity < bottleNeck)
                    bottleNeck = remainingCapacity;
            }

            for (Edge e = prev[sink]; e != null; e = prev[e.from]) {
                augment(e, bottleNeck);
            }
            maxFlow += bottleNeck;
        }
    }

    // test module
    public static void main(String[] args) {
        n = 6;
        source = n-1;
        sink = n-2;
        createGraph();
        addEdge(source, 1, 4, 10);
        addEdge(source, 2, 2, 30);
        addEdge(1, 2, 2, 10);
        addEdge(1, sink, 0, 9999);
        addEdge(2, sink, 4, 10);

        getMinCostMaxFlow();

        System.out.println(maxFlow + " " + minCostMaxFlow);
    }

    static class Edge{
        int from;
        int to;
        int flow;
        int capacity;
        int cost;
        Edge backward;

        public Edge(int from, int to, int flow, int capacity, int cost) {
            this.from = from;
            this.to = to;
            this.flow = flow;
            this.capacity = capacity;
            this.cost = cost;
        }
    }
}
