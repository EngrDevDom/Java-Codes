import com.sun.source.tree.Tree;

import java.util.ArrayDeque;

public class InorderSuccessorInBST {

    static class TreeNode{
        int data;
        TreeNode left,right;

        TreeNode(int data){
            this.data=data;
            left = right = null;
        }
    }

    static class BinaryTree{
        TreeNode root;

        BinaryTree(){
            root = null;
        }

        public TreeNode leftmostChild(TreeNode node){
            if(node == null) {
                return null;
            }
            while(node.left !=null){
                node = node.left;
            }
            return node;
        }

        public TreeNode inOrderSucc(TreeNode node){
            if(node.right != null) {
                return leftmostChild(node.right);
            }

            ArrayDeque<TreeNode> stack = new ArrayDeque<>(); // why an ArrayDeque, can use stack as well ??
            int inorder = Integer.MIN_VALUE;

            while(!stack.isEmpty() || root != null){
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }

                root = stack.pop();
                if(inorder == node.data){
                    return root;
                }

                inorder = root.data;
                root = root.right;
            }
            System.out.println("returning null");
            return null;

        }

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if(p.right != null){
                p=p.right;
                while(p.left!=null){
                    p=p.left;
                }
                return p;
            }

            ArrayDeque<TreeNode> stack = new ArrayDeque<>();
            int inorder = Integer.MIN_VALUE;

            while(!stack.isEmpty() || root!=null){
                while(root !=null){
                    stack.push(root);
                    root = root.left;
                }

                root = stack.pop();
                if(inorder == p.data){
                    return root;
                }
                inorder = root.data;
                root = root.right;
            }
            return null;
        }
    }



    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root= new TreeNode(20);
        tree.root.left = new TreeNode(8);
        tree.root.right = new TreeNode(22);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(12);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.right = new TreeNode(14);

        System.out.println(tree.inOrderSucc(tree.root.left.right.right));
        //System.out.println(tree.inorderSuccessor(tree.root, tree.root.left.right.right));

    }
}

/*

Algorithm

1. If node has left subtree, the answer will be leftmost child of the right subtree
2. If node's right subtree is null, create a stack and inorder variable which is set to Integer.min initially
3. Iterate till stack is empty or root is null
    a) Push root in stack and keep going to the left most child while pushing till root is null
    b) Pop the first element from the stack
    c) if inorder is equal to the value of the node, return the root
    d) Assign inorder to root.value
    e) Go to root.right

 */