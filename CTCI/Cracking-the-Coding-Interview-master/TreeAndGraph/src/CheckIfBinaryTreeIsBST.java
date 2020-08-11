
public class CheckIfBinaryTreeIsBST {

    static class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    static class BinaryTree{
        Node root;

        BinaryTree(){
            root = null;
        }

        public boolean checkBSTSubtree(Node root, Integer min, Integer max){
            if(root == null){
                return true;
            }

            if((max!=null && root.data >= max) || (min!=null && root.data <= min)){
                return false;
            }
            return checkBSTSubtree(root.left,min,root.data) && checkBSTSubtree(root.right,root.data,max);

        }

        public boolean checkBST(Node root){

            if(root == null){
                return true;
            }
            return checkBSTSubtree(root,null,null);

        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(2147483647);
        //tree.root.left = new Node(1);
        //tree.root.right = new Node(4);
        //tree.root.right.left = new Node(3);
        //tree.root.right.right = new Node(6);

        System.out.println(tree.checkBST(tree.root));
    }
}
/*

public boolean isBSTUtil(TreeNode node, Integer min, Integer max){
      if(node == null){
          return true;
      }
      if((min!=null && node.val <= min) || (max!=null && node.val >= max)){
          return false;
      }
      return (isBSTUtil(node.left,min,node.val) && isBSTUtil(node.right,node.val,max));
  }

  public boolean isValidBST(TreeNode root) {
    return isBSTUtil(root, null, null);
  }
 */