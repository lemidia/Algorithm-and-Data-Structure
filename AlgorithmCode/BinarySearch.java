public class BinarySearch {
    public static boolean binarySearch(int arr[],int k){
        int left = 0;
        int right = arr.length-1;
        int mid;
        while (left<=right){
            mid = (right + left) / 2;
            if(arr[mid] > k){
                right = mid-1;
            }
            else if(arr[mid] < k){
                left = mid+1;
            }
            else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 6, 7, 10, 15, 18, 20};
        // The given array must be sorted before performing a binary search.
        if (binarySearch(arr, 7)) 
            System.out.print("Exist");
        else
            System.out.print("Not Exist");
    }
}
