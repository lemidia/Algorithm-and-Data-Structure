public class SparseTable {
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

    public static void main(String[] args) {
        int arr[] = {-1, 3, 2, -5, 1, 7, 0};
        int n = arr.length;
        int row = (int)baseLog(n, 2);
        int sparseTable[][] = new int[row + 1][n];
        int indexTable[][] = new int[row + 1][n];
        construct(sparseTable, indexTable, row, n, arr);

        /*
            Sparse Table for Min Query value

            -1   3   2   -5   1   7   0
            -1   2  -5   -5   1   0   x
            -5  -5  -5   -5   x   x   x

            Index Table for Min Query index

            0  1  2  3  4  5  6
            0  2  3  3  4  6  x
            3  3  3  3  x  x  x


        for (int i = 0; i <= row; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(sparseTable[i][j] + "  ");
            }
            System.out.println();
        }
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(indexTable[i][j] + "  ");
            }
            System.out.println();
        }
        */

        // Output: -5
        System.out.print("Min Query value is " + minQuery(sparseTable, 0, 6));
        // Output: 3 (index)
        System.out.println(" and located at index : " + minQueryIndex(sparseTable, indexTable, 0, 6));
    }
}
