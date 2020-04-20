class BinaryTree 
{ 
    // Root of Binary Tree 
    Node root; 
    
    BinaryTree() 
    { 
        root = null; 
    } 
  
    // Constructors 
    BinaryTree(int key) 
    { 
        root = new Node(key); 
    } 
  
    static class Node
    { 
        int key; 
        Node left, right; 
  
        public Node(int item) 
        { 
            key = item; 
            left = right = null; 
        } 
    }

    public static void preOrderTraversal(Node node) {
        if (node == null)
            return;
        System.out.print(node.key + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public static void inOrderTraversal(Node node) {
        if (node == null)
            return;
        preOrderTraversal(node.left);
        System.out.print(node.key + " ");
        preOrderTraversal(node.right);
    }

    public static void postOrderTraversal(Node node) {
        if (node == null)
            return;
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
        System.out.print(node.key + " ");
    }
  
    public static void main(String[] args) 
    { 
        BinaryTree tree = new BinaryTree(); 
  
        /*create root*/
        tree.root = new Node(1); 
  
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 

        // preOrderTraversal(tree.root);
        // Output : 1 2 4 3
    } 
} 