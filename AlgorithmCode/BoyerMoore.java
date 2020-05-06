public class BoyerMoore {

    public static void boyerMoore (String text, String pattern) {
        int i = pattern.length()-1;
        int j = pattern.length()-1;

        while (i <= text.length()-1) {
            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == 0){
                    System.out.println("Pattern matched index at " + i);
                    i += pattern.length();
                    j = pattern.length()-1;
                }
                else {
                    j--;
                    i--;
                }
            } else {
                i = i + pattern.length() - (lastIdx(text.charAt(i), j-1, pattern)+1);
                j = pattern.length()-1;
            }
        }
    }

    public static int lastIdx(char a, int j, String pattern) {
        while (j != -1) {
            if (pattern.charAt(j) == a)
                return j;
            j--;
        }
        return -1;
    }
    public static void main(String[] args) {
        String text = "aabaaabaabada";
        String pattern = "aabaa";
        boyerMoore(text, pattern);
        
        //Output:
        // Pattern matched index at 0
        // Pattern matched index at 4
    }
}
