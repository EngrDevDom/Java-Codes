package _406_Node_Successor;

import chapters.common.BinaryTreeNode;
import chapters.common.TreeUtilityFunctions;

public class TesterClass {

    public static void main(String[] args) {
        BinaryTreeNode tree = TreeUtilityFunctions.createBST();
        System.out.println("In-order Successor is 12 : " + NodeSuccessor.inOrderSuccessor(tree));
        System.out.println("In-order Successor is 6 : " + NodeSuccessor.inOrderSuccessor(tree.left));
        System.out.println("In-order Successor is 16 : " + NodeSuccessor.inOrderSuccessor(tree.right));
        System.out.println("In-order Successor is null: " + NodeSuccessor.inOrderSuccessor(tree.right.right));
        System.out.println("In-order Successor is 5: " + NodeSuccessor.inOrderSuccessor(tree.left.left));
        System.out.println("In-order Successor is 10: " + NodeSuccessor.inOrderSuccessor(tree.left.right));
    }
}
