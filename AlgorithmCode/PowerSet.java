import java.util.*;

public class PowerSet {
    public static void powerSet(int depth, char arr[], int bits[], Set<Set<Character>> sets) {
        if (depth == arr.length) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < arr.length; i++) {
                if (bits[i] == 1)
                    set.add(arr[i]);
            }
            sets.add(set);
            return;
        }
        bits[depth] = 1;
        powerSet(depth + 1, arr, bits, sets);
        bits[depth] = 0;
        powerSet(depth + 1, arr, bits, sets);
    }

    public static void main(String[] args) {
        char arr[] = {'a', 'b', 'c'};
        int bits[] = new int[arr.length];
        Set<Set<Character>> sets = new HashSet<>();
        powerSet(0, arr, bits, sets);

        for (Set<Character> set : sets)
            System.out.println(set);
    }
}