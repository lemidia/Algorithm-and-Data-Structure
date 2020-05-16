public class Fibonacci_Recursion {
    public int solution(int n) {
        int answer;
        int memo[] = new int[n+1];
        answer = fibo(n, memo);
        return answer;
    }

    public int fibo (int n, int memo[]) {
        if (n <= 2)
            return 1;
        if (memo[n] != 0)
            return memo[n];
        int tmp = (fibo(n-1, memo) + fibo(n-2, memo));
        return memo[n] = tmp;
    }

    public static void main(String[] args) {
        Fibonacci_Recursion f = new Fibonacci_Recursion();
        // 1 1 2 3 5 8 13 21 34 55
        System.out.println(f.solution(10));

        // Output:
        // 55
    }
}
