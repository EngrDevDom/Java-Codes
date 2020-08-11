public class SortedArrayToBST {

    static class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    static class BinaryTree{
        Node node;

        public Node sortedArrayToBST(int[]arr, int start, int end){
            if(end<start){
                return null;
            }

            int mid = (start+end)/2;
            Node n = new Node(arr[mid]);
            n.left = sortedArrayToBST(arr, start, mid-1);
            n.right = sortedArrayToBST(arr, mid+1, end);

            return n;
        }

        public void preOrder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};int n = arr.length;
        Node root = tree.sortedArrayToBST(arr, 0, n - 1);
        System.out.println("Preorder traversal of constructed BST");
        tree.preOrder(root);


    }
}

/*

Algorithm:

Binary Search

Sorted Array to BST:
1. Find the mid of the array
2. Set it to root
3. root.left = left part of the array - recursively call the function at line 1
4. root. right = right part of the array - recursively call the function at line 1
5. Base case: if end of array becomes less than start of the array, return null

 */