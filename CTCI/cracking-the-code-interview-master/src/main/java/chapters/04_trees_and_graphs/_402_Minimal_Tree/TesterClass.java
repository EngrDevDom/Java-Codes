package _402_Minimal_Tree;

import chapters.common.BinaryTreeNode;

public class TesterClass {

    public static void main(String[] args) {
        int[] sortedArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        BinaryTreeNode tree = MinimalTree.createBST(sortedArray);
        printInOrder(tree);
    }

    public static void printInOrder(BinaryTreeNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node);
            printInOrder(node.right);
        }
    }
}
