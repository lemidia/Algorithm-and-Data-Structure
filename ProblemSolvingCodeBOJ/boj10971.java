import java.io.*;
import java.util.StringTokenizer;

public class Main { // 정점 방문개수로 체크해도 좋다.
    static int N;
    static boolean[] chk;
    static int[][] map;
    static int min = Integer.MAX_VALUE;

    static void dfsForSalesPerson(int start, int sum, int base){
        for (int i = 1; i <=N ; i++) {
            if(!chk[i] == true && map[start][i] != 0 && sum+map[start][i] < min){ // 탐색배제 조건
                chk[i] = true;
                if(chk[base] == true){
                    sum += map[start][i];
                    boolean pass = true;
                    for (int j = 1; j <=N ; j++) {
                        if(chk[j] != true){
                            chk[i] = false;
                            pass = false;
                        }
                    }
                    if(pass == true){
                        min = sum < min ? sum : min;
                        //System.out.print("base " +base + " = " + sum + "\n");
                        chk[i] = false;
                    }
                    sum-=map[start][i];
                }else{
                    dfsForSalesPerson(i, sum+map[start][i], base);
                    chk[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        chk = new boolean[N+1];
        map = new int[N+1][N+1];
        StringTokenizer st;
        for (int i = 1; i <N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <N+1 ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <=N ; i++) {
            int sum = 0;
            dfsForSalesPerson(i, sum, i); //시작정점, 합계, 원점 포인트
        }
        bw.write(String.valueOf(min));
        bw.close();
    }
}
