import java.util.Arrays;

public class Eratosthenes {
    private static final int MAX = 100;
    public static void main(String[] args) {

        boolean [] flag = new boolean[MAX];
        Arrays.fill(flag, true);
        eratosthenes(flag, MAX);
        for (int i = 2; i < flag.length; i++){
            if (flag[i]){
                System.out.println(i + " is prime number");
            }
        }
    }

    public static void eratosthenes(boolean[] flag, int k){
        for (int i = 2; i*i < k ; i++) {
            if (flag[i]){
                for (int j = i*i; j < k ; j+=i) {
                    flag[j] = false;
                }
            }
        }
    }
}
