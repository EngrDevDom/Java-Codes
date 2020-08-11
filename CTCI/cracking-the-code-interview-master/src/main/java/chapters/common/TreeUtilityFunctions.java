package chapters.common;

public class TreeUtilityFunctions {

    public static BinaryTreeNode  createBST() {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.addLeftChild(5);
        root.left.addLeftChild(1);
        root.left.addRightChild(6);
        root.addRightChild(14);
        root.right.addLeftChild(12);
        root.right.addRightChild(16);
        return root;
    }
}
