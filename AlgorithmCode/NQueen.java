import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class NQueen {
    private static int N;
    private static boolean col[];
    private static boolean diagonal1[];
    private static boolean diagonal2[];
    private static LinkedList<Point> points;

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean nQueenHelper(int n) {
        return nQueen(n, 0);
    }

    public static boolean nQueen(int n, int depth) {
        if (depth == n) {
            return true;
        }

        // Back Tracking
        for (int i = 0; i < n; i++) {
            if (!col[i] && !diagonal1[depth - i + n-1] && !diagonal2[depth + i]) {
                col[i] = true;
                diagonal1[depth - i + n-1] = true;
                diagonal2[depth+i] = true;
                points.add(new Point(depth, i));
                boolean truth = nQueen(n, depth+1);
                if (truth)
                    return true;
                col[i] = false;
                diagonal1[depth - i + n-1] = false;
                diagonal2[depth+i] = false;
                points.remove();
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter the number N : ");
        N = Integer.parseInt(br.readLine());

        col = new boolean[N];
        diagonal1 = new boolean[N*2-1];
        diagonal2 = new boolean[N*2-1];
        points = new LinkedList<>();

        //Output:
        // N Queen exist on 4 x 4 Matrix

        // points:
        // 0 1
        // 1 3
        // 2 0
        // 3 2
        
        if (nQueenHelper(N)) {
            System.out.println("\n" + "N Queen Exist on " + N + " x " + N + " Matrix" + "\n");
            System.out.println("points:");
            for (Point point : points)
                System.out.println(point.x + ", " + point.y);
        } else {
            System.out.println("N Queen doesn't exist on " + N + " x " + N + " Matrix" + "\n");
        }
    }
}
