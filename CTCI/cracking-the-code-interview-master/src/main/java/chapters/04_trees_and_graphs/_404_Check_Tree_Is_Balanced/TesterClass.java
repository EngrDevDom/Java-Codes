package _404_Check_Tree_Is_Balanced;

import chapters.common.BinaryTreeNode;
import chapters.common.TreeUtilityFunctions;

public class TesterClass {

    public static void main(String[] args) {
        BinaryTreeNode tree = TreeUtilityFunctions.createBST();
        System.out.println("Tree is balanced: " + CheckIfTreeIsBalanced.treeIsBalanced(tree));
    }

}
