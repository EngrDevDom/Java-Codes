package _406_Node_Successor;

import chapters.common.BinaryTreeNode;

/**
 * Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
 * binary search tree. You may assume that each node has a link to its parent.
 */
public class NodeSuccessor {


    public static BinaryTreeNode inOrderSuccessor(BinaryTreeNode root) {

        if (root.right != null) {
            return getLeftMostChildNode(root.right);
        } else {
            return getProperParentNode(root);
        }


    }

    private static BinaryTreeNode getLeftMostChildNode(BinaryTreeNode node) {

        if (node == null) {
            return null;
        }

        BinaryTreeNode result = node;
        while (result.left != null) {
            result = result.left;
        }
        return result;
    }

    private static BinaryTreeNode getProperParentNode(BinaryTreeNode node) {

        if (node == null) {
            return null;
        }
        BinaryTreeNode p = node.parent;
        BinaryTreeNode c = node;

        while (p != null && p.left != c) {
            c = p;
            p = c.parent;
        }

        return p;
    }


}
