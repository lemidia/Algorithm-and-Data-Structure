public class SegmentTreeMin {
    static long min(long a, long b) {
        return a < b ? a: b;
    }
    static long init(long segmentTree[], long arr[], int node, int start, int end){
        if(start == end)
            return segmentTree[node] = arr[start];

        int mid = (start+end)/2;
        return segmentTree[node] = min(init(segmentTree, arr, node*2, start, mid)
                ,init(segmentTree, arr, node*2+1, mid+1, end));

    }
    static long update(long segmentTree[], int node, int index, int start, int end, long diff){
        // 범위 밖
        if(index < start || index > end )
            return segmentTree[node];
        if(start != end){
            int mid = (start+end)/2;
            return segmentTree[node] = min(update(segmentTree, node*2, index, start, mid, diff),
            update(segmentTree, node*2+1, index, mid+1, end, diff));
        }else {
            return segmentTree[node] += diff;
        }
    }

    static long query(long segmentTree[], int node, int left, int right, int start, int end){
        // 범위 밖 질의
        if(right < start || left > end)
            return Long.MAX_VALUE;

        // 완전히 포함하는 질의
        if(left <= start && end <= right)
            return segmentTree[node];

        // 그 외, 걸치는 범위 질의
        int mid = (start+end)/2;
        return min(query(segmentTree, node*2, left, right, start, mid), query(segmentTree, node*2+1, left, right, mid+1, end));
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

        // Min Of [4,7,1,3,9,5,9,2,4] => 1
        System.out.println(query(segmentTree, 1, 0, N-1, 0, N-1));
        // Update index(1) as -17. So, we will decide diff as -24.
        update(segmentTree, 1, 1, 0, N-1, -24);
        // Min Of [4,-17,1,3,9,5,9,2,4] = -17
        System.out.println(query(segmentTree, 1, 0, N-1, 0, N-1));
    }
}
