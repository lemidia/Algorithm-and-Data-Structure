public class SumOfSubset {

    public static boolean solve (int set[], int value, int sum, int depth) {
        if (depth == set.length) {
            if (sum == value)
                return true;
            else
                return false;
        }

        sum+=set[depth];
        if(solve(set, value, sum, depth+1))
            return true;

        sum-=set[depth];
        if(solve(set, value, sum, depth+1))
            return true;

        return false;
    }

    public static void main(String[] args) {

        // Sample Subset
        int set[] = {1, 3, 4, 5, 8, 10};
        int value = 12;

        if (solve(set, value, 0, 0))
            System.out.println("Sebset Exist!");
        else
            System.out.println("Not Exist!");
    }
}
