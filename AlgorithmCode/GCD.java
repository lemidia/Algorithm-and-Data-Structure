public class GCD {
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a%b);
    }
    public static void main(String[] args) {
        System.out.println(gcd(8, 12));

        // Output:
        // 4
    }
}
