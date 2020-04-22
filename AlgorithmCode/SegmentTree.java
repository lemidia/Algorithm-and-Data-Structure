public class SegmentTree {
    static long init(long segmentTree[], long arr[], int node, int start, int end){
        if(start == end)
            return segmentTree[node] = arr[start];

        int mid = (start+end)/2;
        return segmentTree[node] = init(segmentTree, arr, node*2, start, mid)
                + init(segmentTree, arr, node*2+1, mid+1, end);

    }
    static void update(long segmentTree[], int node, int index, int start, int end, long diff){
        // 범위 밖
        if(index < start || index > end )
            return;
        segmentTree[node] += diff;
        if(start != end){
            int mid = (start+end)/2;
            update(segmentTree, node*2, index, start, mid, diff);
            update(segmentTree, node*2+1, index, mid+1, end, diff);
        }
    }

    static long sum(long segmentTree[], int node, int left, int right, int start, int end){
        // 범위 밖 질의
        if(right < start || left > end)
            return 0;

        // 완전히 포함하는 질의
        if(left <= start && end <= right)
            return segmentTree[node];

        // 그 외, 걸치는 범위 질의
        int mid = (start+end)/2;
        return sum(segmentTree, node*2, left, right, start, mid) +
                sum(segmentTree, node*2+1, left, right, mid+1, end);
    }
    
    static double baseLog(double x, double base){
        return Math.log(x) / Math.log(base);
    }

    public static void main(String[] args) {
        long arr[] = {4,7,1,3,9,5,9,2,4};
        int N = arr.length;

        int h = (int)Math.ceil(baseLog(N, 2));
        long segmentTree[] = new long[1<<(h+1)];
        // Construct Segment Tree
        init(segmentTree, arr, 1, 0, N-1);

        // 4 + 7 + 1 + 3 = 15
        System.out.println(sum(segmentTree, 1, 0, 3, 0, N-1));
        // update index(1) as 10. So, we will decide diff as 3.
        update(segmentTree, 1, 1, 0, N-1, 3);
        // 4 + 10 = 14
        System.out.println(sum(segmentTree, 1, 0, 1, 0, N-1));
    }
}
