M
tags: Array, DP, Coordinate DP
time: O(mn)
space: O(mn)

跟unique path的grid一样, 目标走到右下角, 但是grid里面可能有obstacle, 不能跨越. 求unique path 的count.

#### 坐标DP
- dp[i][j]: # of paths to reach grid[i][j]
- Bottom-up: at end, there are 2 ways to reach dp[i][j]
    - dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
- Handle obstacle (cause dp[i][j] to be 0).

#### 坐标DP
- dp[i][j]: # of paths to reach grid[i][j]
- Bottom-up: at end, there are 2 ways to reach dp[i][j]
    - dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
- Handle obstacle (cause dp[i][j] to be 0).

```
/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note
m and n will be at most 100.

Example
For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Tags Expand 
Array Dynamic Programming

Thinking process:
1. Still use an extra matrix to count possible paths. 
2. When initializing, skip block if it's obstacle (break the for loop, basically skip this row/col)
3. When evaluating paths, skip block if it's obstacle (save current spot's path as 0, means no path through this point).
4. Note: At evaluating double-for loop, we cannot use break, because we still need to evaluate using upper/left block. Hence we set the obstacle = 0.
*/

/*
Thoughts:
Last right-bottom corner is always filled by left + up: dp[i][j] = dp[i - 1][j] + dp[i][j - 1].
Whenever there is 1, mark the position with 0 ways, because it can get pass through.

init: if row has block, all the rest of the row remains 0. If column has a block, the rest of the column remains 0.
*/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        
        int[][] dp = new int[m][n];
        // init:
        for (int i = 0, j = 0; j < n; j++) {
            if (obstacleGrid[i][j] == 1) break;
            dp[i][j] = 1;
        }
        for (int i = 0, j = 0; i < m; i++) {
            if (obstacleGrid[i][j] == 1) break;
            dp[i][j] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}


```