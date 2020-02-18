import java.util.LinkedList;

public class DFSRecursion {

    static class Graph{
        int vertices;
        LinkedList<Integer>[] adjList;

        Graph(int vertices){
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i <vertices ; i++) {
                adjList[i] = new LinkedList<>();
            }
        }
        public void addEgde(int source, int destination){
            adjList[source].add(destination);
            adjList[destination].add(source);
        }

        public void DFSRecursion(int startVertex){
            boolean [] visited = new boolean[vertices];
            dfs(startVertex, visited);
        }

        public void dfs(int start, boolean [] visited){
            visited[start] = true;
            System.out.print(start + " ");
            for (int i = 0; i <adjList[start].size() ; i++) {
                int destination = adjList[start].get(i);
                if(!visited[destination])
                    dfs(destination,visited);
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEgde(0, 1);
        graph.addEgde(0, 2);
        graph.addEgde(0, 3);
        graph.addEgde(1, 2);
        graph.addEgde(2, 4);
        graph.DFSRecursion(0);
    }
}