public class TrieTree {
    TrieTreeNode root;

    // constructor
    public TrieTree() {
        root = new TrieTreeNode('@');
    }

    // insert word to the trie
    public void insert(String word) {
        if (word.equals("") || word == null)
            return;
        TrieTreeNode current = root;
        for (char ch : word.toCharArray()) {
            TrieTreeNode nextNode = current.next[ch-'a'];
            if (nextNode == null) {
                TrieTreeNode newNode = new TrieTreeNode(ch);
                current.next[ch-'a'] = newNode;
                current.theNumberOfChild++;
                current = newNode;
                current.cnt++;
            }else {
                current = nextNode;
                current.cnt++;
            }
        }
        current.isTerminal = true;
    }

    // check if the given word is in the tire or not
    public boolean search(String word) {
        if (word.equals("") || word == null)
            return false;
        TrieTreeNode current = root;
        for (char ch : word.toCharArray()) {
            TrieTreeNode nextNode = current.next[ch-'a'];
            if (nextNode == null)
                return false;
            current = nextNode;
        }
        return current.isTerminal ? true : false;
    }

    // driver method for recursive call
    public void printNode() {
        TrieTreeNode current = root;
        printRecursive(current);
    }

    // recursive call for printing nodes in trieTree
    public void printRecursive(TrieTreeNode current) {
        for (int i = 0; i < 26; i++) {
            if (current.next[i] != null){
                System.out.print(current.next[i].data + " ");
                printRecursive(current.next[i]);
            }
        }
    }

    // represent a node in a trie data structure
    static class TrieTreeNode {
        char data; // 노드에 문자 저장
        TrieTreeNode next[]; // 자식들
        boolean isTerminal; // 한 단어를 이루는지, 터미널 노드
        int theNumberOfChild; // 자식 수
        int cnt; // 등장 횟수

        // constructor
        public TrieTreeNode(char c) {
            data = c;
            // child array for alphabet
            next = new TrieTreeNode[26];
        }
    }

    public static void main(String[] args) {
        TrieTree trie = new TrieTree();
        trie.insert("bears");
        trie.insert("beti");
        trie.insert("betiasf");
        trie.insert("bea");
        System.out.print(trie.search("betiasf"));
    }
}
