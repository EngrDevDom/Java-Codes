/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * 2ms on 227 test cases.	
 */
class Solution1 {
    public int height(TreeNode node){
        if(node == null)  return -1;
        return Math.max(height(node.left),height(node.right))+1;
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        
        int left = height(root.left);
        int right = height(root.right);
        int diff = left - right;
        if(Math.abs(diff) > 1){
            return false;
        }else{
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }
}

/**
 * 1ms on 227 test cases.
 * }
 */
class Solution2 {
    public int height(TreeNode node){
        if(node == null)  return -1;
        
        int left = height(node.left);
        if(left == Integer.MIN_VALUE)  return Integer.MIN_VALUE; //pass error up
        int right = height(node.right);
        if(right == Integer.MIN_VALUE)  return Integer.MIN_VALUE;  //pass error up
        int diff = left - right;
        
        if(Math.abs(diff) > 1){
            return Integer.MIN_VALUE;  //found error --> pass it back
        }else{
            return Math.max(left, right) + 1;
        }
    }
    
    public boolean isBalanced(TreeNode root) {
        return height(root) != Integer.MIN_VALUE;
        
    }
}

/**
 * 0ms on 227 test cases.
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = helper(root.left);
        int right = helper(root.right);
        if(left == -1 || right == -1) return false;
        return Math.abs(left - right) <= 1;
    }

    private int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if(Math.abs(left - right) > 1) return -1;
        if(left == -1 || right == -1) return -1;
        return 1+Math.max(left, right);
    }
}
