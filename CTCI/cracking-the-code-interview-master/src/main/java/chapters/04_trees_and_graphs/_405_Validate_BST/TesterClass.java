package _405_Validate_BST;

import chapters.common.BinaryTreeNode;
import chapters.common.TreeUtilityFunctions;

public class TesterClass {

    public static void main(String[] args) {
        BinaryTreeNode tree = TreeUtilityFunctions.createBST();
        System.out.println(ValidateBST.treeIsBinarySearchTree(tree));
    }

}
