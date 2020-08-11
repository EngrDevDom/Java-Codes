package _408_First_Common_Ancestor;

import chapters.common.BinaryTreeNode;

/**
 * First Common Ancestor: Design an algorithm and write code to find the first common ancestor
 * of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
 * necessarily a binary search tree.
 */
public class FirstCommonAncestor {

    public  BinaryTreeNode firstCommonAncestor(BinaryTreeNode p, BinaryTreeNode q){

        int diff = getNodeDepth(p) - getNodeDepth(q);
        BinaryTreeNode firstNode = diff > 0 ? q : p;
        BinaryTreeNode secondNode = diff > 0 ? p : q;

        secondNode = goUpTheTreeByDiff(secondNode, Math.abs(diff));

        while(firstNode != secondNode && firstNode != null && secondNode != null ){
            firstNode = firstNode.parent;
            secondNode = secondNode.parent;
        }

         return firstNode == null || secondNode == null ? null : firstNode;
    }

    public int getNodeDepth(BinaryTreeNode node){

        int depth = 0;
        while(node != null){
            node = node.parent;
            depth ++;
        }
        return depth;
    }

    public BinaryTreeNode goUpTheTreeByDiff(BinaryTreeNode node, int diff){

        while(diff > 0 && node != null){
            node = node.parent;
            diff --;
        }
        return node;
    }


}
