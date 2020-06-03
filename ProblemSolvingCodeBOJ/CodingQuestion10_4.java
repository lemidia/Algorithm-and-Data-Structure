public class CodingQuestion10_4 {
    // We can't use size or length method of an array in the solution method
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,13,15,20,31,33,40,50,100};
        int target = 13;

        int answer = solution(arr, target);
        System.out.println(answer);
    }

    public static int solution(int arr[], int target) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = (int)(Math.ceil((left + (long)right) / 2.0));
            if (elementAt(mid, arr) == -1)
                right = mid - 1;
            else
                left = mid;
        }

        int limitIdx = left;


        left = 0;
        right = limitIdx;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target){
                left = mid + 1;
            } else
                return mid;
        }

        // Not Found
        return -1;
    }

    public static int elementAt(int i, int arr[]) {
        if (i > arr.length - 1)
            return -1;
        else
            return arr[i];
    }
}
