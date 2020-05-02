import java.util.ArrayList;

public class CycleDetectionOnUndirectedGraph {

    public static void addEdge(int a, int b, ArrayList<Edge> edgeList) {
        edgeList.add(new Edge(a, b));
    }

    public static void main(String[] args) {
        // Sample Graph Representation

        // 2 <--> 4 <--> 5
        // ^      ^
        // |      |
        // v      v
        // 0 <--> 3 <--> 1

        int n = 6;
        // Construct Graph As Edge List 
        ArrayList<Edge> edgeList = new ArrayList<>();
        addEdge(2, 0, edgeList);
        addEdge(0, 3, edgeList);
        addEdge(2, 4, edgeList);
        addEdge(3, 4, edgeList);
        addEdge(4, 5, edgeList);
        addEdge(1, 3, edgeList);

        UnionFind uf = new UnionFind(n);
        uf.makeSet();

        boolean isCycle = false;

        for (Edge edge : edgeList) {
            int root1 = uf.find(edge.a);
            int root2 = uf.find(edge.b);

            if (root1 == root2) {
                isCycle = true;
                System.out.println("There is cycle!");
                break;
            } else {
                uf.union(root1, root2);
            }
        }

        if (!isCycle) {
            System.out.println("There is no cycle");
        }
    }

    static class Edge {
        int a;
        int b;

        public Edge(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }


    // Github repo :
    // https://github.com/lemidia/Algorithm-and-Data-Structure/blob/master/DataStructure/UnionFind.java

    static class UnionFind {
        private int parent[];
        private int rank[];
        private int n;

        UnionFind(int cnt) {
            this.n = cnt;
            parent = new int[n];
            rank = new int[n];
        }

        public void makeSet() {
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] == x)
                return x;
            else
                return parent[x] = find(parent[x]); // * 경로 압축
        }

        public void union(int root1, int root2) {
            root1 = find(root1);
            root2 = find(root2);

            if (root1 == root2) // 루트가 같다면 수행하지 않는다.
                return;

            if (rank[root1] >= rank[root2]) { // 루트1의 랭크가 루트2의 랭크보다 크다면
                parent[root2] = parent[root1]; //루트2가 루트1의 밑으로 합친다
            } else { // 위의 if문 과 반대
                parent[root1] = parent[root2];
            }
            if (rank[root1] == rank[root2])
                rank[root1]+=1;
        }
    }
}
