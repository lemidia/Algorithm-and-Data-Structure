public class BinarySearchTree {
    Node root;

    class Node{
        int key;
        Node left, right;

        public Node(int item){
            key = item;
            left = right = null;
        }
    }

    public binarySearchTree(){
        root = null;
    }

    public void insert(int key){
        root = insertRec(root, key);
    }


    public Node insertRec(Node root, int key){
        if(root == null){
            root = new Node(key);
            return root;
        }

        if(key < root.key)
            root.left = insertRec(root.left, key);
        else if(key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    public void intraversal(Node root){
        if(root != null){
            intraversal(root.left);
            System.out.print(root.key + " ");
            intraversal(root.right);
        }
    }

    public Node FindMax(Node root){
        if(root == null)
            return null;
        while (root != null) {
            if (root.right != null)
                root = root.right;
            else
                break;
        }
        return root;
    }

    public Node Delete(Node root, int data){
        Node temp;
        if(root == null)
            System.out.printf("no such a element" + "\n" );
        else if(data < root.key)
            root.left = Delete(root.left, data);
        else if(data > root.key)
            root.right = Delete(root.right, data);
        else{
            if(root.right != null && root.left != null){
                temp = FindMax(root.left);
                root.key = temp.key;
                root.left = Delete(root.left, root.key);
            }else{
                if(root.left == null)
                    root = root.right;
                else if(root.right == null)
                    root = root.left;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        binarySearchTree bi = new binarySearchTree();
        bi.insert(5);
        bi.insertRec(bi.root,7);
        bi.insertRec(bi.root,1);
        bi.insertRec(bi.root,3);
        bi.insertRec(bi.root,6);
        bi.Delete(bi.root,5);
        bi.intraversal(bi.root);

    }
}
