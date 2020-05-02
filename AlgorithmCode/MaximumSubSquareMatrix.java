public class MaximumSubSquareMatrix {
    public static int solve(int arr[][]) {
        int dp[][] = new int[arr.length+1][arr[0].length+1];

        for (int i = 1; i < dp.length ; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr[i-1][j-1] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
        return dp[arr.length][arr[0].length];
    }
    public static void main(String[] args) {
        // Sample Input:
        //
        // 0 0 1 1 1
        // 1 0 1 1 1
        // 0 1 1 1 1
        // 1 0 1 1 1

        int arr[][] = {
                {0, 0, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1},
        };
        int l = solve(arr);
        System.out.println("Maximum Sub Square Matrix is " + l*l);
        
        // Output:
        // Maximum Sub Square Matrix is 9
    }
}
