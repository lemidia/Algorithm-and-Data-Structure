import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- >0){
            Trie root = new Trie();
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) root.insert(root.root, br.readLine());
            res = 0;
            root.searchLeaf(root.root);
            if(res == n)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    static class Trie{
        TrieNode root;
        public Trie(){
            root = new TrieNode('r', 0);
        }

        public void insert(TrieNode node, String str){
            for (int j = 0; j < str.length(); j++) {
                char t = str.charAt(j);
                if(node.next[t-'0'] != null)
                    node = node.next[t-'0'];
                else{
                    node.cnt++;
                    node.next[t-'0'] = new TrieNode(t, 0);
                    node = node.next[t-'0'];
                }
            }
        }

        public void searchLeaf(TrieNode node){
            if(node.cnt == 0){
                res++;
                return;
            }
            for (int i = 0; i < 10; i++) {
                if(node.next[i] != null)
                    searchLeaf(node.next[i]);
            }
        }
    }

    static class TrieNode{
        char c;
        int cnt;
        TrieNode[] next;
        public TrieNode(char c, int cnt){
            this.c = c;
            this.cnt = cnt;
            this.next = new TrieNode[10];
        }
    }
}
