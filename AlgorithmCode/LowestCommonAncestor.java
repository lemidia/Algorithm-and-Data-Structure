/**
 *  @Author Gyeong Lemidia, https://github.com/lemidia
 * 
 *  LCA Algorithm code written in java
 *  Euler Tour + Sparse Table for RMQ(Range Minimum Query)
 */

public class LowestCommonAncestor {

    // Below is code for Sparse Table

    static int min (int a, int b) {
        return a < b ? a : b;
    }

    static boolean isValid(int j, int i, int n) {
        return j + (int)Math.pow(2, i) <= n;
    }

    static double baseLog(double x, double base){
        return Math.log(x) / Math.log(base);
    }

    static void construct(int sparseTable[][], int indexTable[][], int row, int n, int arr[]) {
        for (int i = 0; i < n; i++){
            sparseTable[0][i] = arr[i];
            indexTable[0][i] = i;
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 0; j < n; j++) {
                if (isValid(j, i, n)) {
                    if (sparseTable[i-1][j] < sparseTable[i-1][j+(int)Math.pow(2, i-1)]) {
                        sparseTable[i][j] = sparseTable[i-1][j];
                        indexTable[i][j] = indexTable[i-1][j];
                    }else {
                        sparseTable[i][j] = sparseTable[i-1][j+(int)Math.pow(2, i-1)];
                        indexTable[i][j] = indexTable[i-1][j+(int)Math.pow(2, i-1)];
                    }
                }
            }
        }
    }

    static int minQuery(int sparseTable[][], int l, int r) {
        int p = (int)baseLog(r-l+1, 2);
        int k = (int)Math.pow(2, p);

        return min(sparseTable[p][l], sparseTable[p][r-k+1]);
    }

    static int minQueryIndex(int sparseTable[][], int indexTable[][], int l , int r) {
        int p = (int)baseLog(r-l+1, 2);
        int k = (int)Math.pow(2, p);

        if (sparseTable[p][l] < sparseTable[p][r-k+1]) {
            return indexTable[p][l];
        }else {
            return indexTable[p][r-k+1];
        }
    }

    // Code for Sparse Table End

    // Below is code for LCA

    static int tourIndex = 0;

    static int max (int a, int b) {
        return a > b ? a : b;
    }

    static class TreeNode {
        int index;
        TreeNode children[];

        public TreeNode(int index) {
            this.index = index;
            children = new TreeNode[2];
        }
    }

    /*

    Sample Tree used in this code.

            0
          /   \
         /     \
        1       2
       / \     / \
      /   \   /   \
     3     4  5    6

     LCA of 1,2 = 0
     LCA of 1,0 = 0
     LCA of 3,4 = 1
     LCA of 4,5 = 0
     LCA of 3,3 = 3
     */

    // Do Euler Tour and marking index num for each node
    static void dfs (int depth[], int nodes[], int last[], TreeNode node, int currentDepth) {
        depth[tourIndex] = currentDepth;
        nodes[tourIndex] = node.index;
        last[node.index] = tourIndex;
        tourIndex++;
        for (TreeNode child : node.children) {
            if (child != null){
                dfs(depth, nodes, last, child, currentDepth+1);
                depth[tourIndex] = currentDepth;
                nodes[tourIndex] = node.index;
                last[node.index] = tourIndex;
                tourIndex++;
            }
        }
    }

    static int LCA (int a, int b, int nodes[], int last[], int sparseTable[][], int indexTable[][]) {
        a = last[a];
        b = last[b];
        int minIndex = minQueryIndex(sparseTable, indexTable, min(a, b), max(a, b));
        return nodes[minIndex];
    }

    // Code for LCA End

    // Main method
    public static void main(String[] args) {
        // Construct Sample Tree
        TreeNode root = new TreeNode(0);
        root.children[0] = new TreeNode(1);
        root.children[1] = new TreeNode(2);
        root.children[0].children[0] = new TreeNode(3);
        root.children[0].children[1] = new TreeNode(4);
        root.children[1].children[0] = new TreeNode(5);
        root.children[1].children[1] = new TreeNode(6);

        // Setup Array information for LCA
        int nodeCnt = 7;
        int depth [] = new int[2*nodeCnt-1];
        int nodes [] = new int[2*nodeCnt-1];
        int last [] = new int[nodeCnt];
        if (root != null)
            dfs(depth, nodes, last, root, 0);

        // Setup Sparse Table for Range Min Query
        // depth 배열로 Sparse Table 을 구축한다.
        int colCnt = 2*nodeCnt-1;
        int row = (int)baseLog(colCnt, 2);
        int sparseTable[][] = new int[row+1][colCnt];
        int indexTable[][] = new int[row+1][colCnt];
        construct(sparseTable, indexTable, row, colCnt, depth);

        int result = LCA(4, 5, nodes, last, sparseTable, indexTable);
        // Output : 0
        System.out.print(result);
    }
}
