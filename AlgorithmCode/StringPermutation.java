public class StringPermutation {
    public static void main(String[] args) {
        String str = "asfa";
        boolean visited[] = new boolean[str.length()];
        char characters[] = new char[str.length()];

        permutaion(str, visited, characters, str.length(), 0);
    }

    public static void permutaion(String str, boolean visited[], char characters[], int bound, int depth){
        if (depth == bound){
            for (int i = 0; i < bound; i++) {
                System.out.print(characters[i]);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < bound; i++) {
            if (visited[i] != true){
                visited[i] = true;
                characters[depth] = str.charAt(i);
                permutaion(str, visited, characters, bound, depth + 1);
                visited[i] = false;
            }
        }
    }
}
