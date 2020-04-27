public class Combination {
    public static void combination(String str, char characters[], int bound, int depth, int next){
        if (depth == bound){
            for (int i = 0; i < bound; i++) {
                System.out.print(characters[i]);
            }
            System.out.println();
            return;
        }

        for (int i = next; i < str.length(); i++) {
            characters[depth] = str.charAt(i);
            combination(str, characters, bound, depth + 1, i + 1);
        }
    }

    public static void main(String[] args) {
        String str = "12345";
        char characters[] = new char[str.length()];
        int r = 3;

        // prints:
        // 123
        // 124
        // 125
        // 134
        // 135
        // 145
        // 234
        // 235
        // 245
        // 345
        combination(str, characters, r, 0, 0);
    }
}
