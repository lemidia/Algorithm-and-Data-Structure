import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// This Code doesn't work for the input like coins(2, 3, 4) etc...

public class CoinChange_MinNumberOfCoins {

    public static int min (int a, int b) {
        return a < b ? a : b;
    }

    public static void solve(int n, int m, int dp[][], int coins[]) {

        for (int i = 0; i <=n; i++)
            dp[0][i] = i;

        for (int i = 1; i <m ; i++) {
            for (int j = 0; j <= n; j++) {
                if ( j < coins[i]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i]] + 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input:
        // 10
        // 4
        // 1 5 6 9

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int coins[] = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < coins.length ; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int dp[][] = new int[m][n+1];

        solve(n, m, dp, coins);

        // Output:
        // 2
        System.out.println(dp[m-1][n]);
    }
}
