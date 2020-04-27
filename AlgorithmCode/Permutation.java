public class Permutation {
    public static void permutation(String str, boolean visited[], char characters[], int bound, int depth){
        if (depth == bound){
            for (int i = 0; i < bound; i++) {
                System.out.print(characters[i]);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (visited[i] != true){
                visited[i] = true;
                characters[depth] = str.charAt(i);
                permutation(str, visited, characters, bound, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String str = "abcd";
        boolean visited[] = new boolean[str.length()];
        char characters[] = new char[str.length()];
        int r = 2;

        /*  print

            ab
            ac
            ba
            bc
            ca
            cb
        */
        permutation(str, visited, characters, r, 0);
    }
}
