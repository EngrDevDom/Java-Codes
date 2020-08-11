package _408_First_Common_Ancestor;

import chapters.common.BinaryTreeNode;
import chapters.common.TreeUtilityFunctions;

public class TesterClass {

    public static void main(String[] args) {
        BinaryTreeNode tree = TreeUtilityFunctions.createBST();
        FirstCommonAncestor fca = new FirstCommonAncestor();
        System.out.println("Common ancestor is : " + fca.firstCommonAncestor(tree.left, tree.right.right));
        System.out.println("Common ancestor is : " +  fca.firstCommonAncestor(tree.right, tree.right.left));
    }
}
