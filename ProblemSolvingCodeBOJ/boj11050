
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int dp[][] = new int[1001][1001];
    /** Recursive + memoization
     *
    static int dp[][] = new int[10001][10001];

    static int bicoeff(int n, int k){
        if(n == k || k == 0)
            return 1;
        else if(dp[n][k] !=0)
            return dp[n][k];
        dp[n][k] = bicoeff(n-1, k-1) + bicoeff(n-1, k);
        return dp[n][k]%10007;
    }

    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp[1][0] = 1; dp[1][1] =1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if(i == j ||j ==0)
                    dp[i][j] = 1;
                else{
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                    dp[i][j]%=10007;
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
