public class HeightOfTree {

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
       / \
      /   \
     3     4

     */

    public static int heightOfTree (TreeNode root) {
        if (root == null)
            return 0;

        return heightOfTree(root, 1);
    }

    public static int heightOfTree (TreeNode at, int height) {
        if (at == null)
            return 0;

        int left = heightOfTree(at.children[0], height + 1);
        int right = heightOfTree(at.children[1], height + 1);

        if (left == 0 && right == 0)
            return height;
        
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        // Construct Sample Tree
        TreeNode root = new TreeNode(0);
        root.children[0] = new TreeNode(1);
        root.children[1] = new TreeNode(2);
        root.children[0].children[0] = new TreeNode(3);
        root.children[0].children[1] = new TreeNode(4);

        int height = heightOfTree(root);
        System.out.println("Height of the tree is : " + height);

        // Output:
        // Height of the tree is : 3
    }
}
