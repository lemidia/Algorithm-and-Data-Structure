public class PostorderTraversal{
    public static void postorder(TreeNode root){
	// return if the current node is empty
	if (root == null) {
		return;
	}

	// 재귀적으로 왼쪽 서브트리를 탐색한다.
	postorder(root.left);

	// 재귀적으로 오른쪽 서브트리를 탐색한다.
	postorder(root.right);

  // 현재 노드의 데이터를 출력한다. (방문)
	System.out.print(root.data + " ");
  }
}