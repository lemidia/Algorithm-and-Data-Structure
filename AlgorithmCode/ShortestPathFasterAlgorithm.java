import java.io.*;
import java.util.*;
import java.util.LinkedList;

/**
 * This program is to find Shortest path in weighted graph using SPFA.
 * Time Complexity : Worst case : O(VE) same as Standard Bellman ford, Average case : O(E) - not proved
 *
 * @author Lemidia(Gyeong)
 */

public class ShortestPathFasterAlgorithm{

    static int dist[];
    static int n;
    static ArrayList<Edge> [] graph;
    static final int INF = Integer.MAX_VALUE;
    static boolean onQueue[];

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

    static void shortestPathFasterAlgorithm(int s){
        dist = new int[n];
        onQueue = new boolean[n];
        Arrays.fill(dist, INF);
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(s);
        dist[s] = 0;
        onQueue[s] = true;

        while (!queue.isEmpty()){
            int cur = queue.poll();
            onQueue[cur] = false;
            for (Edge e : graph[cur]){
                if (dist[cur] + e.cost < dist[e.to]){
                    dist[e.to] = dist[cur] + e.cost; // Edge Relaxation
                    if (onQueue[e.to] == false){ // Node(e.to) is not in the queue
                        onQueue[e.to] = true;
                        queue.offer(e.to);
                        // Optimization <Small Label First>
                        if (dist[e.to] < dist[queue.peekFirst()]){
                            queue.offerFirst(queue.pollLast());
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(br.readLine());
        createGraph();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            addEdge(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1,
                    Integer.parseInt(st.nextToken()));
        }
        shortestPathFasterAlgorithm(s-1);
        for (int i = 0; i < n; i++) {
            if (dist[i] == INF)
                sb.append("INF").append("\n");
            else
                sb.append(dist[i]).append("\n");
        }
        System.out.print(sb);


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