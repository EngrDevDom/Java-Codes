
class TreeNode {
    TreeNode root;
    TreeNode left;
    TreeNode right;
    int data;

    TreeNode(int data) {
        this.data = data;
    }
}

public class TreeHeight {
    TreeNode root;

    public static TreeNode createMinimalBST(int[] arr){
        return minBST(arr,0,arr.length-1);
    }

    public static TreeNode minBST(int[] arr,int start, int end){
        if(end < start){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = minBST(arr, start, mid-1);
        n.right = minBST(arr, mid+1, end);
        return n;
    }

    static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        
        TreeNode n = createMinimalBST(array);
        System.out.println(n.data);
        preOrder(n);

    }
    
}