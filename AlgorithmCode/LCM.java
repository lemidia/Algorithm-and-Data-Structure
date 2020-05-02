public class LCM {
    static class GCD {
        public static int gcd(int a, int b) {
            if (b == 0)
                return a;
            return gcd(b, a%b);
        }
    }
    
    public static void main(String[] args) {
        int a = 8;
        int b = 12;
        System.out.println((a*b)/GCD.gcd(a, b));
    }
}