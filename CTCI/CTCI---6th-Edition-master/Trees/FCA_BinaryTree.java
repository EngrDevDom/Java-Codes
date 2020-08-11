/*
* 31 / 31 test cases passed.
* Status: Accepted
* Runtime: 1110 ms
* Memory Usage: 42.2 MB
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(!covers(root,p) || !covers(root,q)){
            return null;
        }
        
        return ancestorHelper(root,p,q);        
    }
    
    private TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q){
            return root;
        }
        
        boolean p_on_left = covers(root.left,p);
        boolean q_on_left = covers(root.left,q);
        
        if(p_on_left != q_on_left)   return root;
        
        TreeNode childSide = p_on_left ? root.left : root.right;
        return ancestorHelper(childSide,p,q);
    }
    
    private boolean covers(TreeNode root, TreeNode p){
        if(root == null)  return false;
        if(root == p)     return true;
        return covers(root.left,p) || covers(root.right,p);
    }
}
/*
* 31 / 31 test cases passed.
* Status: Accepted
* Runtime: 4 ms
* Memory Usage: 41.8 MB
*/

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null)  return null;
        if(root.val == p.val || root.val == q.val)  return root;
        
        TreeNode leftSearchResult = lowestCommonAncestor(root.left,p,q);
        TreeNode rightSearchResult = lowestCommonAncestor(root.right,p,q);
        
        if(leftSearchResult == null)  return rightSearchResult;
        if(rightSearchResult == null)  return leftSearchResult;
        
        return root;   
    }