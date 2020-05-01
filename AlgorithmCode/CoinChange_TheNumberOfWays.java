import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  This Code is to calculate the number of ways to make the total value having a given coins.
 *
 *  Dynamic Programming (Bottom Up)
 *
 * @Author Gyeong, lemidia
 */

public class CoinChange_TheNumberOfWays {

    public static void solve(int n, int m, int dp[][], int coins[]) {
        for (int i = 1; i <=m ; i++) {
            for (int j = 0; j <= n; j++) {
                if (j >= coins[i]) {
                    // We include the coins[i] to the total value
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]];
                } else {
                    // We exclude the coins[i] to the total value
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
    }

    // Dp Table will be made like below on a given sample input
    //
    //     0 1 2 3 4 5
    // - | -----------
    // 0 | 1 0 0 0 0 0
    // 1 | 1 1 1 1 1 1
    // 2 | 1 1 2 2 3 3
    // 3 | 1 1 2 3 4 5

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Sample input:
        // 5  <- n - Total value
        // 3  < - m - The Number of coins we have
        // 1 2 3  <- m coins

        // Total value
        int n = Integer.parseInt(br.readLine());
        // The Number of coins we have
        int m = Integer.parseInt(br.readLine());

        int coins[] = new int[m+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < coins.length ; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int dp[][] = new int[m+1][n+1];
        dp[0][0] = 1;

        solve(n, m, dp, coins);

        // 5 ways to make total value on a given input
        // 1 1 1 1 1
        // 1 1 1 2
        // 1 2 2
        // 1 1 3
        // 2 3

        // Output:
        // 5
        System.out.println(dp[m][n]);
    }
}
