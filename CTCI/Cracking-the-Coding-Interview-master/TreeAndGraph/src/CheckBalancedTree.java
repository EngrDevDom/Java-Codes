public class CheckBalancedTree {

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

        public int getHeight(Node node){
            if(node == null){
                return 0;
            }
            return Math.max(getHeight(node.left), getHeight(node.right))+1;
        }

        public int checkHeight(Node root){
            if(root == null){
                return 0;
            }
            int leftHeight = checkHeight(root.left);
            if(leftHeight == -2){
                return -2;
            }
            int rightHeight = checkHeight(root.right);
            if(rightHeight == -2){
                return -2;
            }


            if(Math.abs(leftHeight - rightHeight)>1){
                return -2;
            }
            return Math.max(leftHeight,rightHeight)+1;
        }

        public boolean isBalanced(Node root){
            return checkHeight(root) != -2;
            /*

            if(root == null){
                return true;
            }

            int height = getHeight(root.left) - getHeight(root.right);
            if(Math.abs(height)>1){
                return false;
            }
            return isBalanced(root.left) && isBalanced(root.right);
            */
        }
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        //tree.root.left.left.left = new Node(5);

        System.out.println(tree.isBalanced(tree.root));
    }


}

/*

Algorithm:

1. getHeight function calls itself recursively on left and right subtree
2. It takes the max of left and right and then adds 1 for the root
3. isBalanced is the main function which gets the height of left and right and takes the difference
4. If the difference is more than 1, it returns false else calls itself recursively with the base case of true when root is null

5. checkHeight function calls itself recursively for left and right subtree.
6. If at any point, the difference between left and right height becomes more than 1, height is set to -2.
7. isBalanced in this case, checks if the return value of checkHeight is equal to -2 or not and returns accordingly.

 */