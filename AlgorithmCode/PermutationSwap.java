public class PermutationSwap {

    public static void swap(char arr[], int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void permutation (char arr[], int depth) {
        if (depth == arr.length) {
            for (char ch : arr)
                System.out.print(ch + " ");
            System.out.println();
            return;
        }

        for (int i = depth; i < arr.length; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1);
            swap(arr, depth, i);
        }
    }

    public static void main(String[] args) {
        char characterArr[] = "ABC".toCharArray();
        permutation(characterArr, 0);

        // Output:
        // A B C
        // A C B
        // B A C
        // B C A
        // C B A
        // C A B
    }
}
