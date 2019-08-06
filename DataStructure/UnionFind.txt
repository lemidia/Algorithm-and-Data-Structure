class unionFind {
    private int parent[];
    private int rank[];
    private int n;

    unionFind(int cnt) {
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