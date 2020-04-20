/**
 *
 * This program is to sort an array using quick sort algorithm by ascending manner
 * Applied Hoare partition scheme and median of three method as a pivot selecting
 *
 * This implementation is not stable sorting in which the relative position of
 * two elements with the same value is preserved
 *
 * partition:
 *
 * Select a pivot using median of three method
 * Arrange an element that less than or equal pivot key to the left side of pivot
 * Arrange an element that greater than pivot key to the right side of pivot
 *
 * quickSort:
 *
 * recursively Sort left side and right side of pivot respectively
 *
 *
 * Time Complexity:
 *
 * Average case performance: O(nlogn) where n is the number of item in an array
 *
 * Worst case performance: O(n^2)
 *
 * Best case performance: O(nlogn)
 *
 *
 * Space complexity:
 *
 * Worst case space: O(n) auxiliary (naive)
 *
 * @author Gyeong
 *
 */

package Sorting;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int arr[], int start, int end){
        if (start < end){
            int pivot = partition(arr, start, end); // partition
            quickSort(arr, start, pivot-1); // sort left side of pivot recursively
            quickSort(arr, pivot+1, end); // sort right side of pivot recursively
        }
    }

    public static int partition(int arr[], int start, int end){
        int left = start;
        int right = end-1;
        // The median is placed at the end of the array. (end)
        medianOfThree(arr, start, end);
        // Pivot points to median
        int pivot = end;

        // Loop until left is less than or equal right
        while (left <= right){
            // Searching for the item that is greater than pivot item
            while (left <= right && arr[left] <= arr[pivot])
                left++;
            // Searching for the item that is less than or equal pivot item
            while (left <= right && arr[pivot] < arr[right])
                right--;
            // when right is less than left, sub array was sorted
            if (left > right)
                break;

            // Elements smaller than the pivot are placed on the left side of pivot
            // Elements larger than the pivot are placed on the right side of pivot
            swap(arr, left, right);

            left++;
            right--;
        }

        // Arrange pivot item to the proper position of the array
        swap(arr, left, pivot);

        // return pivot index
        return left;
    }

    // Find the median of three numbers and place it at the end of the array
    public static void medianOfThree(int arr[], int left, int right){
        // The smallest of the three numbers is placed before two numbers 
        int mid = (left+right)/2;
        if (arr[mid] < arr[left])
            swap(arr, mid, left);
        if (arr[right] < arr[left])
            swap(arr, right, left);
        // then compare the second and third numbers to determine the median
        if (arr[mid] < arr[right])
            swap(arr, mid, right);
    }

    public static void swap(int arr[], int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{2, 1, 4, 5, 7, 1, 1, 8, 9, 10, 11, 14, 15, 3, 2, 4};
        System.out.println("Before sorting: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length-1);
        System.out.print("After sorting: " + Arrays.toString(arr));
    }
}