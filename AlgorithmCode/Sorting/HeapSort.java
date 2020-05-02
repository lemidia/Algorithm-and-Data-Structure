package Sorting;

public class HeapSort {
    public static int[] heapSort(int arr[]) {
        int sz = arr.length;

        // Heap construction
        int lastIdx = sz-1;
        for (int i = (lastIdx-1)/2 ; i >= 0; i--)
            heapify(arr, i, sz);

        int sortedArr[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            sortedArr[i] = arr[0];
            swap(0, sz-1, arr);
            sz--;
            heapify(arr, 0, sz);
        }

        return sortedArr;
    }

    public static void heapify(int arr[], int at, int sz) {
        int nextChildIdx = (at * 2) + 1;
        if (nextChildIdx >= sz)
            return;
        int rightChildIdx =  (at * 2) + 2;
        if (rightChildIdx < sz && arr[nextChildIdx] > arr[rightChildIdx]) {
            nextChildIdx = rightChildIdx;
        }

        if (arr[at] > arr[nextChildIdx]) {
            swap(at, nextChildIdx, arr);
            heapify(arr, nextChildIdx, sz);
        } else
            return;
    }

    public static void swap(int a, int b, int arr[]) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int min (int a, int b) {
        return a < b ? a : b;
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 0, 15, 7, 3, 23, 11};
        int sortedArr[] = heapSort(arr);
        for (int elem : sortedArr)
            System.out.print(elem + " ");
    }
}
