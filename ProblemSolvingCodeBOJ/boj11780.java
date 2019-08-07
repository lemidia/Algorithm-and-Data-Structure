import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 10000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int arr[][] = new int[N+1][N+1];
        int path[][] = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <=N ; j++) {
                arr[i][j] = INF;
                if(i ==j)
                    arr[i][i] = 0;
            }
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            if(arr[from][to] > value){
                arr[from][to] = value;
                path[from][to] = from;
            }
        }

        for (int m = 1; m <=N; m++) {
            for (int i = 1; i <=N ; i++) {
                for (int j = 1; j <=N ; j++) {
                    if(arr[i][j] > arr[i][m] + arr[m][j]){
                        arr[i][j] = arr[i][m] + arr[m][j];
                        path[i][j] = path[m][j];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=N ; i++) {
            for (int j = 1; j <=N ; j++) {
                if(arr[i][j] == INF)
                    sb.append(0).append(" ");
                else
                    sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <=N ; i++) {
            for (int j = 1; j <=N ; j++) {
                if(i == j || arr[i][j] == INF)
                    sb.append(0);
                else{
                    stack.push(j);
                    int a = i; int b = j;
                    while (path[a][b] != a){
                        stack.push(path[a][b]);
                        b = path[a][b];
                    }
                    stack.push(a);
                    sb.append(stack.size()).append(" ");
                    while (!stack.empty()){
                        sb.append(stack.pop()).append(" ");
                    }
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
