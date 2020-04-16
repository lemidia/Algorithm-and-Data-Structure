import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SegmentTree {
    static long init(long segmentTree[], long arr[], int node, int start, int end){
        if(start == end)
           return segmentTree[node] = arr[start];

        int mid = (start+end)/2;
        return segmentTree[node] = init(segmentTree, arr, node*2, start, mid)
                + init(segmentTree, arr, node*2+1, mid+1, end);

    }
    static void update(long segmentTree[], int node, int index, int start, int end, long diff){
        if(index < start || index > end )
            return;
        segmentTree[node] += diff;
        if(start != end){
            int mid = (start+end)/2;
            update(segmentTree, node*2, index, start, mid, diff);
            update(segmentTree, node*2+1, index,mid+1, end, diff);
        }
    }

    static long sum(long segmentTree[], int node, int left, int right, int start, int end){
        if(right < start || left > end)
             return 0;

        if(left <= start && end <= right)
            return segmentTree[node];

        int mid = (start+end)/2;
        return sum(segmentTree, node*2, left, right, start, mid) +
                sum(segmentTree, node*2+1, left, right, mid+1, end);
    }
    static double baseLog(double x, double base){
        return Math.log(x) / Math.log(base);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long arr[] = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        int h = (int)Math.ceil(baseLog(N, 2));
        long segmentTree[] = new long[1<<(h+1)];
        init(segmentTree, arr, 1, 0, N-1);
        M+=K;
        while (M-- > 0){
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            if(t1 == 1){
                int t2 = Integer.parseInt(st.nextToken());
                t2-=1;
                long t3 = Long.parseLong(st.nextToken());
                long diff  = t3 - arr[t2];
                arr[t2] = t3;
                update(segmentTree, 1, t2, 0, N-1, diff);

            }else if(t1 == 2){
                int t2 = Integer.parseInt(st.nextToken());
                int t3 = Integer.parseInt(st.nextToken());
                sb.append(sum(segmentTree, 1, t2-1, t3-1, 0, N-1)).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
