public class CountInversionsInAnArray {

    /** This code counts Inversions of a given array using merge sort
     *  Time Complexity : O(nlogn)
     *
     *  @author lemidia
     */
    
        static public class MergeSort {
    
        public int divide(int data[], int p, int r){
            // inversions count var
            int inversion = 0;
    
            if(p<r){
                int q = (p+r)/2;
                inversion += divide(data, p, q);
                inversion += divide(data,q+1, r);
                inversion += merge(data, p, q, r);
            }
    
            return inversion;
        }
    
        public int merge(int data[], int p, int q, int r){
            int i = p; int j = q+1; int k = p;
            int temp[] = new int[data.length];
    
            // inversions count var
            int inversion = 0;
    
            while (i<=q && j<=r){
                if(data[i] <= data[j]){
                    temp[k++] = data[i++];
                }else{
                    // i<j이면서 data[i] > data[j]인 경우이므로 역전관계이다.
                    // left sub array와 right sub array는 이미 정렬이 완료된 상태이고 (여기서는 오름차순)
                    // i<j이면서 data[i] > data[j] 이면 data[j]보다 큰 원소들이 left sub array에
                    // (q+1)-i개 있게 된다.
                    
                    inversion += (q+1)-i;
                    temp[k++] = data[j++];
                }
            }
    
            while (i<=q)
                temp[k++] = data[i++];
            while (j<=r)
                temp[k++] = data[j++];
            for(int l = p; l<=r; l++){
                data[l] = temp[l];
            }
    
            return inversion;
        }
    }
    
    public static void main(String[] args) {
        int limit = 10;
        int arr[] = new int[limit];

        // Sample Array is {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}
        // The number of inversion Count will be 45
        // (9,8), (9,7) ... (2,0), (1,0) = 45 ea

        for(int i = limit-1; i>=0; --i)
            arr[i] = limit-i;

        MergeSort mg = new MergeSort();
        System.out.print("The number of inversion Element is : ");
        System.out.println(mg.divide(arr, 0, arr.length-1));

        // Output:
        // The number of inversion Element is : 45

    }
}
    