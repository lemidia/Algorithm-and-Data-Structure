import java.util.ArrayList;
import java.util.List;

public class CenterOfTree {

    public static List<Integer> seekCenterOfTree (List<Integer> graph[]) {
        List<Integer> leaves = new ArrayList<>();
        int degree[] = new int[graph.length];
        int processedLeavesCnt = 0;

        for (int i = 0; i < graph.length; i++) {
            degree[i] = graph[i].size();
            if (degree[i] == 1) {
                leaves.add(i);
                degree[i] = 0;
            }
        }

        processedLeavesCnt = leaves.size();

        while (processedLeavesCnt < graph.length) {
            List<Integer> newLeaves = new ArrayList<>();
            for (int node : leaves) {
                for (int to : graph[node]) {
                    degree[to]--;
                    if (degree[to] == 1) {
                        newLeaves.add(to);
                        degree[to] = 0;
                    }
                }
            }
            processedLeavesCnt += newLeaves.size();
            leaves = newLeaves;
        }
        return leaves;
    }

    public static void addEdge(int a, int b, List<Integer> graph[]) {
        graph[a].add(b);
        graph[b].add(a);
    }

    /*

        Sample Graph

            0 - 6
            |
        1 - 2 - 3 - 5
            |
            4

        Center of Tree is 2

     */

    public static void main(String[] args) {
        List<Integer> graph[] = new ArrayList[7];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        addEdge(0, 2, graph);
        addEdge(0, 6, graph);
        addEdge(1, 2, graph);
        addEdge(2, 3, graph);
        addEdge(2, 4, graph);
        addEdge(3, 5, graph);

        List<Integer> result = seekCenterOfTree(graph);

        for (int center : result)
            // Output will be 2
            System.out.print(center + " ");
    }
}
