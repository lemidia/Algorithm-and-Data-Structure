import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();

        System.out.print(longestCommonSubsequence(str1, str2, str3));
    }

    public static int longestCommonSubsequence(String str1, String str2, String str3) {
        int LCS_Arr[][][] = new int[str1.length()+1][str2.length()+1][str3.length()+1];
        for (int i = 1; i < str1.length()+1; i++) {
            for (int j = 1; j < str2.length()+1; j++) {
                for (int k = 1; k < str3.length()+1; k++) {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1) && str3.charAt(k-1) == str2.charAt(j - 1)) {
                        LCS_Arr[i][j][k] = LCS_Arr[i - 1][j - 1][k -1] + 1;
                    } else {
                        LCS_Arr[i][j][k] = Math.max(LCS_Arr[i - 1][j][k], Math.max(LCS_Arr[i][j - 1][k], LCS_Arr[i][j][k-1]));
                    }
                }
            }
        }
        return LCS_Arr[str1.length()][str2.length()][str3.length()];
    }
}
