import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    static final int INF = 987654321; // 무한대
    static int N, M; // 정점과 간선의 수
    static int edgeDistance[][]; // 각 간선(엣지)의 거리
    static int vertexDistance[];  // 각 정점 까지의 거리
    static ArrayList<Integer> graph[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edgeDistance = new int[N+1][N+1];
        vertexDistance = new int[N+1];
        graph = new ArrayList[N+1];
        for(int i = 1; i<=N; i++)
            graph[i] = new ArrayList<>();
        for(int i = 1; i<=N; i++) vertexDistance[i] = INF;
        vertexDistance[Integer.parseInt(br.readLine())] = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graph[from].add(to);
           if(edgeDistance[from][to] == 0)
                edgeDistance[from][to] = value;
            else{
              if(edgeDistance[from][to] > value)
                   edgeDistance[from][to] = value;
            }
        }
        for (int i = 0; i < N; i++) { // 벨만-포드 시작
            for (int cur = 1; cur <=N ; cur++) {
                for (int next : graph[cur]){
                    if(vertexDistance[cur] != INF && vertexDistance[next] > vertexDistance[cur] + edgeDistance[cur][next]){
                        vertexDistance[next] = vertexDistance[cur] + edgeDistance[cur][next];
                        if(i == N-1){
                            System.out.println(-1);
                            return;
                        }
                    }
                }
            }
        }

        for (int i = 1; i <=N ; i++) {
            if (vertexDistance[i] == INF)
                System.out.println("INF");
            else{
                System.out.println(vertexDistance[i]);
            }
        }

        System.out.print(sb.toString());
    }
}

