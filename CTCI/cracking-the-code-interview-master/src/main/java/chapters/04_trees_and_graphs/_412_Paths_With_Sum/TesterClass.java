package _412_Paths_With_Sum;

import chapters.common.BinaryTreeNode;
import chapters.common.TreeUtilityFunctions;

public class TesterClass {

    public static void main(String[] args) {
        BinaryTreeNode tree = TreeUtilityFunctions.createBST();
        int result = PathsWithSum.findSumOfNodes(tree, 6);
        System.out.println(result);
    }
}
