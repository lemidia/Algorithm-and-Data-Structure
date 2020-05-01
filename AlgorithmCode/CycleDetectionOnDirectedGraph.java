import java.util.ArrayList;

public class CycleDetectionOnDirectedGraph {

    public static boolean dfs(int at, ArrayList<Integer> graph[], int visit[]) {
        // 1: Visiting
        visit[at] = 1;

        for (int to : graph[at]) {
            if (visit[to] == 1) {
                return true;
            } else if (visit[to] == 0){
                if (dfs(to, graph, visit))
                    return true;
            }
        }

        // 2: Finished
        visit[at] = 2;
        return false;
    }

    // Add a Direct Edge which is a -> b
    public static void addEdge(int a, int b, ArrayList<Integer> graph[]) {
        graph[a].add(b);
    }

    public static void main(String[] args) {
        // Sample Graph Representation

        // 2 -->4--->5
        // ^    |
        // |    v
        // 0<---3--->1

        int n = 6;
        // Construct Adjacency List Graph
        ArrayList<Integer> graph[] = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        // Add Edges
        addEdge(0, 2, graph);
        addEdge(3, 0, graph);
        addEdge(2, 4, graph);
        addEdge(4, 3, graph);
        addEdge(3, 1, graph);
        addEdge(4, 5, graph);

        boolean isCycle = false;

        // 0:Unvisited, 1: Visiting, 2: Finished
        int visit[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (visit[i] == 0) {
                // If dfs returns true then there is a cycle!
                if (dfs(i, graph, visit)) {
                    System.out.println("Cycle Detected!");
                    isCycle = true;
                }
            }
        }

        if (!isCycle)
            System.out.println("Cycle Not Detected!");
    }
}
