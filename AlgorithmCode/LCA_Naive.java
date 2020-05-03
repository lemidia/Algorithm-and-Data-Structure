public class LCA_Naive {

    static class TreeNode {
        int index;
        TreeNode children[];

        public TreeNode(int index) {
            this.index = index;
            children = new TreeNode[2];
        }
    }

    /*
    Sample Tree used in this code.

            0
          /   \
         /     \
        1       2
       / \     / \
      /   \   /   \
     3     4  5    6
     LCA of 1,2 = 0
     LCA of 1,0 = 0
     LCA of 3,4 = 1
     LCA of 4,5 = 0
     LCA of 3,3 = 3
     
     */

    public static TreeNode lca (TreeNode at, int a, int b) {
        if (at == null)
            return null;
        if (at.index == a || at.index == b)
            return at;

        TreeNode left = lca(at.children[0], a, b);
        TreeNode right = lca(at.children[1], a, b);

        if (left != null && right != null)
            return at;
        if (left != null)
            return left;
        else
            return right;
    }


    public static void main(String[] args) {
        // Construct Sample Tree
        TreeNode root = new TreeNode(0);
        root.children[0] = new TreeNode(1);
        root.children[1] = new TreeNode(2);
        root.children[0].children[0] = new TreeNode(3);
        root.children[0].children[1] = new TreeNode(4);
        root.children[1].children[0] = new TreeNode(5);
        root.children[1].children[1] = new TreeNode(6);

        TreeNode lca = lca(root, 3, 5);
        System.out.println(lca.index);
        lca = lca(root, 1, 4);
        System.out.println(lca.index);
        lca = lca(root, 1, 4);
        System.out.println(lca.index);
    }
}
