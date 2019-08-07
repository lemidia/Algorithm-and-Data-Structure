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
            }
        }
        if (cur == e)
            return;
    }
}