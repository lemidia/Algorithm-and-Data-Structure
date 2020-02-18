/** Dynamic programming
 *
 * The number of case we can climb stairs when we can go up one staircase, two staircases, and three staircases at a time
 */

public class Upstair {
    public static void main(String[] args){
        int n = 5;
        int arr[] = new int[n+1];
        System.out.println(upstair(n, arr)); // print: 13
    }

    public static int upstair(int n, int arr[]){
        if (n <= 1)
            return 1;
        if (n == 2)
            return 2;
        if (arr[n] == 0)
            arr[n] = upstair(n-1, arr) + upstair(n-2, arr) + upstair(n-3, arr);
        return arr[n];
    }
}
