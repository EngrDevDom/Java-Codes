M
1520234108
tags: Binary Search, Heap
time: O(n + klogn)
space: O(n)

给一个sorted matrix, 找kth smallest number (not distinct)

Related: `Kth Largest Element in an Array`

#### PriorityQueue
- 和Merge K sorted Array/ List 类似：使用PriorityQueue。
- 因为Array的element无法直接找到next,所以用一个class Node 存value, x,y positions.
- Initial O(n) time, also find k O(k), sort O(logn) => O(n + klogn)
- 变型: Kth Largest in N Arrays

#### Binary Search
- we know where the boundary is start/end are the min/max value. 
- locate the kth smallest item (x, y) by cutt off partition in binary fasion: 
- find mid-value, and count # of items < mid-value based on the ascending matrix
- O(nlogn)


```
/*
LeetCode:
Given a n x n matrix where each of the rows and columns are sorted in ascending order, 
find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n^2.
 */

/*
Thougths:
Like merge k sorted list:
1. Append the head using priority queue
2. Keep adding to the queue and removing elments.

O(k) space
O(n + klogk) time if going through all elements
*/
class Solution {
    class Node {
        int x;
        int y;
        int val;
        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || k <= 0) {
            return 0;
        }
        int n = matrix.length;
        Queue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>(){ 
            public int compare(Node a, Node b){
                return a.val - b.val;
            }
        });
        
        // Initialize the queue with head elements
        for (int i = 0; i < n; i++) {
            queue.offer(new Node(i, 0, matrix[i][0]));
        }
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (k == 1) {
                return node.val;
            }
            if (node.y + 1 < n) {
                queue.offer(new Node(node.x, node.y + 1, matrix[node.x][node.y + 1]));
            }
            k--;
        }

        return 0;
    }
}

// Binary Search
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k <= 0) return -1;
        
        int n = matrix.length;
        int min = matrix[0][0];
        int max = matrix[n - 1][n - 1];
        while (min < max) {
            int target = min + (max - min) / 2;
            int count = countSmallerItem(matrix, target);
            if (count < k) { // need larger target
                min = target + 1; // target is counted, skip over
            } else {
                max = target;
            }
        }
        return min;
    }
    
    // O(n)
    private int countSmallerItem(int[][] matrix, int target) {
        int n = matrix.length;
        int count = 0;
        int i = 0, j = n - 1; // n*n
        while (i < n && j >= 0) {
            if (matrix[i][j] > target) { //item too large, skip
                j--;
            } else { // meet requirement, add (j+1) since j is 0-based, also move on to next row
                count += j + 1;
                i++;
            }
        }
        return count;
    }
}

/*
Find the kth smallest number in at row and column sorted matrix.

Have you met this question in a real interview? Yes
Example
Given k = 4 and a matrix:

[
  [1 ,5 ,7],
  [3 ,7 ,8],
  [4 ,8 ,9],
]
return 5

Challenge
O(k log n), n is the maximal number in width and height.

Tags Expand 
Heap Priority Queue Matrix

*/



//PriorityQueue store front node. (Class Node), then output the kth in queue.
public class Solution {
    class Node {
        int val;
        int x,y;
        public Node(int val, int x, int y){
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix[0] == null || matrix.length == 0 
            || matrix[0].length == 0 || k <= 0) {
            return -1;
        }
        
        //Init queue
        PriorityQueue<Node> queue = new PriorityQueue<Node>(k, 
            new Comparator<Node>(){
                public int compare(Node a, Node b) {
                    return a.val - b.val;
                }
            });
        
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length > 0) {
                queue.offer(new Node(matrix[i][0], i, 0));
            }
        }
        
        //Find kth
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if(k == 1) {
                return node.val;
            }
            int x = node.x;
            int y = node.y;
            if (y < matrix[x].length - 1) {
                queue.offer(new Node(matrix[x][y+1], x, y+1));
            }
            k--;
        }
        
        return -1;
    }
}

```