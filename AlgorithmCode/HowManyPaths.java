import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HowManyPaths {

    static int n, m;
    static int DP[][];
    static int arr[][];
    static int[][] obstacles = {{1, 2}, {3, 2}, {1, 4}};
    static boolean isValid(int a, int b) {
        return 0<=a && a < n && 0<=b && b < m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        DP = new int[n][m];
        for (int i = 0; i < obstacles.length; i++) {
            arr[obstacles[i][0]][obstacles[i][1]] = 1;
        }
        howManyPathsAreThere(arr, 0, 0);
        System.out.print(DP[0][0]);
    }

    public static int howManyPathsAreThere(int arr[][], int r, int c) {
        if (!isValid(r, c) || arr[r][c] == 1)
            return 0;
        if (r == n-1 && c == m-1)
            return 1;
        // memoization
        if (DP[r][c] != 0)
            return DP[r][c];
        DP[r][c] = howManyPathsAreThere(arr, r+1, c) + howManyPathsAreThere(arr, r, c+1);
        return DP[r][c];
    }
}
