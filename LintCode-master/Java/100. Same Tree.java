E
tags: Tree, DFS, BFS
time: O(n)
space: O(logn)

给两个 binary tree, 看两个tree是否identical.

#### Method1: DFS
- DFS. 确定leaf条件, && with all dfs(sub1, sub2).
- 这里无论如何都要走过所有的node, 所以dfs更加合适, 好写.

#### Method2: BFS with 2 queues
- 两个queue存每个tree的所有current level node. Check equality, check queue size.
- Populate next level by nodes at current level.

```
/*
Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical 
and the nodes have the same value.


Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
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
/*
Method1: DFS
Use the function itself with dfs.
Check p == q, p.left==q.left, p.right==q.right
*/
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == null && q == null;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

// Method2: BFS
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pp = new LinkedList<>();
        Queue<TreeNode> qq = new LinkedList<>();
        pp.offer(p);
        qq.offer(q);

        while (!pp.isEmpty() && !qq.isEmpty()) {
            p = pp.poll();
            q = qq.poll();
            if (p == null && q == null) continue;
            if (p == null ^ q == null) return false;
            if (p.val != q.val) return false;
            offer(p, pp);
            offer(q, qq);
        }

        return true;
    }

    private void offer(TreeNode node, Queue<TreeNode> queue) {
        queue.offer(node.left);
        queue.offer(node.right);
    }
}
```