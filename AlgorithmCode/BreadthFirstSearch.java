import java.util.*;
import java.util.Queue;
import java.util.LinkedList;

public class BreadthFirstSearch{
    static class Graph{
        public int V;
        public LinkedList <Integer> adj[];

        Graph(int v){
            V = v+1;
            adj = new LinkedList[V];
            for(int i = 0; i<V; i++){
                adj[i] = new LinkedList();
            }

        }

        public void addEdge(int a, int b){
            adj[a].add(b);
            adj[b].add(a);
        }

        public void BFS(int start){
            Queue<Integer> queue = new LinkedList<Integer>();
            boolean visited[] = new boolean[V];
            queue.offer(start);
            visited[start] = true;
            while (!queue.isEmpty()){
                int V = queue.poll();
                System.out.print(V + " ");
                for (int i : adj[V]) {
                    if (!visited[i]){
                        queue.offer(i);
                        visited[i] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args){

        Graph g = new Graph(12);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 1);
        g.addEdge(2, 5);
        g.addEdge(2, 6);
        g.addEdge(3, 1);
        g.addEdge(4, 1);
        g.addEdge(4, 7);
        g.addEdge(4, 8);
        g.addEdge(5, 2);
        g.addEdge(5, 9);
        g.addEdge(5, 10);
        g.addEdge(6, 2);
        g.addEdge(7, 4);
        g.addEdge(7, 11);
        g.addEdge(7, 12);
        g.addEdge(8, 4);
        g.addEdge(9, 5);
        g.addEdge(10, 5);
        g.addEdge(11, 7);
        g.addEdge(12, 7);
        System.out.print("Breath First Search : ");
        g.BFS(1);
    }
}