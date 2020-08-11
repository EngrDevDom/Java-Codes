package _405_Validate_BST;

import chapters.common.BinaryTreeNode;

public class ValidateBST {

    public static boolean treeIsBinarySearchTree(BinaryTreeNode root) {
        return treeIsBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean treeIsBinarySearchTree(BinaryTreeNode node, int min, int max) {

        if (node == null) {
            return true;
        }

        if (node.value <= min || node.value > max) {
            return false;
        }

        return treeIsBinarySearchTree(node.left, min, node.value) && treeIsBinarySearchTree(node.right, node.value, max);
    }
}
