import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class DijkstraAlgorithm{
    static int n, m;
    static int dist[];
    static int check[];
    static Integer prev[];
    static ArrayList<Edge> adjecentGraph[];

    static void dijkstra(int s, int e){ // Single Source Shortest Path (SSSP)
        // Import priority queue : Insert O(log n)
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.cost, o2.cost); // Non decreasing order of each node cost
            }
        });

        Arrays.fill(dist, Integer.MAX_VALUE); // Init all the destination
        dist[s] = 0;                          // Init that start is 0
        priorityQueue.offer(new Edge(s, 0));
        while (!priorityQueue.isEmpty()){
            Edge t = priorityQueue.poll();
            int cur = t.to;
            int curCost = t.cost;
            // If minCost in the priority queue is greater than
            // current cost then skip.
            // This means that stale outdated node is skipped
            if (dist[cur] < curCost) continue;
            check[cur] = 1; // Visited cur node
            for (Edge nx : adjecentGraph[cur]){
                if (check[nx.to] == 1) // if nx node has been visited
                    continue;
                int newDist = curCost + nx.cost;
                if (dist[nx.to] > newDist){ // If newDist is less than dist of cur's next dist
                    dist[nx.to] = newDist;  // Edge relaxation
                    priorityQueue.offer(new Edge(nx.to, newDist)); // Insert relaxed edge
                    //prev[nx.to] = cur; //Path
                }
            }
            if (cur == e)
                return;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n+1];
        check = new int[n+1];
        prev = new Integer[n+1];
        adjecentGraph = new ArrayList[n+1];
        // Init Graph
        for (int i = 0; i < n+1; i++)
            adjecentGraph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            adjecentGraph[Integer.parseInt(st.nextToken())].add(new Edge(
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())
            ));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        dijkstra(s, e); // Operate Dijkstra Algorithm
        System.out.print(dist[e]);

        /* Path Print
        System.out.println();
        for (Integer i = e; i != null ; i = prev[i]) {
            sb.append(i).append(">-"); // i.e 1 -> 2 -> 3 ... 5
        }
        System.out.print(sb.reverse().delete(0, 2));
        */
    }
    static class Edge{ // Edge information
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}