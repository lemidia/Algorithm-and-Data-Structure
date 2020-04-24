public class BinarySearchRecursive {
    public static boolean binarySearch(int arr[],int k, int left, int right){
        if (left > right)
            return false;
        int mid = (left + right) / 2;
        if (arr[mid] == k)
            return true;
        if (arr[mid] < k)
            return binarySearch(arr, k , mid + 1, right);
        else
            return binarySearch(arr, k, left, mid -1);
    }

    public static void main(String[] args) {
        // The given array must be sorted before performing a binary search.
        int arr[] = {1, 4, 6, 7, 10, 15, 18, 20};
        if (binarySearch(arr, 18, 0, arr.length-1))
            System.out.print("Exist");
        else
            System.out.print("Not Exist");
    }
}