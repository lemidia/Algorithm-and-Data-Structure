public class InorderTraversal{
  public static void inorder(TreeNode root){
	// 현재 노드가 null이면 리턴
	if (root == null) {
		return;
	}

	// 재귀적으로 왼쪽 서브트리를 탐색한다.
	inorder(root.left);

	// 현재 노드의 데이터를 출력한다. (방문)
	System.out.print(root.data + " ");

	// 재귀적으로 오른쪽 서브트리를 탐색한다.
	inorder(root.right);
  }
}

