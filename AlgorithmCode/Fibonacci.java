/**
 *  Fibonacci sequence using memoization
 */

public class Fibonacci {
    static long dp[] = new long [1<<15];
    public static long f(int n){
        if(n <= 2)
            return 1;
        if(dp[n] == 0)
            dp[n] =  f(n-2)+ f(n-1);
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(f(n)); // print: 55
    }
}
