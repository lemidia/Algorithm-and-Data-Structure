public class SparseTable {

    static boolean isValid(int j, int i, int n) {
        return j + (int)Math.pow(2, i) <= n;
    }

    static int min(int a, int b) {
        return a < b ? a : b;
    }

    static double baseLog(double x, double base){
        return Math.log(x) / Math.log(base);
    }

    static void construct(int sparseTable[][], int row, int n, int arr[]) {
        for (int i = 0; i < n; i++)
            sparseTable[0][i] = arr[i];
        for (int i = 1; i <= row; i++) {
            for (int j = 0; j < n; j++) {
                if (isValid(j, i, n)) {
                    sparseTable[i][j] = min(sparseTable[i-1][j], sparseTable[i-1][j+(int)Math.pow(2, i-1)]);
                }
            }
        }
    }

    static int minQuery(int sparseTable[][], int l, int r) {
        int p = (int)baseLog(r-l+1, 2);
        int k = (int)Math.pow(2, p);

        return min(sparseTable[p][l], sparseTable[p][r-k+1]);
    }

    public static void main(String[] args) {
        int arr[] = {-1, 3, 2, -5, 1, 7, 0};
        int n = arr.length;
        int row = (int)baseLog(n, 2);
        int sparseTable[][] = new int[row + 1][n];
        construct(sparseTable, row, n, arr);
        /*
            -1   3   2   -5   1   7   0
            -1   2  -5   -5   1   0   x
            -5  -5  -5   -5   x   x   x
         */
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(sparseTable[i][j] + "  ");
            }
            System.out.println();
        }
        // output: -5
        System.out.println(minQuery(sparseTable, 0, 6));
    }
}
