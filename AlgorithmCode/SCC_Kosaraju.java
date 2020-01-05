import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SCC_Kosaraju {
    static ArrayList<Integer> graph[];
    static ArrayList<Integer> reverse[];
    static boolean visited[];
    static Stack<Integer> st = new Stack<>();
    static ArrayList<ArrayList<Integer>> a = new ArrayList<>();

    static void dfs(int start){
        for(Integer a : graph[start]){
            if(visited[a] != true){
                visited[a] = true;
                dfs(a);
            }
        }
        st.push(start);
    }

    static void dfs2(int base, ArrayList<Integer> temp){
        temp.add(base);
        for(Integer a : reverse[base]){
            if(visited[a] != true){
                visited[a] = true;
                dfs2(a, temp);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        graph = new ArrayList[n+1];
        reverse = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i = 1; i<=n; i++){
            graph[i] = new ArrayList<Integer>();
            reverse[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st1 = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st1.nextToken());
            int to = Integer.parseInt(st1.nextToken());
            graph[from].add(to);
            reverse[to].add(from);
        }

        for (int i = 1; i <=n ; i++) {
            if(visited[i] != true){
                visited[i] = true;
                dfs(i);
            }
        }

        Arrays.fill(visited, false);

        while (!st.isEmpty()){
            int base = st.pop();
            if(visited[base] != true){
                visited[base] = true;
                ArrayList<Integer> temp = new ArrayList<>();
                dfs2(base, temp);
                Collections.sort(temp);
                temp.add(-1);
                a.add(temp);
            }
        }

        Collections.sort(a, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0) < o2.get(0) ? -1 : 1;
            }
        });

        StringBuilder sb = new StringBuilder();
        sb.append(a.size()).append("\n");
        for (int i = 0; i < a.size(); i++) {
            int size = a.get(i).size();
            for (int j = 0; j < size; j++) {
                sb.append(a.get(i).get(j)).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
