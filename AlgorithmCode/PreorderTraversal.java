public class PreorderTraversal{
    public static void preorder(TreeNode root){
	// return if the current node is empty
	if (root == null) {
		return;
	}
	// 현재 노드의 데이터를 출력한다. (방문)
	System.out.print(root.data + " ");

	// 재귀적으로 왼쪽 서브트리를 탐색한다.
	preorder(root.left);

	// 재귀적으로 오른쪽 서브트리를 탐색한다.
	preorder(root.right);
    }
}