public class MaximumSumSubArray {
    public static void maximumSumSubArray (int arr[]) {
        int maximumSum = 0;
        int currentMaximumSum = 0;

        int i = 0;
        while (i < arr.length) {
            currentMaximumSum += arr[i];
            if (currentMaximumSum < 0)
                currentMaximumSum = 0;
            else {
                if (currentMaximumSum > maximumSum)
                    maximumSum = currentMaximumSum;
            }
            i++;
        }

        System.out.println(maximumSum);
    }

    public static void main(String[] args) {
        int arr [] = {5,7,-13,2,8,10};
        maximumSumSubArray(arr);
    }
}
