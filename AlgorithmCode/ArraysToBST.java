// Given a sorted array of ascending order,
// Make the binary search tree using the array.

public class ArraysToBST {
    public static int arr[] = {1, 2, 3, 4, 5, 6, 7};

    public static void main(String[] args) {
        int start = 0;
        int end = arr.length-1;
        Node resultBST = func(start, end);

        dfs(resultBST);
    }

    /* Bst will be the following
            4
         2     6
       1   3 5   7
     */

    public static void dfs (Node current) {
        if (current == null)
            return;

        System.out.print(current.data + " ");
        dfs(current.leftChild);
        dfs(current.rightChild);

    }

    public static Node func(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end)/2;
        Node newNode = new Node(arr[mid]);
        newNode.leftChild = func(start, mid-1);
        newNode.rightChild = func(mid+1, end);
        return newNode;
    }

    static class Node {
        int data;

        public Node(int data) {
            this.data = data;
        }

        Node leftChild;
        Node rightChild;
    }
}
