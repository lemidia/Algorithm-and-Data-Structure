import java.util.Arrays;
import java.util.LinkedList;

public class LongestIncreasingSubSequence {

    public static void LIS(int arr[]) {
        if (arr.length == 0)
            return;
        int dp[] = new int[arr.length];
        int sequence[] = new int[arr.length];
        int longestLength = 1;
        int longestLengthPosition = -1;

        Arrays.fill(dp, 1);
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = i;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    if (longestLength < dp[i]){
                        longestLength = dp[i];
                        longestLengthPosition = i;
                    }
                    sequence[i] = j;
                }
            }
        }

        System.out.println("LIS is " + longestLength);

        LinkedList<Integer> list = new LinkedList<>();

        int i = longestLengthPosition;

        for ( ; i != sequence[i]; i = sequence[i]) {
            list.addFirst(arr[i]);
        }

        list.addFirst(arr[i]);

        System.out.print("Sub Sequence is ");

        for (int next : list)
           System.out.print(next + " ");
        
    }
    public static void main(String[] args) {
        int arr1 [] = {2, 4, 1, 5, 10, 14, 0, 7, 9, 11, 17};
        // Output:
        // LIS is 7
        // Sub Sequence is 2 4 5 7 9 11 17 
        LIS(arr1);
    }
}
