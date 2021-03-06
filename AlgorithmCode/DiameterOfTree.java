public class DiameterOfTree {

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

    public static int diameterOfTree (TreeNode root) {
        if (root == null)
            return 0;
        // Diameter of the tree is
        // root diameter which is 1 + left sub tree height + right sub tree height

        return heightOfSubTree(root.children[0], 1)
                + heightOfSubTree(root.children[1], 1) + 1;
    }

    public static int heightOfSubTree (TreeNode at, int diameter) {
        if (at == null)
            return 0;

        int left = heightOfSubTree(at.children[0], diameter + 1);
        int right = heightOfSubTree(at.children[1], diameter + 1);

        if (left == 0 && right == 0)
            return diameter;

        return Math.max(left, right);
    }

    public static void main(String[] args) {
        // Construct Sample Tree
        TreeNode root = new TreeNode(0);
        root.children[0] = new TreeNode(1);
        root.children[1] = new TreeNode(2);
        root.children[0].children[0] = new TreeNode(3);
        root.children[0].children[1] = new TreeNode(4);

        int diameter = diameterOfTree(root);
        System.out.println("Diameter of the tree is : " + diameter);

        // Output:
        // Diameter of the tree is : 4
    }
}
