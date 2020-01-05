import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.LinkedList;

public class boj2644{

    /**
     ** Stub for PS.
     */

    static StringTokenizer st;
    static StringBuilder sb;
    static BufferedReader br;

    static int n, u, v;
    static ArrayList<Integer> arr[];
    static int check[];

    static int bfs(int start){
        check[start] = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(start, 0));

        while (!queue.isEmpty()){
            Point t = queue.poll();
            if(t.a == v){
                return t.value;
            }else{
                for (int next : arr[t.a]){
                    if (check[next] != 1){
                        check[next] = 1;
                        queue.offer(new Point(next, t.value+1));
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        u = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        arr = new ArrayList[n+1];
        for (int i = 1; i <=n ; i++) {
            arr[i] = new ArrayList<>();
        }
        check = new int[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        System.out.print(bfs(u));
    }
    static class Point{
        int a, value;

        public Point(int a, int value) {
            this.a = a;
            this.value = value;
        }
    }
}