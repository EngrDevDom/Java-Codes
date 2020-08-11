package _404_Check_Tree_Is_Balanced;

import chapters.common.BinaryTreeNode;

public class CheckIfTreeIsBalanced {

    public static boolean treeIsBalanced(BinaryTreeNode root) {
        return checkTreeIsBalanced(root) != -1;
    }

    private static int checkTreeIsBalanced(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftTreeHeight = checkTreeIsBalanced(root.left);
        if (leftTreeHeight == -1) {
            return -1;
        }

        int rightTreeHeight = checkTreeIsBalanced(root.right);
        if (rightTreeHeight == -1) {
            return -1;
        }

        if (Math.abs(leftTreeHeight - rightTreeHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftTreeHeight, rightTreeHeight);
    }
}
