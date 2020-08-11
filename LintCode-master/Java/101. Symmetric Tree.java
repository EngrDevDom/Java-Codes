E
tags: Tree, DFS, BFS
time: O(n)
space: O(n)

检查tree是否symmetric

注意Symmetric Binary Tree的例子和定义: 是镜面一样的对称. 并不是说左右两个sub-tree相等。

#### Method1: DFS
- Recursively check symmetrically相对应的Node.  
- 每个node的children都和镜面另外一边相对的node的children刚好成镜面反射位置。

#### Method2: interative with queue 
- put left or right children in pair

#### Method3: iterative with Stack
- stack1: 左手边sub-tree先加left, 再加right child; 
- stack2: 右手边sub-tree先加right child, 再加left child。   
- process时，若symmetric，所有stack里面出来的node会一一对应。

```
/*
Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example
    1
   / \
  2   2
 / \ / \
3  4 4  3
is a symmetric binary tree.

    1
   / \
  2   2
   \   \
   3    3
is not a symmetric binary tree.

Challenge
Can you solve it both recursively and iteratively?

Tags Expand 
Binary Tree
*/

/*
  Thoughts:
  verify that left and right tree are identical
  A.val == B.val
  check(A.left, B.left)
  check(A.right, B.right)
*/
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }
    
    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val
            && dfs(left.right, right.left)
            && dfs(left.left, right.right);
    }
}

//Non-recursive, iterative

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        
        return true;
    }
}

/*
  Thoughts:
  Use 2 stack to hold the child that's needed to compare.
  Have to use stack, otherwise, can't iterate through root node.
*/

public class Solution {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }

    Stack<TreeNode> s1 = new Stack<TreeNode>();
    Stack<TreeNode> s2 = new Stack<TreeNode>();
    s1.push(root.left);
    s2.push(root.right);
    while (!s1.isEmpty() && !s2.isEmpty()) {
      TreeNode node1 = s1.pop();
      TreeNode node2 = s2.pop();
      if (node1 == null && node2 == null) {
        continue;
      } else if (node1 == null || node2 == null) {
        return false;
      } else if (node1.val != node2.val) {
        return false;
      }
      s1.push(node1.left);
      s2.push(node2.right);
      s1.push(node1.right);
      s2.push(node2.left);  
    }

    return true;
  }
}








```
