/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *   0ms on 106 test cases
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return Math.max(heightAndDiam(root).diam, 0);
    }
    
    private HeightAndDiam heightAndDiam(TreeNode node) {
        if (node == null) {
            return new HeightAndDiam(-1, -1);
        }
        
        HeightAndDiam left = heightAndDiam(node.left);
        HeightAndDiam right = heightAndDiam(node.right);
        
        return new HeightAndDiam(1 + Math.max(left.height, right.height), Math.max(left.diam, Math.max(right.diam, 2 + left.height + right.height)));
    }
}

class HeightAndDiam {
    int height;
    int diam;
    
    public HeightAndDiam(int height, int diam) {
        this.height = height;
        this.diam = diam;
    }
}

/** 
* 106 / 106 test cases passed.
* Status: Accepted
* Runtime: 11 ms
* Memory Usage: 41 MB
 */
class Solution {
    
    public int getmax(int a, int b, int c){
        return Math.max(a,Math.max(b,c));
    }
    
    public int height(TreeNode node){
        if(node == null){
            return 0;
        }
        return 1+Math.max(height(node.left), height(node.right)) ;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root != null){
            
            int leftH = height(root.left);
            int rightH = height(root.right);
            
            int leftD = diameterOfBinaryTree(root.left);
            int rightD = diameterOfBinaryTree(root.right);
            
            return getmax(leftH+rightH,leftD,rightD);
        }
        return 0;
           }
}