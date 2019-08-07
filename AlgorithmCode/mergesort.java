public class mergeSort {
    static void divide(int data[], int p, int r){
        if(p<r){
            int q = (p+r)/2;
            divide(data, p, q);
            divide(data,q+1, r);
            merge(data, p, q, r);
        }
    }

    static void merge(int data[], int p, int q, int r){
        int i = p; int j = q+1; int k = p;
        int temp[] = new int[data.length];

        /*
        while (i<=q && j<=r){
            if(data[i] <= data[j]){
                temp[k++] = data[i++];
            }else{
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
        */

        for (int l = p; l <r+1 ; l++) {
            if (i<=q && (j>r || data[i] < data[j])){
                temp[k++] = data[i++];
            }else
                temp[k++] = data[j++];
        }
        for(int l = p; l<=r; l++){
            data[l] = temp[l];
        }

    }

    public static void main(String[] args) {
        int limit = 10;
        int arr[] = new int[limit];


        for(int i = limit-1; i>=0; --i){
            arr[i] = limit-i;
        }
        divide(arr, 0, limit-1);
    }
}
