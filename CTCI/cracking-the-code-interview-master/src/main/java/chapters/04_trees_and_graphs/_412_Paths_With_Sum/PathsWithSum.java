package _412_Paths_With_Sum;

import chapters.common.BinaryTreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a binary tree in which each node contains an integer value (which
 * might be positive or negative). Design an algorithm to count the number of paths that sum to a
 * given value. The path does not need to start or end at the root or a leaf, but it must go downwards
 * (traveling only from parent nodes to child nodes).
 */
public class PathsWithSum {


    public static int findSumOfNodes(BinaryTreeNode node, int sum) {

        if (node == null) {
            return 0;
        }

        int pathsFromNode = countPathWithSumFromNode(node, sum, 0);
        int pathsOnTheLeftSide = findSumOfNodes(node.left, sum);
        int pathsOnTheRightSide = findSumOfNodes(node.right, sum);

        return pathsFromNode + pathsOnTheLeftSide + pathsOnTheRightSide;
    }

    private static int countPathWithSumFromNode(BinaryTreeNode node, int targetSum, int currentSum) {

        if (node == null) {
            return 0;
        }
        currentSum += node.value;
        int totalPaths = 0;
        if (currentSum == targetSum) {
            totalPaths++;
        }

        totalPaths += countPathWithSumFromNode(node.left, targetSum, currentSum);
        totalPaths += countPathWithSumFromNode(node.right, targetSum, currentSum);

        return totalPaths;

    }


}
