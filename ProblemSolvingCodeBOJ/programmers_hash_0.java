import java.util.*;
import java.util.LinkedList;

public class programmers_hash_0 {
    public boolean solution(String phone_book[]) {
        Trie tree = new Trie(new Trie.TrieNode('@'));
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length; i++) {
            if (!tree.insert(phone_book[i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        programmers_hash_0 sol = new programmers_hash_0();
        String arr[] = {"12", "123", "1111"};
        System.out.println(sol.solution(arr));
    }

    static class Trie {
        TrieNode root;

        public Trie(TrieNode root) {
            this.root = root;
        }

        static class TrieNode {
            char a;
            TrieNode children[];
            boolean isTerminal;

            public TrieNode(char a) {
                this.a = a;
                this.children = new TrieNode[10];
            }
        }

        public boolean insert(String str) {
            TrieNode temp = this.root;
            for (int i = 0; i < str.length(); i++) {
                char character = str.charAt(i);
                if (temp.children[character-'0'] != null) {
                    if (temp.children[character-'0'].isTerminal)
                        return false;
                    temp = temp.children[character-'0'];
                }
                else {
                    temp.children[character-'0'] = new TrieNode(character);
                    temp = temp.children[character-'0'];
                }
            }
            temp.isTerminal = true;
            return true;
        }
    }
}


