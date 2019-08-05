import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class binarySearch {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int T = Integer.parseInt(br.readLine());
        int arr1[] = new int[T];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(st1.nextToken());
        }
        for (int i = 0; i < T; i++) {
            if(BS(arr, arr1[i]) == true){
                System.out.println('1' + " ");
            }else
                System.out.println('0' + " ");
        }
    }
    public static boolean BS(int arr[],int k){
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
}