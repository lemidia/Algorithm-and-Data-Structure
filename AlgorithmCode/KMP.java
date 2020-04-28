/**
 *  This code is to conduct pattern matching of given str and pattern
 *
 * @Author Gyeong - lemidia
 */

public class KMP {
    public static void kmp (String str, String pattern) {
        int lps[] = LPS(pattern);
        int i = 0;
        int j = 0;

        while (i < str.length()) {
            if (str.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    int foundIdx = i - pattern.length() + 1;
                    System.out.println("The pattern was found at index " + foundIdx + " of the text.");
                    i++;
                    j = lps[j];
                } else {
                    i++;
                    j++;
                }
            } else {
                if (j == 0)
                    i++;
                else
                    j = lps[j-1];
            }
        }
    }

    // Construct an LPS array that represents proper
    // prefix which is also suffix of the given pattern
    public static int[] LPS (String pattern) {
        int lps[] = new int[pattern.length()];
        int i = 1;
        int j = 0;

        // While less than lps or pattern length
        while (i < lps.length) {
            if (pattern.charAt(j) == pattern.charAt(i)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                // There is no more space to go to left
                // So, just increment the i's index by 1
                if (j == 0)
                    i++;
                // We go to the previous index.
                // And look up Longest proper prefix which is
                // also suffix of previous string
                // And Let this be j
                else
                    j = lps[j-1];
            }
        }
        return lps;
    }
    public static void main(String[] args) {
        String str = "abababacd";
        String pattern = "aba";
        /*
        
        Output:
        The pattern was found at index 0 of the text.
        The pattern was found at index 2 of the text.
        The pattern was found at index 4 of the text.
        
         */
        kmp(str, pattern);
    }
}
