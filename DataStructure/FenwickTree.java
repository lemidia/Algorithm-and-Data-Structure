public class FenwickTree {

    private int N;
    private int fenwickTree[];

    public FenwickTree(int N) {
        this.N = N;
        fenwickTree = new int[this.N + 1];
    }

    public void construct(int arr[]) {
        for (int i = 1; i <= N ; i++) {
            fenwickTree[i] += arr[i-1];
            int upCascading = LSB(i) + i;
            if (upCascading <= N)
                fenwickTree[upCascading] += fenwickTree[i];
        }
    }

    public int rangeSumQuery (int l, int r) {
        int leftPrefixSum = prefixSum(l-1);
        int rightPrefixSum = prefixSum(r);

        return rightPrefixSum - leftPrefixSum;
    }

    public int prefixSum(int i) {
        int sum = 0;
        while (i != 0) {
            sum += fenwickTree[i];
            i -= LSB(i);
        }
        return sum;
    }

    public void update(int i, int diff) {
        while (i <= N) {
            fenwickTree[i] += diff;
            i = i + LSB(i);
        }
    }
    
    // Least Significant Bit
    // Ex) 10 = 1010(2) and It's LSB is 0010(2)
    public int LSB(int i) {
        return i & (~i + 1);
    }

    public static void main(String[] args) {
        int arr[] = {6,2,-2,2,9,2,1,8,0,3};
        FenwickTree f = new FenwickTree(arr.length);
        f.construct(arr);

        //Sum of Array value from idx 1 to idx 5
        int leftQueryIdx = 1;
        int rightQueryIdx = 5;

        // Output will be 13
        System.out.println(f.rangeSumQuery(leftQueryIdx+1, rightQueryIdx+1));

        int updateIdx = 2;
        int updateDiffValue = 2;
        f.update(updateIdx + 1, updateDiffValue);

        // Output will be 13 + 2 = 15
        System.out.println(f.rangeSumQuery(leftQueryIdx+1, rightQueryIdx+1));
    }
}
