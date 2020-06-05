public class CodingQuestion17_11 {
    public static boolean isValid(int a, int b, int n) {
        return 0<=a && a<n && 0<= b && b<n;
    }

    static int max = -1;
    static int arr[][] = {
            {0, 1, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 1},
            {0, 1, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 1},
            {0, 1, 0, 1, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 1},
            {0, 1, 1, 1, 0, 0, 1}
    };

    public static void dot1() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 1) {
                    dot2(new Point(i, j));
                }
            }
        }
    }

    public static void dot2(Point dot1) {
        for (int i = dot1.c+1; i <arr.length; i++) {
            if (arr[dot1.r][i] == 1)
                check(dot1, new Point(dot1.r, i));
        }
    }

    public static void check(Point dot1, Point dot2) {
        int diff = dot2.c - dot1.c;
        if (isValid(dot1.r + diff, dot2.r + diff, arr.length)
                && arr[dot1.r + diff][dot1.c] == 1 && arr[dot2.r + diff][dot2.c] == 1) {
            int square =  (int)Math.pow(diff+1, 2);
            if (max < square)
                max = square;
        }
    }

    public static void main(String[] args) {
        dot1();
        System.out.println(max);
    }

    static class Point {
        private int r;
        private int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}


