 
 
 
## DFS (121)
**0. [House Robber III.java](https://github.com/awangdev/LintCode/blob/master/Java/House%20Robber%20III.java)**      Level: Medium      Tags: [DFS, DP, Status DP, Tree]
      
Houses被arrange成了binary tree, 规则还是一样, 连续相连的房子不能同时抄.

求Binary Tree neighbor max 能抄多少.

#### DFS
- 判断当下的node是否被采用，用一个boolean来表示. 
- 如果curr node被采用，那么下面的child一定不能被采用.
- 如果curr node不被采用，那么下面的children有可能被采用，但也可能略过，所以这里用Math.max() 比较一下两种可能有的dfs结果。
- dfs重复计算:每个root都有4种dive in的可能性, 假设level高度是h, 那么时间O(4^(h)), where h = logN, 也就是O(n^2)

#### DP, DFS
- 并不是单纯的DP, 是在发现DFS很费劲后, 想能不能代替一些重复计算?
- 基本思想是dfs解法一致: 取root找最大值, 或者不取root找最大值
- 在root上DFS, 不在dfs进入前分叉; 每一个level按照状态来存相应的值: dp[0] root not picked, dp[1] root picked.
- Optimization: DP里面, 一口气找leftDP[]会dfs到最底层, 然后自下向上做计算
- 这个过程里面, 因为没有在外面给dfs()分叉, 计算就不会重叠, 再也不用回去visit most-left-leaf了, 算过一遍就完事.
- 然而, 普通没有dp的dfs, 在算完visited的情况下的dfs, 还要重新dfs一遍!visited的情况.
- Space O(h), time O(n), 或者说是O(2^h), where h = log(n)

#### DP 特点
- 不为状态而分叉dfs
- 把不同状态model成dp
- 每一个dfs都return一个based on status的 dp array.
- 等于一次性dfs计算到底, 然后back track, 计算顶部的每一层.
- DP 并不一定要是以n为base的. 也可以是局部的去memorize状态->value.



---

**1. [Binary Tree Maximum Path Sum II.java](https://github.com/awangdev/LintCode/blob/master/Java/Binary%20Tree%20Maximum%20Path%20Sum%20II.java)**      Level: Medium      Tags: [DFS, Tree]
      
找到从max path sum from root. 条件: 至少有一个node.

#### DFS
- 比Binary Tree Maximum Path Sum I 简单许多. 因为条件给的更多：at least 1 node + have to start from root
- root一定用到
- 3种情况: curr node, curr+left, curr+right
- 因为一定包括root, 说以从 `dfs(root, sum=0)` 开始, 每个level先加root, sum += root.val



---

**2. [Convert Expression to Polish Notation.java](https://github.com/awangdev/LintCode/blob/master/Java/Convert%20Expression%20to%20Polish%20Notation.java)**      Level: Hard      Tags: [Binary Tree, DFS, Expression Tree, Stack]
      
给一串字符, 用来表示公式expression. 把这个expression转换成 Polish Notation (PN).

#### Expression Tree
- Expression Tree: Minimum Binary Tree (https://lintcode.com/en/problem/expression-tree-build/)
- 根据题意做出Expression Tree出来以后: 来个Pre-order-traversal 就能记录下 Polish Notation
- 本题没有给'ExpressionTreeNode', 所以把TreeNode就当做成我们需要的node, 里面扩展成有left/right child就可以了.
- Note: label需要是String. 虽然 Operator是长度为1的char, 但是数字可为多位



---

**3. [Restore IP Addresses.java](https://github.com/awangdev/LintCode/blob/master/Java/Restore%20IP%20Addresses.java)**      Level: Medium      Tags: [Backtracking, DFS, String]
      
给一串数字, 检查是否是valid IP, 如果合理, 给出所有valid 的IP组合方式.

#### Backtracking
- 递归的终点:list.zie() == 3, 解决最后一段
- 递归在一个index上面, pass s.toCharArray()
- validate string要注意leading '0'
- 注意: 递归的时候可以用一个start/level/index来跑路
- 但是尽量不要去改变Input source， 会变得非常confusing.
- note: code有点messy, 因为要考虑IP的valid情况
- 那个'remainValid', 其实是一个对于remain substring的判断优化, 不成立的就不dfs了



---

**4. [Triangles.java](https://github.com/awangdev/LintCode/blob/master/Java/Triangles.java)**      Level: Medium      Tags: [Array, Coordinate DP, DFS, DP, Memoization]
      
给一个list<list<Integer>> triangle, 细节原题. 找 min path sum from root.

#### DFS + Memoization
- 其实跟给一个2D matrix没有什么区别, 可以做dfs, memoization.
- initialize memo: pathSum[i][j] = MAX_VALUE; 计算过的path省略
- Bottom-top: 先dfs到最深的path, 然后逐步网上返回
- `OR 原理: min(pathA, pathB) + currNode`
- 浪费一点空间, pathSum[n][n]. space: O(n^2), where n = triangle height
- 时间:O(n^2). Visit all nodes once: 1 + 2 + 3 + .... n = n^2

#### DP
- 跟dfs的原理很像, `OR 原理: min(pathA, pathB) + currNode`
- init dp[n-1][j] = node values
- build from bottom -> top: dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
- 跟传统的coordinate dp有所不同, inner for loop 是需要计算 j <= i, 原因是triangle的性质.
- 空间: dp[n][n]. space: O(n^2)
- 时间:O(n^2). Visit all nodes once: 1 + 2 + 3 + .... n = n^2

#### DP + O(n) space 
- Based on the DP solution: the calculation always depend on `next row` for col at `j` and `j + 1`
- 既然只depend on next row, 可以用rolling array来处理: reduce to O(n) space.
- Further: 可以降维, 把第一维彻底去掉, 变成 dp[n]
- 同样是double for loop, 但是只在乎column changes: `dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);`  



---

**5. [Fast Power.java](https://github.com/awangdev/LintCode/blob/master/Java/Fast%20Power.java)**      Level: Medium      Tags: [DFS, Divide and Conquer]
      
如题: Calculate the a^n % b where a, b and n are all 32bit integers.

#### Divide and Conquer
- a^n可以被拆解成(a*a*a*a....*a)， 是乘机形式，而%是可以把每一项都mod一下的。所以就拆开来take mod.
- 这里用个二分的方法，recursively二分下去，直到n/2为0或者1，然后分别对待. 
- 注意1: 二分后要conquer，乘积可能大于Integer.MAX_VALUE, 所以用个long.
- 注意2: 要处理n%2==1的情况，二分时候自动省掉了一份 a，要乘一下。




---

**6. [Binary Tree Longest Consecutive Sequence II.java](https://github.com/awangdev/LintCode/blob/master/Java/Binary%20Tree%20Longest%20Consecutive%20Sequence%20II.java)**      Level: Medium      Tags: [DFS, Divide and Conquer, Double Recursive, Tree]
      
找到binary tree 里的最长 consecutive sequence. Sequence可以递增递减, Sequence顺序可以回溯parent.

#### DFS, Divide and Conquer
- Similar to Binary Tree Longest Consecutive Sequence I
- 只不过可以递增递减, 还有连接上parent的方向.
- 对于任何一个节点, 都可能: 
- 1. 自己跟两个child链接, 成为一个sequence
- 2. 左边孩子, 右边孩子各自是一个consecutive sequence, 但是不跟root相连
- main function 一开始就divide成这三份, 然后dfs
- dfs take diff == 1, diff == -1, 来做递增递减的校对.
- dfs rules:
- 1. if node == null, leaf depth = 0
- 2. if not consecutive, reset the depth = 0 (same for both left child, and right child)
- 3. compare the leftDepth && rightDepth to find the maximum
- 4. diff is the same in the same dfs loop to maintain consistant increase/decrease

##### 注意
- dfs的结果很可能是0, 如果没有任何结果, 那么上一层的caller depth = dfs() + 1 = 1
- 那么回归到root, dfs的结果很可能就是1.
- 可能会问: 那么在tree里面的partial sequence (不连接到root)的被忽略了?
- 这里 `longestConsecutive(root.left)` 就很重要了
- 这一步特地忽略掉了root, 然后走下去一层: 因为是recursive, 所以还会继续divde && conquer
- 最后, 任何一层的孩子都会被照顾到.

##### Double Recursive functions
- 用两种recursive的方式handle skip root node的情况
- Recursive using dfs(), basically build child + parent
- Recursive using main function, but with value of child node: skipping root



---

**7. [Flip Game II.java](https://github.com/awangdev/LintCode/blob/master/Java/Flip%20Game%20II.java)**      Level: Medium      Tags: [Backtracking, DFS, DP]
      
String 只包含 + , - 两个符号. 两个人轮流把consecutive连续的`++`, 翻转成 `--`.

如果其中一个人再无法翻转了, 另一个人就赢. 求: 给出string, 先手是否能赢.

#### Backtracking
- curr player 每走一步, 就生成一种新的局面, dfs on this
- 等到dfs结束, 不论成功与否, 都要backtracking
- curr level: 把"++" 改成 "--"; backtrack的时候, 改回 '--'
- 换成boolean[] 比 string/stringBuilder要快很多, 因为不需要重新生成string.
- ++ 可以走 (n - 1)个位置: 
- T(N) = (N - 2) * T(N - 2) = (N - 4) * (N - 2) * T(N - 4) ... = O(N!)

##### iterate based on "++"
- 做一个String s的 replica: string or stringBuilder
- 每次dfs后, 然后更替里面的字符 "+" => "-"
- 目的只是Mark已经用过的index
- 真正的dfs 还是在 original input string s 身上展开
- 每次都重新生成substring, 并不是很efficient

##### Game theory
- 保证p1能胜利，就必须保持所有p2的move都不能赢
- 或者说, 在知道棋的所有情况时, 只要p2有一种路子会输, p1就一定能走对路能赢.
- 同时，p1只要在可走的Move里面，有一个move可以赢就足够了。
- p1: player1, p2: player2

#### O(N^2) 的 DP
- 需要Game Theory的功底, Nim game. https://www.jiuzhang.com/qa/941/
- http://www.1point3acres.com/bbs/thread-137953-1-1.html
- TODO: https://leetcode.com/problems/flip-game-ii/discuss/73954/Theory-matters-from-Backtracking(128ms)-to-DP-(0ms)



---

**8. [Subtree of Another Tree.java](https://github.com/awangdev/LintCode/blob/master/Java/Subtree%20of%20Another%20Tree.java)**      Level: Easy      Tags: [DFS, Divide and Conquer, Tree]
      
#### Tree 
- Traverse tree: left, right
- Concept of partial compare vs. whole compare



---

**9. [Walls and Gates.java](https://github.com/awangdev/LintCode/blob/master/Java/Walls%20and%20Gates.java)**      Level: Medium      Tags: [BFS, DFS]
      
给一个room 2D grid. 里面有墙-1, 门0, 还有empty space INF(Math.MAX_VALUE). 

对每个empty space而言, fill it with dist to nearest gate.

#### DFS
- Form empty room: it can reach different gate, but each shortest length will be determined by the 4 directions. 
- Option1(NOT applicable). DFS on INF, mark visited, summerize results of 4 directions. 
- hard to resue: we do not know the direction in cached result dist[i][j]
- Option2. DFS on gate, and each step taken to each direction will +1 on the spot: distance from one '0'; 
- Through dfs from all zeros, update each spot with shorter dist
- Worst time: O(mn), where entre rooms[][] are gates. It takes O(mn) to complete the iteration. Other gates be skipped by `if (rooms[x][y] <= dist) return;`

#### BFS
- Exact same concept. Init with `Queue<int[]> queue = new LinkedList<int[]>()`



---

**10. [Decode String.java](https://github.com/awangdev/LintCode/blob/master/Java/Decode%20String.java)**      Level: Medium      Tags: [DFS, Divide and Conquer, Stack]
      
给一个expression string. 里面包括数字, 字母, 括号. 其中数字代表括号里面的内容重复几次.

括号里面可以是String, 也可能是expression.

目的: 把expression展开成一个正常的String.


#### Stack, Iteratively
- Process inner item first: last come, first serve, use stack.
- Record number globally and only use it when '[' is met.
- Stack存 [ ] 里面的内容, detect 括号开头结尾: 结尾时process inner string
- 有很多需要注意的细节才能做对:
- Stack<Object> 也可以用, 每个地方要注意 cast. 存进去的需要是Object: String, Integer
- 几个 type check: instanceof String, Character.isDigit(x), Integer.valueOf(int num)
- 出结果时候: `sb.insert(0, stack.pop())`


#### DFS
- Bottom->up: find deepest inner string first and expand from inside of `[ ]`
- 与Stack时需要考虑的一些function类似. 特别之处: **检查`[ ]`的结尾**
- 因为DFS时候, 括号里的substring会被保留着进入下一个level, 所以我们在base level要keep track of substring.
- 用int paren 来track 括号的开合, 当paren再次==0的时候 找到closure ']'
- 其他时候, 都要继续 append to substring




---

**11. [The Maze.java](https://github.com/awangdev/LintCode/blob/master/Java/The%20Maze.java)**      Level: Medium      Tags: [BFS, DFS]
      
#### BFS
- BFS on coordinates
- always attempt to move to end of border
- use boolean[][] visited to alingn with BFS solution in Maze II, III, where it uses Node[][] to store state on each item.



---

**12. [Median of Two Sorted Arrays.java](https://github.com/awangdev/LintCode/blob/master/Java/Median%20of%20Two%20Sorted%20Arrays.java)**      Level: Hard      Tags: [Array, Binary Search, DFS, Divide and Conquer]
      
著名的找两个sorted array的中位数. 中位数定义: 如果两个array总长为偶数, 取平均值.
题目要求在 log(m + n) 时间内解决

- 看到log(m+n), 就想到binary search, 或者是recursive 每次砍一半
- 两个sorted array 参差不齐, 肯定不能做简单的binary search

#### Divide and Conquer, recursive
- 这里有个数学排除思想: 考虑A, B各自的中间点.
- 如果A[mid] < B[mid], 那么 A[0 ~ mid - 1] 就不在 median的range里面, 可以排除. divide/conquer就这么来的.
- 具体逻辑看代码, 大致意思就是: 每次都取比较A 和 B [x + k / 2 - 1] 的位置, 然后做range 排除法
- end cases: 
- 1. 如果我们发现dfs()里面A或者B的start index溢出了, 那么就是最简单的case: midian一定在另外那个array里面
- 2. 如果 k == 1: 就是找A/B 里面的1st item, 那么做个 `Math.max(A[startA], B[startB])` 就可以
- 总共的数字长度是 (m + n) 而且每次都有一般的内容被删除, 那么time就是 O(log(m + n))




---

**13. [Word Search.java](https://github.com/awangdev/LintCode/blob/master/Java/Word%20Search.java)**      Level: Medium      Tags: [Array, Backtracking, DFS]
      

#### DFS, Backtracking:
- 找到开头的字母, 然后recursively DFS 去把word串到底:
- 每到一个字母, 朝四个方向走, 之中一个true就可以.
- Note:每次到一个字母，mark一下'#'. 4个path recurse回来后，mark it back.

#### Note: other ways of marking visited:
- 用一个boolean visited[][]
- Use hash map, key = x@y




---

**14. [Flood Fill.java](https://github.com/awangdev/LintCode/blob/master/Java/Flood%20Fill.java)**      Level: Easy      Tags: [DFS]
      
Same as MS Paint

#### DFS 
- track `boolean[][] visited`, validate before dfs



---

**15. [Construct Binary Tree from Inorder and Postorder Traversal.java](https://github.com/awangdev/LintCode/blob/master/Java/Construct%20Binary%20Tree%20from%20Inorder%20and%20Postorder%20Traversal.java)**      Level: Medium      Tags: [Array, DFS, Divide and Conquer, Tree]
      
#### DFS, Divide and Conquer
- 写个Inorder和Postorder的例子。利用他们分left/right subtree的规律解题。
- Postorder array 的末尾， 就是当下层的root.   
- 在Inorder array 里面找到这个root,就刚好把左右两边分割成left/right tree。
- 这题比较tricky地用了一个helper做recursive。 特别要注意处理index的变化, precisely考虑开头结尾
- runtime: O(n), visit && build all nodes

#### Improvement
- `findMid(arr)` can be replaced with a map<value, index>, no need execute O(n) search at runtime



---

**16. [Expression Evaluation.java](https://github.com/awangdev/LintCode/blob/master/Java/Expression%20Evaluation.java)**      Level: Hard      Tags: [Binary Tree, DFS, Expression Tree, Minimum Binary Tree, Stack]
      
给一个公式 expression, array of strings, 然后evaluate expression 结果.

#### DFS on Expression Tree
- 计算 expression 的值: 1. 建造 expression tree. 2. DFS计算结果
- Expression Tree: Minimum Binary Tree (https://lintcode.com/en/problem/expression-tree-build/)
- build好Min Tree以后，做PostTraversal. 
- Divde and Conquer: 先recursively找到 left和right的大小， 然后evaluate中间的符号
- Time, Space O(n), n = # expression nodes

#### Note
- 1. Handle数字时，若left&&right Child全Null,那必定是我们weight最大的数字node了。   
- 2. 若有个child是null,那就return另外一个node。    
- 3. prevent Integer overflow　during operation:过程中用个Long，最后结局在cast back to int.



---

**17. [Subtree.java](https://github.com/awangdev/LintCode/blob/master/Java/Subtree.java)**      Level: Easy      Tags: [DFS, Tree]
      
给一个binary tree s, 和一个binary tree t, 检查t是不是s的subtree.

#### DFS
- 跟 identical binary tree的写法很像
- 只有 current s.val = t.val 的时候才需要compare same tree.
- 其他情况, 继续recursively isSubtree
- 注意：即使找到T1 == T2, 但很可能只是数字相同（这里不是binary search tree!!）, 而children不同
- 所以同时要继续recursively isSubtree(T1.left, T2) ...etc.



---

**18. [Redundant Connection.java](https://github.com/awangdev/LintCode/blob/master/Java/Redundant%20Connection.java)**      Level: Medium      Tags: [BFS, DFS, Graph, Tree, Union Find]
      
#### unionFind
- keyword: tree has no `cycle`.
- 一旦两个node在edge中出现, 并且parent相同, 说明这两个node不union, 也在同一个tree里面, 所以可以break them.

#### Graph, DFS
- Add graph using adjacent list, and verify cycle alone the way
- IMPORTANT: use `pre` node in dfs to prevent backward dfs
- similar to `Graph Valid Tree` where it validates cycle and also needs to validate if all nodes are connected

#### BFS
- same concept as DFS, find first redundant edge that alreay exists in graph map.



---

**19. [Combinations.java](https://github.com/awangdev/LintCode/blob/master/Java/Combinations.java)**      Level: Medium      Tags: [Backtracking, Combination, DFS]
      
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

#### DFS, Backtracking
- for loop, recursive (dfs).
- 每个item用一次, 下一个level dfs(index + 1)
- Combination DFS. 画个图想想. 每次从1~n里面pick一个数字i
- 因为下一层不能重新回去 [0~i]选，所以下一层recursive要从i+1开始选。



---

**20. [Max Area of Island.java](https://github.com/awangdev/LintCode/blob/master/Java/Max%20Area%20of%20Island.java)**      Level: Easy      Tags: [Array, DFS]
      
#### DFS
- 虽然Easy, 但用到DFS最基本的想法.
- 1. dive deep
- 2. mark VISITED
- 3. sum it up
- Time: worst O(mn), traverse all possible nodes

- 更要注意, 要从符合条件value==1的地方开始dfs.
- 对于什么island都没有的情况，area应该位0， 而不是Integer.MIN_VALUE, 问清楚考官那小伙, 别写顺手。



---

**21. [Word Search II.java](https://github.com/awangdev/LintCode/blob/master/Java/Word%20Search%20II.java)**      Level: Hard      Tags: [Backtracking, DFS, Trie]
      
给一串words, 还有一个2D character matrix. 找到所有可以形成的words. 条件: 2D matrix 只可以相邻走位.

#### Trie, DFS
- 相比之前的implementation, 有一些地方可以优化:
- 1. Backtracking时候, 在board[][] 上面mark就可以, 不需要开一个visited[][]
- 2. 不需要implement trie的所有方程, 用不到: 这里只需要insert.
- 普通的trie题目会让你search a word, 但是这里是用一个board, 看board的每一个字母能不能走出个Word.
- 也就是: 这里的search是自己手动写, 不是传统的trie search() funcombination
- 3. TrieNode里面存在 end的时候存string word, 表示到底. 用完了 word = null, 刚好截断重复查找的问题.

##### 关于Trie
- Build Trie with target words: insert, search, startWith. Sometimes, just: `buildTree(words)` and return root.
- 依然要对board matrix做DFS。
- no for loop on words. 直接对board DFS:   
- 每一层,都会有个up-to-this-point的string. 在Trie里面check它是不是存在。以此判断。   
- 若不存在，就不必继续DFS下去了。
- Trie solution time complexity, much better:      
- build Trie:   n * wordMaxLength
- search: boardWidth * boardHeight * (4^wordMaxLength + wordMaxLength[Trie Search])


#### Regular DFS
- for loop on words: inside, do board DFS based on each word.     
- Time cpmplexity: word[].length * boardWidth * boardHeight * (4^wordMaxLength)

#### Previous Notes
- Big improvement: use boolean visited on TrieNode!     
- 不要用rst.contains(...), 因为这个是O(n) 在leetcode还是会timeout（lintcode竟然可以pass）!    
- 在Trie search() method 里面，凡是visit过的，mark一下。  




---

**22. [Convert Sorted Array to Binary Search Tree.java](https://github.com/awangdev/LintCode/blob/master/Java/Convert%20Sorted%20Array%20to%20Binary%20Search%20Tree.java)**      Level: Easy      Tags: [DFS, Divide and Conquer, Tree]
      
如题, build balanced BST from sorted array

#### DFS
- Binary Search Tree特点: 左边的node都比右边的node小. 
- height balance, subtree height 相差<1, 必须左右sub tree均分. 做DFS(num, start, end)
- 在每一个level, 找到中间点, 然后分割2半, 继续dfs
- Divide and Conquer
- time/space: O(n), visit all nodes, no redundant visits.



---

**23. [Populating Next Right Pointers in Each Node.java](https://github.com/awangdev/LintCode/blob/master/Java/Populating%20Next%20Right%20Pointers%20in%20Each%20Node.java)**      Level: Medium      Tags: [DFS, Divide and Conquer, Tree]
      
给一个特殊的binary tree, treeNode里面有一个 next pointer.

写一个function, 把所有node都更同level的node 连在一起. 最右边的node.next = NULL

#### DFS + Divide and Conquer
- 题目要求DFS. 想清楚了如何在DFS level把几种情况都考虑了, 写起来很简单. NOT BFS, because requires O(1) space
- 对于一个root来说, 只有几个点可以顾忌到: root.left, root.right, root.next. 
- 想办法把这三个方向的点, 能连起来的都连起来:
- 1. `node.left.next = node.right`
- 2. If `node.next != null`, link `node.right.next = node.next.left`;
- 然后在dfs(root.left), dfs(root.right)
- Time: visit && connect all nodes, O(n)

#### BFS
- 不和题意，用了queue space，与Input成正比。太大。
- BFS over Tree。 用Queue 和 queue.size()，老规矩。   
- process每层queue时, 注意把next pointer加上去就好. 



---

**24. [Find Peak Element II.java](https://github.com/awangdev/LintCode/blob/master/Java/Find%20Peak%20Element%20II.java)**      Level: Hard      Tags: [Binary Search, DFS, Divide and Conquer]
      
2Dmatrix, 里面的value有一些递增, 递减的特点(细节比较长, 看原题). 目标是找到peak element

peak: 比周围4个方向的点value大

#### DFS

##### 基本原理
- 我们不可能一口气准确定位(x,y), 但是我们可以再一个row/col里面, 找到1D array的 peak.
- 根据这个点, 再往剩下两个方向移动
- 1. 在中间的一行i=midX, 找到peak所在的y.
- 2. 在中间的一列j=midY, 找到peak所在的x. (有可能强势override之前找到的y, 也就是放弃那一行的peak, 在midY上找peak)
- 3. 根据 (x,y) 的4个neighbor check (x,y)是不是 peak, 如果不是, 像更高的位置移动一格
- 4. 根据之前算的 midX, midY 把board分成4个象限, 在每一份里面再继续找
- 这个题目LintCode不给做了, 所以思路对的, 但是解答还没有再次验证.

##### 剪枝/切分象限
- 每次只是找到一个row/col里面的peak而已!
- 找到这个点, 就等于把board切成了两半.
- 然后, 再跟剩下的相邻的两个位置比较, 就知道了哪里更大, 就去哪里找peak, 也就是又切了第二刀.
- 切第二刀的时候, 也要把(x, y) 移到需要取的象限. 进行DFS
- 根据mid row 切割: 
- http://www.jiuzhang.com/solution/find-peak-element-ii/#tag-highlight-lang-java
- http://courses.csail.mit.edu/6.006/spring11/lectures/lec02.pdf

##### 时间复杂度
- 每一个level都减一半
- T(n) = n + T(n/2) = n + n/2 + n/4 + ... + 1 = n(1 + 1/2 + .... + 1/n) = 2n = O(n)

#### Binary Search
- TODO
- O(nLogN)



---

**25. [Redundant Connection II.java](https://github.com/awangdev/LintCode/blob/master/Java/Redundant%20Connection%20II.java)**      Level: Hard      Tags: [DFS, Graph, Tree, Union Find]
      
#### Union Find
- 讨论3种情况
- http://www.cnblogs.com/grandyang/p/8445733.html



---

**26. [Tweaked Identical Binary Tree.java](https://github.com/awangdev/LintCode/blob/master/Java/Tweaked%20Identical%20Binary%20Tree.java)**      Level: Easy      Tags: [DFS, Tree]
      
检查binary tree是否 identical. 

特点: subtree如果是有旋转的, 只要tree node value相等, 就可以算是identical

#### DFS
- 在DFS的基础上, 比对左左,左右,右左,右右



---

**27. [Subsets II.java](https://github.com/awangdev/LintCode/blob/master/Java/Subsets%20II.java)**      Level: Medium      Tags: [Array, BFS, Backtracking, DFS]
      

给一串integers(may have duplicates), 找到所有可能的subset. result里面不能有重复.

#### DFS
- DFS, 找准需要pass along的几个数据结构. 先`sort input`, 然后DFS
- Using for loop approach: 每个dfs call是一种可能性，直接add into result.     
- 为了除去duplicated result, skip used item at current level: `if (i > depth && nums[i] == nums[i - 1]) continue;`
- sort O(nlogn), subset: O(2^n)
- space O(2^n), save results

#### BFS
- Regular BFS, 注意考虑如果让one level to generate next level
- skip duplicate: `if (i > endIndex && nums[i] == nums[i - 1]) continue;`
- 1. 用queue来存每一次的candidate indexes
- 2. 每一次打开一层candiates, add them all to result
- 3. 并且用每一轮的candidates, populate next level, back into queue.
- srot O(nlogn), subset: O(2^n)
- should be same O(2^n). slower than dfs

#### Previous notes:
- 在DFS种skip duplicate candidates, 基于sorted array的技巧：    
- 一旦for loop里面的i!=index，并且nums[i] == nums[i-1],
- 说明x=nums[i-1]已经在curr level 用过，不需要再用一次: [a,x1,x2]，x1==x2    
- i == index -> [a,x1]    
- i == index + 1 -> [a,x2]. 我们要skip这一种
- 如果需要[a,x1,x2]怎么办？ 其实这一种在index变化时，会在不同的两个dfs call 里面涉及到。

#### 注意
- 不能去用result.contains(), 这本身非常costly O(nlogn)
- 几遍是用 list.toString() 其实也是O(n) iteration, 其实也是增加了check的时间, 不建议




---

**28. [Segment Tree Modify.java](https://github.com/awangdev/LintCode/blob/master/Java/Segment%20Tree%20Modify.java)**      Level: Medium      Tags: [Binary Tree, DFS, Divide and Conquer, Lint, Segment Tree]
      
给一个segmentTree, node里面存max. 写一个modify function: modify(node, index, value).

#### Segment Tree, Divide and Conquer
- Recursively 在segment tree里面找index, update it with value.   
- 每个iteration，很可能（要么左手，要么右手）max就变了。所以每次都left.max and right.max compare一下
- 最后轮回到头顶，头顶一下包括头顶，就全部都是max了



---

**29. [Kth Smallest Element in a BST.java](https://github.com/awangdev/LintCode/blob/master/Java/Kth%20Smallest%20Element%20in%20a%20BST.java)**      Level: Medium      Tags: [BST, DFS, Stack, Tree]
      
#### Iterative + stack: inorder traversal
- 很容想到Inorder-binary-search-tree Traversal
- Iterative 稍微难想点：先把最左边的add， pop() stack， 加上右边（如果存在）； 下一个轮回，如果又左孩子，又是一顿加。

#### Recursive + DFS
- 然后稍微优化一下，确保rst.size() == k 时候，就可以return了
- check leaf => dfs left => add root => dfs right



---

**30. [Robot Room Cleaner.java](https://github.com/awangdev/LintCode/blob/master/Java/Robot%20Room%20Cleaner.java)**      Level: Hard      Tags: [Backtracking, DFS]
      
#### DFS
- Different from regular dfs to visit all, the robot move() function need to be called, backtrack needs to move() manually and backtracking path shold not be blocked by visited positions
- IMPORTANT: Mark on the way in using set, but `backtrack directly without re-check against set`
- Mark coordinate 'x@y'
- Backtrack: turn 2 times to revert, move 1 step, and turn 2 times to revert back.
- Direction has to be up, right, down, left.
- `int [] dx = {-1, 0, 1, 0};`, `int[] dy = {0, 1, 0, -1};`



---

**31. [Invert Binary Tree.java](https://github.com/awangdev/LintCode/blob/master/Java/Invert%20Binary%20Tree.java)**      Level: Easy      Tags: [BFS, DFS, Tree]
      
#### DFS
- 简单处理swap
- recursively swap children

#### BFS
- BFS with Queue
- 每次process一个node, swap children; 然后把child加进queue里面
- 直到queue process完



---

**32. [Number of Connected Components in an Undirected Graph.java](https://github.com/awangdev/LintCode/blob/master/Java/Number%20of%20Connected%20Components%20in%20an%20Undirected%20Graph.java)**      Level: Medium      Tags: [BFS, DFS, Graph, Union Find]
      
给一个数字n代表n nodes, marked from 1 ~ n, 和一串undirected edge int[][]. 

count这个graph里面有多少个独立的component.

#### Union Find
- 跟Graph Valid Tree 几乎一模一样
- 建造简单的parent[] union find
- 每个edge都union.
- **注意** union 的时候, 只需要union if rootA != rootB

#### DFS
- build graph as adjacent list: Map<Integer, List<Integer>>
- dfs for all nodes of the graph, and mark visited node
- count every dfs trip and that will be the total unions



---

**33. [Find the Connected Component in the Undirected Graph.java](https://github.com/awangdev/LintCode/blob/master/Java/Find%20the%20Connected%20Component%20in%20the%20Undirected%20Graph.java)**      Level: Medium      Tags: [BFS, DFS]
      
给一个undirected graph, return 所有的component. (这道题找不到了)  

#### BFS
- BFS遍历，把每个node的neighbor都加进来. 
- 一定注意要把visit过的node Mark一下。因为curr node也会是别人的neighbor，会无限循环。      
- Component的定义：所有Component内的node必须被串联起来via path (反正这里是undirected, 只要链接上就好)     
- 这道题：其实component在input里面都已经给好了，所有能一口气visit到的，全部加进queue里面，他们就是一个component里面的了。     
- 而我们这里不需要判断他们是不是Component

#### DFS
- DFS 应该也可以 visit all nodes, mark visited.



---

**34. [Surrounded Regions.java](https://github.com/awangdev/LintCode/blob/master/Java/Surrounded%20Regions.java)**      Level: Medium      Tags: [BFS, DFS, Matrix DFS, Union Find]
      
给一个2D board, 里面是 'X' 和 'O'. 把所有被X包围的area都涂成'X'. 

从四个边的edge出发, 像感染僵尸病毒一样扩散, 把靠边的node全部mark, 然后将还是'O'的改成X, 最后回复marks -> 'O'

#### Union Find
- UnionFind里面这次用到了一个rank的概念, 需要review. rank[] 也就是在tracking每一个node所在union的size.
- 目的是: always并到大的union里面
- note: 将2D coordinate (x,y) 转换成1D: index = x * n + y

#### DFS: mark all invalid 'O'
- Reversed thinking: find surrounded nodes, how about filter out border nodes && their connections?
- Need to traverse all the border nodes, consider dfs, visit all.
- loop over border: find any 'O', and dfs to find all connected nodes, mark them as 'M'
- time: O(mn) loop over all nodes to replace remaining 'O' with 'X'

#### DFS: mark all valid 'O'
- More like a graph problem: traverse all 'O' spots, and mark as visited int[][] with area count [1 -> some number]
- Run dfs as top->bottom: mark area count and dsf into next level
- End condition: if any 'O' reaches border, mark the global map<count, false>
- keep dfs untill all connected nodes are visited.
- At the end, O(mn) loop over the matrix and mark 'X' for all the true area from map.
- Practice: write code to verify

### BFS
- TODO



---

**35. [Expression Add Operators.java](https://github.com/awangdev/LintCode/blob/master/Java/Expression%20Add%20Operators.java)**      Level: Hard      Tags: [Backtracking, DFS, Divide and Conquer, String]
      

给一个数字String, 数字来自`0-9`, 给3个操作符 `+`,`-`,`*`, 看如何拼凑, 可以做出结果target.

output 所有 expression

#### string dfs, use list to track steps (backtracking)
- 跟string相关, 写起来可能稍微繁琐一点
    - 数字有 dfs([1,2,3...]) 组合方法
    - operator有[`+`,`-`,`*`] 3种组合方法
- 注意1: 乘号要特殊处理, pass along 连乘的数字, 计算下一步乘积的时候, 要 sum - preProduct + product
- 注意2: '01' 这种数字要skip
- 注意3: 第一个选中数字不需要加操作符, 直接加进去
- Time: O(4^n)， Space: O(4^n)
- T(n) = 3 * T(n-1) + 3 * T(n-2) + 3 * T(n-3) + ... + 3 *T(1);
- T(n-1) = 3 * T(n-2) + 3 * T(n-3) + ... 3 * T(1);
- Thus T(n) = 4T(n-1) = 4^2 * T(n - 1) = .... O(4^n)

#### String dfs, use string as buffer
- 逻辑一样, 代码更短, 只不过不做list, 直接pass `buffer + "+" + curr`
- 因为每次都创建新string, 所以速度稍微慢一点. Time complexity 一样



---

**36. [Cracking the Safe.java](https://github.com/awangdev/LintCode/blob/master/Java/Cracking%20the%20Safe.java)**      Level: Hard      Tags: [DFS, Greedy, Math]
      
#### Greedy, Iterative
- For 2 passwords, the shortest situation is both passwords overlap for n-1 chars.
- We can use a window to cut out last (n-1) substring and append with new candidate char from [k-1 ~ 0]
- Track the newly formed string; if new, add the new char to overall result
- Note: this operation will run for k^n times: for all spots of [0 ~ n - 1] each spot tries all k values [k-1 ~ 0]
- Same concept as dfs

#### DFS
- Same concept: use window to cut out tail, and append with new candidate
- do this for k^n = Math.pow(k, n) times



---

**37. [Merge Two Binary Trees.java](https://github.com/awangdev/LintCode/blob/master/Java/Merge%20Two%20Binary%20Trees.java)**      Level: Easy      Tags: [DFS, Tree]
      
#### DFS
- 基础binary tree traversal. 注意对null child的判断



---

**38. [Path Sum II.java](https://github.com/awangdev/LintCode/blob/master/Java/Path%20Sum%20II.java)**      Level: Easy      Tags: [Backtracking, DFS, Tree]
      
给一个inputSum, 然后dfs, 找到所有path, 满足: path sum 跟 inputSum 一样.

#### DFS, Backtracking
- 用remaining sum 来检测是否满足 input path sum 条件
- 满足的时候add to result list
- 两种backtracking:
- 1. backtrack 当下node, 加进list, 然后dfs. dfs结束后删掉之前加进去的元素. 非常clean.
- 2. backtrack 下一个dfs level增加的value. dfs return 之后, 删掉list里面的末尾元素: 但是删掉的dfs余下的value.
- 第一种backtrack更加好掌握.

#### Previous Notes:
- Binary Tree的一个基本题: 找到所有满足条件的path
- 遍历到底，比较sum vs. target
- 注意divide的情况。要把遍历的例子写写



---

**39. [Segment Tree Query II.java](https://github.com/awangdev/LintCode/blob/master/Java/Segment%20Tree%20Query%20II.java)**      Level: Medium      Tags: [Binary Tree, DFS, Divide and Conquer, Lint, Segment Tree]
      
#### Segment Tree
- 和 Segment Tree Query I 以及其他Segment Tree类似: 这个SegmentTreeNode return count of elements in range
- 这个题目考了validate input source：input 的start,end可能超出root[start,end]。   
- 那么第一步就要先clear一下: 1. 完全不在range就return 0. 2. 有range重合就规整到root的range.




---

**40. [Longest Increasing Path in a Matrix.java](https://github.com/awangdev/LintCode/blob/master/Java/Longest%20Increasing%20Path%20in%20a%20Matrix.java)**      Level: Hard      Tags: [Coordinate DP, DFS, DP, Memoization, Topological Sort]
      
m x n 的matrix, 找最长增序的序列长度. 这里默认连续的序列.

- 接成圈是不行的, 所以visit过得 (x,y)就不能再去了.
- 斜角方向不能走, 只能走上下左右
- 无法按照坐标DP来做, 因为计算顺序4个方向都可以走.
- 最终要visit所有node, 所以用DFS搜索比较合适.

#### DFS, Memoization
- 简单版: longest path, only allow right/down direction: 
- `dp[x][y] = Math.max(dp[prevUpX][prevUpY], or dp[prevUpX][prevUpY] + 1)`; and compare the other direction as well
- This problem, just compare the direction from dfs result
- DFS太多重复计算; memoization (dp[][], visited[][]) 省去了重复计算
- initialize dp[x][y] = 1, (x,y) 自己也算path里的一格
- dfs(matrix, x, y): 每次检查(x,y)的4个neighbor (nx, ny), 如果他们到(x,y)是递增, 那么就考虑和比较:
- Maht.max(dp[x][y], dp[nx][ny] + 1); where dp[n][ny] = dfs(matrix, nx, ny)
- top level: O(mn), 尝试从每一个 (x,y) 出发
- O(m * n * k), where k is the longest path

#### Topological sort
还没有做



---

**41. [Recover Binary Search Tree.java](https://github.com/awangdev/LintCode/blob/master/Java/Recover%20Binary%20Search%20Tree.java)**      Level: Hard      Tags: [BST, DFS, Tree]
      
BST里面有2个node misplace, 要归为. 要求: O(1) extra space

#### Observation
- BST inorder traversal should give small -> large sequence
- misplaced means: a **large**->small item would occur, and later a large>**small** would occur. 
- The first large && second small item are the 2 candidates. Example
- [1, 5,  7, 10,    12, 15, 18]
- [1, 5, `15, 10`, `12,  7`, 18]

#### dfs, O(1) extra space
- traverse, and take note of the candidate
- at the end, swap value of the 2 candidates

#### O(n) space
- inorder traversal the nodes and save in array, find the 2 items misplanced and swap them
- But O(n) space should not be allowed




---

**42. [Strobogrammatic Number II.java](https://github.com/awangdev/LintCode/blob/master/Java/Strobogrammatic%20Number%20II.java)**      Level: Medium      Tags: [DFS, Enumeration, Math, Sequence DFS]
      
TODO: 
1. use list, iterative? keep candidates and populating
2. clean up the dfs code, a bit messy
3. edge case of "0001000" is invalid, right?

#### DFS
- A bit like BFS solution: find inner list, and then combine with outter left/right sides.
- find all solutions, DFS will be easier to write than iterative/BFS
- when n = 1, there can be list of candidates at bottom of the tree, so bottom->up is better
- bottom->up, dfs till leaf level, and return candidates.
- each level, pair with all the candidates
- 其实就是剥皮，一层一层，是一个central-depth-first的，钻到底时候，return n=1,或者n=2的case，然后开始backtracking。
- 难的case先不handle.到底之后来一次overall scan.
- every level have 5 choices of digital pairs to add on sides. Need to do for n-2 times. 
- Time complexity: O(5^n)



---

**43. [The Maze II.java](https://github.com/awangdev/LintCode/blob/master/Java/The%20Maze%20II.java)**      Level: Medium      Tags: [BFS, DFS, PriorityQueue]
      
#### BFS
- if already found a good/shorter route, skip
- `if (distMap[node.x][node.y] <= node.dist) continue;`
- This always terminates the possibility to go return to original route, because the dist will be double/higher



---

**44. [Convert Sorted List to Binary Search Tree.java](https://github.com/awangdev/LintCode/blob/master/Java/Convert%20Sorted%20List%20to%20Binary%20Search%20Tree.java)**      Level: Medium      Tags: [BST, DFS, Divide and Conquer, Linked List]
      
如题, 把一个sorted singly linked list 转换成一个 height balanced BST

#### DFS
- Divide and Conquer   
- 找到mid node
- 然后分割两半, 分别dfs做各自两个subtree: node.left,node.right
- 用长度来定位mid, 每次找中间点做root, 然后前半段, 后半段分别dfs with length.
- 用快慢pointer 找到mid. Better: 不用traverse entire linked list

#### Details
- slowPointer = node;
- fastPointer = node.next;
- 然后把root = mid.next     
- 然后开始sortedListToBST(mid.next.next); //后半段    
- mid.next = null;//非常重要，要把后面拍过序的断掉    
- sortedListToBST(head); //从头开始的前半段     
- 最后root.left, root.right merge一下。   



---

**45. [Smallest Subtree with all the Deepest Nodes.java](https://github.com/awangdev/LintCode/blob/master/Java/Smallest%20Subtree%20with%20all%20the%20Deepest%20Nodes.java)**      Level: Medium      Tags: [DFS, Divide and Conquer, Tree]
      

给一个tree, 按照题意找最一个node满足: 
1. 这个node的subtree涵盖最深level的所有leaves. 
2. 这个node必须是能找到的最deep那个

条件2的需求是因为: root本身就是满足条件1的node, 还有很多Higher-level node也是如此, 所以要找那个deepest.


#### DFS on tree
- 分析题目, 思想是: 看到tree里面所有的leaves, 找到他们最deep的 common ancestor
- Maintain a map <Node, maxChildDepth>
- Recursively dfs: return deepest node that has all leaves by these comparisons:
- 1. If left,right child same depth, return root: they need common ancestor
- 2. If not same depth, return the one with larger depth
- 被传送去上一个level的, 永远都是subtree里面符合题意的: the node containing all leaf nodes
- Visit all nodes once O(n), space O(n)

#### BFS
- Find all leaves at deepest level
- Use map to track each node-parent
- Backtrack all nodes to find common ancestor



---

**46. [Combination Sum III.java](https://github.com/awangdev/LintCode/blob/master/Java/Combination%20Sum%20III.java)**      Level: Medium      Tags: [Array, Backtracking, Combination, DFS]
      
给一个integer k, 和一个target n. 

从positive数字[1 ~ 9], 找到所有unique的 组合(combination) int[], size = k, 要求每个combination的和 = n.

(隐藏条件, 需要clarify): 同一个candidate integer [1 ~ 9], 只可以用一次.

#### DFS, Backtracking
- 跟Combination Sum I, II 没什么太大区别, 只不过, 一定要用k个数字, 也就是一个for loop里面的特别条件
- 考虑input: 没有重复数字 [1 ~ 9]
- 考虑candidate重复利用: 不可以重复利用, next level dfs 时候, curr index + 1
- the result is trivial, save success list into result.

##### Time Complexity
- Which one?
- worst case: tried all numbers and cannot find: O(m!), m = 9, all possible integers in [1~9]
- C(n,k), n choose k problem : `n! / (k! * (n-k)!)` => ends up being `O(min(n^k, n^(n-k)))`



---

**47. [Path Sum III.java](https://github.com/awangdev/LintCode/blob/master/Java/Path%20Sum%20III.java)**      Level: Easy      Tags: [DFS, Double Recursive, Tree]
      
count所有存在的 path sum == target sum. 可以从任意点开始. 但是只能parent -> child .

#### DFS
- 对所给的input sum 做减法, 知道 sum 达到一个目标值截止
- 因为可以从任意点开始, 所以当sum达标时候, 需要继续recursive, 从而找到所有情况 (有正负数, sum可能继续增加/减少)
- 经典的 helper dfs recursive + self recursive
- 1. helper dfs recursive 处理包括root的情况
- 2. self recursive 来引领  skip root的情况.

#### 特点
- 与 `Binary Tree Longest Consecutive Sequence II` 在recursive的做法上很相似: 
- 利用dfs做包括root的recursive computation
- 利用这个function自己, 做`不包括root的recursive computation`



---

**48. [Convert Expression to Reverse Polish Notation.java](https://github.com/awangdev/LintCode/blob/master/Java/Convert%20Expression%20to%20Reverse%20Polish%20Notation.java)**      Level: Hard      Tags: [Binary Tree, DFS, Expression Tree, Stack]
      
给一串字符, 用来表示公式expression. 把这个expression转换成 Reverse Polish Notation (RPN).

#### Expression Tree
- Expression Tree: Minimum Binary Tree (https://lintcode.com/en/problem/expression-tree-build/)
- 根据题意做出Expression Tree出来以后: 来个Post-order-traversal 就能记录下 Reverse Polish Notation
- 本题没有给'ExpressionTreeNode', 所以把TreeNode就当做成我们需要的node, 里面扩展成有left/right child就可以了.



---

**49. [Word Ladder II.java](https://github.com/awangdev/LintCode/blob/master/Java/Word%20Ladder%20II.java)**      Level: Hard      Tags: [Array, BFS, Backtracking, DFS, Hash Table, String]
      
给一串string, start word, end word. 找到所有从 startWord -> endWord的最短路径list. 

变化方式: mutate 1 letter at a time.

#### BFS + Reverse Search
- 用BFS找最短路径.
- 问题: how to effectively store the path, if the number of paths are really large? 
- If we store Queue<List<String candidates>>: all possibilities will very large and not maintainable
- 用BFS做出一个反向structure, 然后再reverse search

##### BFS Prep Step
- BFS 找到所有start string 可以走到的地方 s, 放在一个overall structure里面: 注意, 存的方式 Map<s, list of sources>
- BFS时候每次都变化1step, 所以记录一次distance, 其实就是最短路径candidate (止步于此)
- 1. 反向mutation map: `destination/end string -> all source candidates` using queue: `Mutation Map`
- Mutation Map<s, List<possible src>>: list possible source strings to mutate into target key string.
- 2. 反向distance map: `destination/end string -> shortest distance to reach dest`
- Distance Map<s, possible/shortest distance>: shortest distance from to mutate into target key string.
- BFS prep step 并没解决问题, 甚至都没有用到end string. 我们要用BFS建成的反向mapping structure, 做search

##### Search using DFS
- 从结尾end string 开始扫, 找所有可以reach的candidate && only visit candidate that is 1 step away
- dfs 直到找到start string.

##### Bi-directional BFS: Search using BFS
- reversed structure 已经做好了, 现在做search 就可以: 也可以选用bfs.
- `Queue<List<String>>` to store candidates, searching from end-> start



---

**50. [The Maze III.java](https://github.com/awangdev/LintCode/blob/master/Java/The%20Maze%20III.java)**      Level: Hard      Tags: [BFS, DFS, PriorityQueue]
      
#### BFS
- 跟 Maze I, II 类似, 用一个 Node[][] 来存每一个(x,y)的state.
- Different from traditional BFS(shortest path): `it terminates BFS when good solution exists (distance), but will finish all possible routes`
- 1. `Termination condition`: if we already have a good/better solution on nodeMap[x][y], no need to add a new one
- 2. Always cache the node if passed the test in step1
- 3. Always offer the moved position as a new node to queue (as long as it fits condition)
- 4. Finally the item at nodeMap[target.x][target.y] will have the best solution.



---

**51. [Binary Tree Longest Consecutive Sequence.java](https://github.com/awangdev/LintCode/blob/master/Java/Binary%20Tree%20Longest%20Consecutive%20Sequence.java)**      Level: Medium      Tags: [DFS, Divide and Conquer, Tree]
      
找到binary tree 里的最长 consecutive sequence.

#### DFS
- Divide and Conquer. dfs
- 分开 看左边/右边
- 如果左边满足连续递增的规则, dfs (depth + 1), 如果不满足规则, dfs(depth = 1)
- 右边也是一样
- 对结果跟max作比较, return



---

**52. [Path Sum IV.java](https://github.com/awangdev/LintCode/blob/master/Java/Path%20Sum%20IV.java)**      Level: Medium      Tags: [DFS, Hash Table, Tree]
      
给一串3-digit 的数组. 每个数字的表达一个TreeNode, 3 digit分别代表: depth.position.value

这串数字已经从小到大排列. 求: 所有可能的 root->leaf path 的所有可能的 path sum 总和. 

#### DFS, Hash Table
- 因为`前两个digit可以uniquely identify`一个node, 所以可以把前两个digit作为key, 定位node.
- 特点: 比如考虑root, 有 n 个leaf, 就会加 n 遍root, 因为有 n 个 unique path嘛.
- 实现: 每个node, 上来先把curr value加进sum; 只要有child, 到这个node位置的以上path sum 就要被重加一次.
- format: depth.position.value. (on same level, position may not be continuous)
- approach: map each number into: <depth.position, value>, and dfs. 
- Start from dfs(map, rootKey, sum):
- 1. add node value to sum
- 2. compute potential child.
- 3. check child existence, if exist, add sum to result (for both left/right child). Check existence using the map.
- 4. also, if child exist, dfs into next level
- Space, time O(n)



---

**53. [Target Sum.java](https://github.com/awangdev/LintCode/blob/master/Java/Target%20Sum.java)**      Level: Medium      Tags: [DFS, DP]
      
// 如何想到从中间initialize



---

**54. [Populating Next Right Pointers in Each Node II.java](https://github.com/awangdev/LintCode/blob/master/Java/Populating%20Next%20Right%20Pointers%20in%20Each%20Node%20II.java)**      Level: Medium      Tags: [DFS, Tree]
      

给一个binary tree, 用constant space link 所有所有node.next to same level next node.

#### DFS
- 用constant space 也就是不可以BFS, 但是mention了用dfs stack space没问题 (提示啊!)
- 1. link leftChild -> rightChild
- 2. resolve root.rightMost child -> first possible root.next.left/right child
- 3. dfs connect(rightChild), connect(leftChild)
- Each level should be fully linked from left side, so every reach to parent will have valid path or end.

#### Trick
- 1. 处理 nextNode -> next -> next ...的case: 找到第一个有child的next node才可以罢休. 这个case很容易miss
- 2. 我们的假设是, 上一个level的所有node都应该是linked, 那么在dfs时候, 就应该先connect(root.right). 右孩子的全处理完毕, 那么trick1才可以施行.



---

**55. [[lint]. Segment Tree Query.java](https://github.com/awangdev/LintCode/blob/master/Java/[lint].%20Segment%20Tree%20Query.java)**      Level: Medium      Tags: [Binary Tree, DFS, Divide and Conquer, Lint, Segment Tree]
      
给了segment Tree, node里面有Max value, 找[start,end]里面的max

#### Segment Tree, Divide and Conquer
- 根据[start,end]跟 mid of (root.start, root.end) 做比较:
	- 1) [start,end] on LEFT of mid
	- 2) [start, end] on RIGHT of mid
	- 3) [start, end] includes mid: break into 2 queries
		- query [leftNode, start, node.left.end]
		- query [rightNode, node.right.start, end]



---

**56. [[tool]. Topological Sorting.java](https://github.com/awangdev/LintCode/blob/master/Java/[tool].%20Topological%20Sorting.java)**      Level: Medium      Tags: [BFS, DFS, Lint, Topological Sort]
      

#### Topological Sort BFS
- indegree tracking: Track all neighbors/childrens. 把所有的children都存在 inDegree<label, indegree count>里面
- Process with a queue: 先把所有的root加一遍(indegree == 0)，可能多个root。并且全部加到queue里面。
- BFS with Queue:
- Only when map.get(label) == 0, add into queue && rst. (indegree剪完了, 就是root啦)
- inDegree在这里就 count down indegree, 确保在后面出现的node, 一定最后process.


#### Basics about graph
- 几个graph的condition：   
- 1. 可能有多个root
- 2. directed node, 可以direct backwards.

TODO:
- build`Map<DirectedGraphNode, Integer> inDegree = new HashMap<>();` and include the root itself
- that is more traditional indegree building



---

**57. [102. Binary Tree Level Order Traversal.java](https://github.com/awangdev/LintCode/blob/master/Java/102.%20Binary%20Tree%20Level%20Order%20Traversal.java)**      Level: Medium      Tags: [BFS, DFS, Tree]
      

如题.

#### Method1: BFS
- 最普通,Non-recursive: BFS, queue, 用个queue.size()来end for loop:换行。   
- 或者用两个queue. 当常规queue empty，把backup queue贴上去

#### Method2: DFS
- 每个level都应该有个ArrayList. 那么用一个int level来查看：是否每一层都有了相应的ArrayList。   
- 如果没有，就加上一层。    
- 之后每次都通过DFS在相应的level上面加数字。




---

**58. [269. Alien Dictionary.java](https://github.com/awangdev/LintCode/blob/master/Java/269.%20Alien%20Dictionary.java)**      Level: Hard      Tags: [BFS, Backtracking, DFS, Graph, Topological Sort]
      

给一个 array of strings: 假如这个array是按照一个新的字母排序表(alien dictionary)排出来的, 需要找到这个字母排序.

有可能有多重排序的方法, 给出一种就可以.

#### Graph, Topological Sort with InDegree count, BFS
- `Build graph`:
    - 上下两行string, 相对应的相同的index上, 如果字母不同, 就说明排在第一行的字母在字母表里更领先: form sequence between chars
    - form graph Map<Char, List of Chars>, for topological sort usage.
    - 也可以`List[26] edges` (Course Schedule problem)
- `Build InDegreeCountMap<Char, Count>`: based on the char diff of 2 words
    - 注意: indegree 是反向的 (跟 node to neighbors 相反的方式建立)
- `Topological Sort`, BFS:
    - 1) use queue to find `inDegree == 0` node. It is the letter that points to others, 排在字母表前面.
    - 2) reduce edges using Graph`map<Character, List<Character>>` (more generic than List[26], 26个字母的dictionary)
- Edge Case:
    - `inDegreeCountMap.size() != result.length()`: some nodes did not make it into result sequence
    - `cycle`: when inDegree of a one node would never reduce to 0, and will not be added to result
        - In this case, it will be treated as invalid input, and return ""
- space: O(n), n = # of graph edges 
- time: O(n)

#### DFS
- TODO
- 跟BFS建立 grpah 的过程一模一样
- DFS的不同在于: 用visited map 来标记走过的地方
- 走到leaf的时候, add to result: 但因为走到了底才add, 最终的顺序应该颠倒 (或者, sb.insert(0, x) 直接用颠倒的顺序add)



---

**59. [22. Generate Parentheses.java](https://github.com/awangdev/LintCode/blob/master/Java/22.%20Generate%20Parentheses.java)**      Level: Medium      Tags: [Backtracking, DFS, Sequence DFS, String]
      

#### DFS
- start with empty string, need to go top->bottom
- 取或者不取`(`, `)`
- rule: open parentheses >= close parentheses
- Note: 在DFS时 pass a reference (StringBuffer) and maintain, instead of passing object (String) and re-create every time
- time: O(2^n), pick/not pick, the decision repat for all nodes at every level
- time: T(n) = 2 * T(n - 1) + O(1) = O(2^n)
- space: < than 2^n results = O(2^n)

#### bottom->up DFS
- figure out n=1, n=2 => build n=3, and n=4
- dfs(n-1) return a list of candidates
- add a pair of `()` to the candidates: either in front, at end, or contain the candidates



---

**60. [236. Lowest Common Ancestor of a Binary Tree.java](https://github.com/awangdev/LintCode/blob/master/Java/236.%20Lowest%20Common%20Ancestor%20of%20a%20Binary%20Tree.java)**      Level: Medium      Tags: [DFS, Tree]
      

给一个Binary Tree root, 以及两个node p, q. 找 p 和 q 的 lowest common ancestor

#### DFS
- 因为是 binary tree, 所以直接盲目搜索搜索path不efficient, use extra space and waste time
- 巧用DFS来找每一个node的common ancestor. Need the assumption: 1. unique nodes across tree; 2. must have a solution
  - Base Case: 当root == null, p or q is found (`root == p || root == q`)，那么就return the root as LCA
  - 三种情况:
    - 1. leftLCA and rightLCA all found: `each path has found one of p and q node as LCA`. Therefore, curr root is the lowest ancestor
    - 2. One of leftLCA and rightLCA is found: return whichever one found
    - 3. both LCAs are null, return null
- Worst case, visit all nodes to find p q at last level, last two leaves: time O(n), stack space O(n)



---

**61. [301. Remove Invalid Parentheses.java](https://github.com/awangdev/LintCode/blob/master/Java/301.%20Remove%20Invalid%20Parentheses.java)**      Level: Hard      Tags: [BFS, DFS, DP]
      
给一个string, 里面有括号和其他字符. 以最少刀 剪出 valid string, 求所有这样的string.

这个题目有多种解法, 最强就是O(n) space and time

#### DFS and reduce input string
- Goal: identify invalid parentheses and remove (minimum removals)
- Step:
    - Detect the incorrect parentheses by tracking/counting (similar to validation of the parentheses string): `if(count<0)`
    - When invalid occurs: 
        - chance for correction. Remove the incorrect parentheses, one at a time
        - dfs on the rest of the s that has not been tested yet: start index from index i
    - Core edge cases:
        - Do not correct twice of the same parenthesis by checking [j-1] pos
        - Make sure to attempt correction of all possible parenthesis within tested range: because it outputs all results at the same level
        - return/finish once correction done
- Success case: 
    - a string s passed test: make sure it passes REVERSED string test!
    - Core Concept: `if a parenthese string is valid, the reverse of it should also be valid`
    - Test s with open='(', close=')' first; **reverse s**, and test it with open=')', close='('
- Minor details
    - only procceed to remove invalid parenthese when `count<0`, and also break && return dfs after the recursive calls.
    - The above 2 facts eliminates all the redundant results.
    - **Reverse string** before alternating open and close parentheses, so when **returning final result, it will return the correct order**.
- How does it guarantee minimum removals?
    - When seeing a chance to correct, it jumps into a for loop of DFS. It `return` after the for loop. This stops additional testing
    - When invalid occurs, correct it right away: minimum correction
- Complexity:
    - O(nk), k being the # of recursive calls. It takes n calls to finish a full string case.

#### BFS
- Similar to DFS, we wnat to test: 1) test input s valid, 2) remove 1 invalid parenthesis at a time, 3) process substring
- instead of testing all substrings (timeout), we want to establish rules to improve reprocess:
    - Test1: skip regular char. No need to test it.
    - Test2: if redundant paren, do 1 is enough. skip adjacent ones.
    - Test3: if last removed extra paren is '(', the next ')' must be a valid pair. LastRemoved char: pecial handling by using a struct: `class Node {String s, int index, char lastRemoved}`
- How to end tests? When there is data in rst, stop adding to queue.



---

**62. [111. Minimum Depth of Binary Tree.java](https://github.com/awangdev/LintCode/blob/master/Java/111.%20Minimum%20Depth%20of%20Binary%20Tree.java)**      Level: Easy      Tags: [BFS, DFS, Tree]
      

#### BFS
- Shortest path; minimum depth: 想到BFS, check level by level, BFS更能确保更快找到结果
- depth definition: reach to a leaf node, where node.left == null && node.right == null
- BFS using queue, track level.

#### DFS
- Divide and Conquer to find min depth. 
    - if one of child is null, return the other child depth + 1
    - Pick the min of the two child depth + 1
- need to visit all nodes




---

**63. [1216. Valid Palindrome III.java](https://github.com/awangdev/LintCode/blob/master/Java/1216.%20Valid%20Palindrome%20III.java)**      Level: Hard      Tags: [DFS, DP, Memoization, String]
      

#### Method1: DP, utilize `Longest Palindrome Subsequence`
- Transform the problem:
    - `removing at most k items to make it a palindrome`
    - that is: find the longest palindrome subsequence with length x, such that `n - x <= k`
- `516. Longest Palindromic Subsequence` utilizes Interval DP to find LPS length x
- at the end, perform n - x <= k?
- time: O(n^2) to find LPS
- space: O(n^2) for dp

#### Method2: DFS with Memo
- Either times out or too much space used
- time: O(n^2)
- space: O(n^2) or O(k*n^2)



---

**64. [207. Course Schedule.java](https://github.com/awangdev/LintCode/blob/master/Java/207.%20Course%20Schedule.java)**      Level: Medium      Tags: [BFS, Backtracking, DFS, Graph, Topological Sort]
      

- 一堆课用int[2] pair 来表示. [1, 0] 表示要上课1的话, 必须先把课0上了. 
- 每一个数字都是一个ndoe, 题目问是否能把所有的课排了
- input是 numOfCourses, 还有这个prerequisites [[]]
- Concept of Indegree: `# of incoming node that depends on me`. It is a graph of `arrows pointing inward to me` structure.

##### Indegree 原理
- Remember: **indegree是周围的node到我这里的次数count**.
    - Note: 如果有cycle, 这个node上面会多一些inDegree, 也就无法清0, 它也无法进入 queue && sorted list. 
    - 如果周围所有node的连线, 都意义切除后, 我的indegree还不等于0, 那么肯定有某些node间接地有重复连线, 也就是有cycle
- Topological problem: almost always care about cycle case (if detecting cycle is not goal)

#### BFS, Topological Sort
- Two structures:
    - 1) build inDegreeEdges: `List[] inDegreeEdges`: list of incoming nodes that depends on `node i`, 
    - 2) build dependencyCount: `int[] dependencyCount`, count # of braches that curr node depends on
- any dependencyCount[node]==0, means this node is now a leaf, add to queue
- Topological Sort Process, Kahn algorithem:
- topologically process: 
    1) add leaf node to queue, get ready to process; 
    2) process leafNode, like cutting of leaf
    3) if any child node dependencyCount == 0, it is a leaf node now: add this node to queue.

#### DFS
- this problem aims for deteching cycle, not output final list. Simply: visit all nodes and verify cycle
- Option1: array of indegree lists, List[]
    - 用 visited int[] 来确认是否有cycle. 1 means `visited`, -1 means `visted from last dfs level`
        - Deteching `-1`: 说明这个node在上一级或者以上的同一个dfs path里面已经走过, 那么证明有cycle, return false.
        - dfs on curr node indegree dependencies; if all passes w/o failing, set visited[i] = 1
    - Similarly, can use `HashMap<Integer, List<Integer>> map` to replace List[], but exact same idea.
- Optoin2: use a struct `class Node {Boolean visiting; Map<Integer, Node> inDegreeMap}` to be more generic
- topo sort may output the sort order: 1) at DFS bottom level, put record to a `stack`, 2) rst.insert(0, curr record)

#### Notes
- 还有 List[] arrayOfList = new ArrayList[]; 这样的操作啊, 代替了map<integer, integerList>. Though: map may be more flexible
- 是topological sort的题目。一般都是给有dependency的东西排序。    
    - 最终都会到一个sink/leaf node，no further dependency, 在那个点截止
- 画个图的话, prerequisite都是指向那个sink/leaf node
- when building the inDegreeMap/inDegreeEdge: we use sink/leaf node as key/index, which pionts back to inDegree/parent nodes
- BFS: when all braches/dependency count are reduced to 0, then it is now a leaf node, ready to be used.
- DFS Insert Order: rst.insert(0, node); Assume we want leaf/node at index 0 in final output:
    - the very bottom-node **depends on everybody**
    - any visited node should be added to 0 index of the list, so it will be at tail later



---

**65. [987. Vertical Order Traversal of a Binary Tree.java](https://github.com/awangdev/LintCode/blob/master/Java/987.%20Vertical%20Order%20Traversal%20of%20a%20Binary%20Tree.java)**      Level: Medium      Tags: [BFS, Binary Tree, DFS, Hash Table, Tree]
      
space: O(n)

Very similar to `314. Binary Tree Vertical Order Traversal` with 1 special condition: if 2 nodes at same (offset, level):
sort it by its value 

#### Method1: DFS
- the special requirement causes: we have to track exact position of nodes
- Using `Node {int offset, level, val}` and `Map<offset, Map<level, List<Val>>>`:
    - set all nodes to its correct position
    - output all together
- the `max/min` offset allows us to loop over the map in a ordered manner (save efforts of sorting)
- time: O(n) to mark all nodes at correct spot, but `O(nlogn)` to sort the vertical array
- space: O(n), mark all nodes in the nested map

#### Method2: BFS + Hash table
- A (offset, level) has 2 nodes: use nested `Map<offset, Map<level, List<Val>>>` to track nodes
- Also need a `class Node{int offset; TreeNode node}` to build queue: 
    - need `offset`: queue at each level cannot derive level index
    - need `TreeNode`: `Node` extends original `TreeNode` so we can queue it.
- lots code to write due to the `class Node` for BFS



---

**66. [694. Number of Distinct Islands.java](https://github.com/awangdev/LintCode/blob/master/Java/694.%20Number%20of%20Distinct%20Islands.java)**      Level: Medium      Tags: [DFS, Hash Table]
      

#### DFS + HashSet
- DFS can find # of island, just like `200.Number of Islands`, aim to count total
- We need to map same-shap land
    - One approach: print the **footprint** starting from coordinate (0, 0)
    - Another approach: print the actual island in its boundary, like a QR code. (too hard to code, skip)
- Footprint approach: 
    - 1. always assume a newly found islands starts from (0, 0)
    - 2. take 4 direction from init pos and keep printing the footprint
    - 3. Since we always visit nodes from top->right->nextrow, we always visit top-left cornor of a new island, and the footprint will be identical
        - Otherwises, if needed, we can sort the footprint and output the hash
- time: O(n), visit all
- space: O(n), store footprint, and dfs stacks worst case visit all nodes 



---

**67. [53. Maximum Subarray.java](https://github.com/awangdev/LintCode/blob/master/Java/53.%20Maximum%20Subarray.java)**      Level: Easy      Tags: [Array, DFS, DP, Divide and Conquer, PreSum, Sequence DP, Subarray]
      

给一串数组, unsorted, can have negative/positive num. 找数组中间 subarray 数字之和的最大值

#### PreSum
- 想着用一用prefix sum. 把值一个个叠加
- 然后presum[j] - presum[i- 1] 就是 (i,j)之间的和
- O(n^2), not as sufficient


#### Sequence DP
- dp[i]: last element(或包括前i个element), 可能组成的 subarray 的最大sum.
    - dp[i] = Math.max(dp[i-1]+lastElement, lastElement(drop dp[i-1]))
- init: 
    - dp = int[n + 1], 
    - dp[0]: first 0 items, does not have any sum
- 因为continous sequence, 所以不满足条件的时候, 会断. 
    - need to take curr num regardless => can drop prev max in dp[i]
- track overall max 
- init dp[0] = 0; max = MIN_VALUE 因为有负数
- Time, space O(n)
- Rolling array, space O(1)

#### Divide and Conquer, DFS
- 找一个mid piont, 考虑3种情况: 1) 只要左边, 2) 只要右边, 3) cross-mid
- left/rigth case: 直接 dfs
- corss-mid case: continuous sum max from left + continous sum max from right + mid
- continuous sum max from one direction:
- Worst case O(n^2): visit all nodes O(n); in dfs: calculates continuous sum (including mid), which is also O(n)


---

**68. [199. Binary Tree Right Side View.java](https://github.com/awangdev/LintCode/blob/master/Java/199.%20Binary%20Tree%20Right%20Side%20View.java)**      Level: Medium      Tags: [BFS, DFS, Tree]
      

给一个binary tree, 从右边看过来, return all visible nodes

#### BFS
- 最右: 即level traversal每一行的最末尾.   
- BFS, queue 来存每一行的内容, save end node into list
- time: O(n) visit all nodes
- space: O(n) worst case unbalanced tree to have n nodes in final results


#### DFS
- Use Map<Level, Integer> to override the result at each level
- dfs: 
    - dfs(node.left) and then dfs(node.right) because we want to log right side last
- record global max depth for iteration purpose
- time: O(n) visit all nodes
- space: O(n) worst case unbalanced tree to have n stacks (and n nodes in final results)




---

**69. [1203. Sort Items by Groups Respecting Dependencies.java](https://github.com/awangdev/LintCode/blob/master/Java/1203.%20Sort%20Items%20by%20Groups%20Respecting%20Dependencies.java)**      Level: Hard      Tags: [BFS, DFS, Graph, Topological Sort]
      

#### Topological Sort
- Realize we need to: 1) topo sort group, 2) topo sort items in the group. 
- Luckily, the candidates to be sorted are all integers: groupIds, or item ids. We can have 1 generic topo sort function
- Overall workflow
    - 1) group items to map <GroupId, List<items>>
    - 2) build group graph
    - 3) topo sort group -> return sorted group id list
    - 4) for each group: build item graph, topo sort items -> return sorted item list
    - 5) flatten and return results



---

**70. [1008. Construct Binary Search Tree from Preorder Traversal.java](https://github.com/awangdev/LintCode/blob/master/Java/1008.%20Construct%20Binary%20Search%20Tree%20from%20Preorder%20Traversal.java)**      Level: Medium      Tags: [DFS, Tree]
      

#### Method1: Top Down DFS
- This approach highly relies on the preorder rules
    - we can use validation rules to navigate throug hteh preorder array
    - use a global index
- time:  O(n)




---

**71. [515. Find Largest Value in Each Tree Row.java](https://github.com/awangdev/LintCode/blob/master/Java/515.%20Find%20Largest%20Value%20in%20Each%20Tree%20Row.java)**      Level: Medium      Tags: [BFS, DFS, Tree]
      

#### Method1: DFS
- faster than BFS, using less space if not couting final rst: stack size, O(logn)
- time: O(n), visit all

#### Method2: BFS with queue
- loop over queue level and record max




---

**72. [1161. Maximum Level Sum of a Binary Tree.java](https://github.com/awangdev/LintCode/blob/master/Java/1161.%20Maximum%20Level%20Sum%20of%20a%20Binary%20Tree.java)**      Level: Medium      Tags: [BFS, DFS, Graph]
      


#### BFS
- simply calc each level sum with BFS
- top-level is processed first, since we go from top level -> deeper level
    - only update result if sum is truly > global MAX.



---

**73. [131. Palindrome Partitioning.java](https://github.com/awangdev/LintCode/blob/master/Java/131.%20Palindrome%20Partitioning.java)**      Level: Medium      Tags: [Backtracking, DFS]
      

给个string s, partition(分段)后, 要确保每个partition都是palindrome. 

求所有partition palindrome组合. `list<list<string>>`

#### DFS
- 可以top->bottom: 遍历str, validate substring(start, i); if valid, add as candidate, and dfs; backtrack by remove candidate.
- 也可以bottom->up: 遍历str, validate substring(start, i); if valid, dfs(remaining str), return list of suffix; cross match with curr candidate.

#### DFS Top->Bottom
- 在遍历str的时候，考虑从每个curr spot 到 str 结尾，是能有多少种palindorme?
- 那就从curr spot当个字符开始算，开始backtracking.
- 如果所选不是palindrome， 那move on.
- 若所选的确是palindrome,　加到path里面，DFS去下个level，等遍历到了结尾，这就产生了一种分割成palindrome的串。
- 每次DFS结尾，要把这一层加的所选palindrome删掉，backtracking嘛

#### Optimization
- 可以再每一个dfs level 算 isPalindrome(S), 但是可以先把 boolean[][] isPalin 算出来, 每次O(1) 来用
- 注意: isPalin[i][j] 是 inclusive的, 所以用的时候要认准坐标
- Calculate isPalin[i][j]: pick mid point [0 ~ n]
- expand and validate palindrome at these indexes: `[mid, mid+1]` or `[mid-1][mid+1]`

#### Complexity
- Overall Space O(n^2): 存 isPlain[][]
- Time O(2^n), 每一层都在做 pick/not pick index i 的选择, 所以worst case 2^n. 
- 因为我们的isPalin[][]优化了palindrome的判断O(1), 所以overall Time: O(2^n)



---

**74. [222. Count Complete Tree Nodes.java](https://github.com/awangdev/LintCode/blob/master/Java/222.%20Count%20Complete%20Tree%20Nodes.java)**      Level: Medium      Tags: [Binary Search, DFS, Tree]
      

Complete Tree就是说, 最后一个level可能是缺node的(不是说最右下角缺node, 别忘了!)

#### Method1: DFS + Optimization
- 每次看最左left depth和最右leaf depth 是不是一样
    - 如果一样, 直接 2 ^ h - 1就好
    - 不一样的话, 再DFS
- calculate `2^(h)`: 位运算, Math.pow(2, h) = 2 << (h - 1). 神奇!
    - 2 << 1就是把所有bits往左移动一位, 也就是 * 2 
- time: O(n) visit all nodes on 1 side
- space: O(h) visit all nodes on 1 side


#### Method2: Iteratively
- See details in comments inline. 要对tree非常理解
- binary tree one child tree nodes # = 2 ^ h - 1; 所以一个child tree + root = 2 ^ h

#### Method3: Binary Search
- NOT DONE, TODO: https://leetcode.com/problems/count-complete-tree-nodes/solution/



---

**75. [257. Binary Tree Paths.java](https://github.com/awangdev/LintCode/blob/master/Java/257.%20Binary%20Tree%20Paths.java)**      Level: Easy      Tags: [Backtracking, Binary Tree, DFS]
      


给一个binary tree, 返回所有root-to-leaf path

#### DFS, backtracking
- Find all paths, bfs/dfs all works. dfs will be simplier to write
- Recursive:分叉. dfs.
- top->bottom: enumerate current node into the list, carry to next level, and backtrack
- top->bottom is trivial to consider: path flows from top->bottom
- time: visit all n nodes
- space: to hold all paths, O(nlogn)
    - O((n-1)/2) = O(n) nodes at leaf
    - O(logn) depth

#### DFS, bottom->up
- We can also take current node.left or node.right to generate list of results from the subproblem
- let dfs return list of string candidates, and we can run pair the list with currenet node, once they come back.
- TODO: can write code to practice

#### Iterative
- Iterative, 非递归练习了一下
- 因为要每次切短list, 所以再加了一个Stack 来存level
- 单这道题用dfs更简单, 因为找的就是从头到尾的path, 是dfs的pattern




---

**76. [1219. Path with Maximum Gold.java](https://github.com/awangdev/LintCode/blob/master/Java/1219.%20Path%20with%20Maximum%20Gold.java)**      Level: Medium      Tags: [Backtracking, DFS]
      


### DFS, Backtracking
- typical recursive visit all situation




---

**77. [1110. Delete Nodes And Return Forest.java](https://github.com/awangdev/LintCode/blob/master/Java/1110.%20Delete%20Nodes%20And%20Return%20Forest.java)**      Level: Medium      Tags: [DFS, Divide and Conquer, Tree]
      

#### Method1: DFS, divide and conquer
- dfs function: have toDelete set, and a result list
- dive deep into child node FIRST, and test if a removal is needed at bottom of tree
- if remove, add orphan and return null; otherwise, return itself
- time: O(n), visit all nodes
- space: O(logn), height of the tree

#### Method2: HashMap, DFS.
- traverse tree and create `map <val, parent>` to fast O(1) removal. O(n)
- set root into a rootSet
- after deleting a node A, the children of the node becomes 2 forests root
    - children should be marked in rootSet
    - also remove node A from rootSet (if appears)
- output: find all root in root set, traverse and output.
- This approach requires a dfs build of parentMap
    - it is same amount of efforts to do the regular dfs removal.
    - not a good solution
- time: O(n)
- space: O(n)



---

**78. [339. Nested List Weight Sum.java](https://github.com/awangdev/LintCode/blob/master/Java/339.%20Nested%20List%20Weight%20Sum.java)**      Level: Easy      Tags: [BFS, DFS, NestedInteger]
      

给一串integers, list里面可能有nest list. 算总的sum. 规则, 如果是nested list, 每深一个depth, sum要乘以depth.

#### DFS
- New interface to understand: object contains integer or object
    - Visit all && sum, consider dfs.
    - 简单的处理nested structure, dfs增加depth.
- time: visit all nodes eventually, O(n), space O(n)

#### BFS
- bfs, queue, 处理queue.size() for a level
- use a level variable to track levels
- slower since it uses extra space, worst case O(n) of all items



---

**79. [322. Coin Change.java](https://github.com/awangdev/LintCode/blob/master/Java/322.%20Coin%20Change.java)**      Level: Medium      Tags: [Backpack DP, DFS, DP, Memoization]
      

给一串不同数额的coins, 和total amount to spent. 求 最少 用多少个coin可以组合到这个amount. 每种coins个数不限量.


#### DP, Bottom -> UP 从小到大的顺序!
- define dp[x], 积累到amount x, 最少用多少个coin
- function: `dp[x] = Math.min(dp[x], dp[x - coinValue] + 1)`. two branches based on choosing coinValue or not
- initialization
    - dp[0], zero amount uses 0 coin. so dp[0] = 0
    - Utilize `Integer.MAX_VALUE` as default val for initialize dp[x]: 1) alert error stage; 2) easy comparison

#### Method2: Memoization, DFS, Top->Down
- create subproblem: (coins, amount - pickedCoin)
- memo[i] 依然表示: min # of coints to make amount i
- initialize memo[i] = Integer.MAX_VALUE
- 先选最后一步(遍历coins),  然后dfs做同样的操作
- 记录memo[amount] 如果已经给过value, 不要重复计算, 直接return.
- time: O(n * S), worst case it runs n coins for S(amount) iterations
- space: O(S)



---

**80. [140. Word Break II.java](https://github.com/awangdev/LintCode/blob/master/Java/140.%20Word%20Break%20II.java)**      Level: Hard      Tags: [Backtracking, DFS, DP, Hash Table, Memoization]
      

找出所有 word break variations, given dictionary. (`Word Break I` only checks possibility)

利用 memoization: `Map<prefix, List<suffix variations>>`

#### DFS + Memoization, pick a prefix, and find a list of suffix candidates
- IMPORANT, Memoization: `Map<prefix, List<suffix variations>>` to build substring segments. Reduces repeated calculation if the substring has been tried.
- Realize the input s expands into a tree of possible prefixes.
- Find list of candidates from subproblem, and cross-match
- DFS returns List<String> segments of target s: every for loop takes a prefix substring, and append with all suffix (result of dfs)
- Time O(n!). Worst case, permutation of unique letters: `s= 'abcdef....'`, and `dict=[a,b,c,d,e,f...]`

#### Method2: DFS on suffix + memo of failed cases, like in WordBreakI
- DFS on string: find a valid prefix, dfs on the suffix, building individual candidate in list till substring exhaust. 
- improvement:
    - use memo to record failed case (solved the timeout issue explained below)
    - use min/max to as boundary for dict check.
- core code is short; helper code is slightly longer

#### Method3: Regular DPs, kinda too slow
- 两个DP一起用, 解决了timeout的问题: when a invalid case 'aaaaaaaaa' occurs, isValid[] stops dfs from occuring
- 1. isWord[i][j], subString(i,j)是否存在dict中？
- 2. 用isWord加快 isValid[i]: [i ～ end]是否可以从dict中找到合理的解？      
- 从末尾开始查看i：因为我们需要测试isWord[i][j]时候，j>i, 而我们观察的是[i,j]这区间；       
- j>i的部分同样需要考虑，我们还需要知道isValid[0～j+1]。 所以isValid[x]这次是表示[x, end]是否valid的DP。     
- i 从 末尾到0, 可能是因为考虑到isWord[i][j]都是在[0~n]之内，所以倒过来数，坐标比较容易搞清楚。     
- (回头看Word Break I， 也有坐标反转的做法)
- 3. dfs 利用 isValid 和isWord做普通的DFS。

#### Timeout Note
- Regarding regular solution: 如果不做memoization或者dp, 'aaaaa....aaa' will repeatedly calculate same substring
- Regarding double DP solution: 在Word Break里面用了set.contains(...), 在isValid里面，i 从0开始. 但是, contains()本身是O(n); intead,用一个isWord[i][j]，就O(1)判断了i~j是不是存在dictionary



---

**81. [741. Cherry Pickup.java](https://github.com/awangdev/LintCode/blob/master/Java/741.%20Cherry%20Pickup.java)**      Level: Hard      Tags: [DFS, DP]
      

special hint: `r1 + c1 = constant t = r2 + c2`, if the two points are moving at same time.

#### DFS + Memo: TOP-DOWN
- Similar concept to Minimum Path Sum
- https://leetcode.com/problems/cherry-pickup/solution/
- realize r1 + c1 = r2 + c2. Knowing 3 parameters can uniquely identify the 4th.
- assume there are 2 people starting from origin, and the 2 people can go total 4 directions
    - perform DFS based on the 4 directions
    - concern: do they visit the same spot? possible. when that happens, make sure we do not double count the grid[i][j]
- when is the end state? 
    - then anyone, for example, (r1,c1) reaches end (n-1, n-1).
    - it means the other person also reaches end
- use memo: memo[r1][c1][r2], it records any given (r1, c1, r2, c2) state




---

**82. [104. Maximum Depth of Binary Tree.java](https://github.com/awangdev/LintCode/blob/master/Java/104.%20Maximum%20Depth%20of%20Binary%20Tree.java)**      Level: Easy      Tags: [DFS, Tree]
      
给一个binary tree, 找最深depth

#### DFS
- 这里要走过所有的node, 所以dfs非常合适
- Divide and conquer. 
- 维持一个最大值: Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
- 注意check root == null

#### Note
- BFS is doable as well, but a bit more code to write: tracks largest level we reach



---

**83. [297. Serialize and Deserialize Binary Tree.java](https://github.com/awangdev/LintCode/blob/master/Java/297.%20Serialize%20and%20Deserialize%20Binary%20Tree.java)**      Level: Hard      Tags: [BFS, DFS, Deque, Design, Divide and Conquer, Tree]
      

Serialize and Deserialize Binary Tree

#### DFS, Divide and Conquer, Preorder
- inorder and postorder does NOT work: it is hard to find mid point, since the tree is not balanced or complete
- Serilize: Divide and conquer, Pre-order traversal to link all nodes together
    - build the string data: use '#' to represent null child. 
    - the preorder string, can be parsed apart by `split(',')`    
- Deserialize
    - Use a queue to process 1 node at a time. dfs on remaining of the queue
    - first node from the list is always the head
    - '#' will be a null child: this should break & return dfs
    - queue is shared, so dfs(right child) will happen after dfs(left child) completes
- Note:
    - Append multiple stirngs with `sb.append(x).append(y)`
    - If want to process 1 item at a time from head of the list: make it a queue and poll()

#### BFS, Non-recursive
- serialize: preorder using queue:
    - start with root
    - process curr node, then: queue.offer(leftNode),queue.offer(rightNode)
    - while(!queue.isEmpty())
- deserialize:
    - split into str[] to process
    - since serialization ensures 2 children added (including null), we assume:
        - the sequence of parent, left child, right child.
        - use queue to reproduce the preorder sequence as we process each index of str[]
    - Queue will not be empty until all index reaches end of str[], so no need to worry about queue emptiness



---

**84. [46. Permutations.java](https://github.com/awangdev/LintCode/blob/master/Java/46.%20Permutations.java)**      Level: Medium      Tags: [BFS, Backtracking, DFS, Permutation]
      

#### Method1-Option1: Recursive Backtracking, with queue to maintain the remaining list
- Best of all recursive approaches
- iterate over nums: pick or not pick
- reduce remaining item in next level:
    - option1: use queue, restrict queue size; backtrack append to queue
    - option2: remove element before passing into next level; backtrack: insert back
- time O(n!): visit all possible outcome
    - T(n) = n * T(n-1) + O(1)

Method1-Option2: Recursive Backtracking, with `list.contains()` to avoid reuse of index
- A bit worse than option1, uses more time:
    - list.contains() cost O(logn). Technically, it is O(n^n), plus the `contains` is nlogn time
    - also, each dfs, it has to iterate over entire nums list

Method1-Option3: Recursive Backtracking, with `visited[]` to avoid reuse of index
- Use visited[] to track, still causes for(over n items), not efficient

#### Method2-Option1: Iterative, Build permutation by insertion
- Best of all iterative approaches
- Each time pick 1 NEW element and find places to insert into candidate list:
    - 1. 一个一个element加进去
    - 2. 每一次把rst里面的每个list拿出来, 创建成新list, 然后选位置加上new element
    - 3. 加新元素的时候, 要在list的每个位置insert, 最终也要在原始的list末尾加上new element
- 还是O(n!), 因为rst insert O(n!)个permutations
- Better than the Option2/Option3 (`BFS+Queue`), because this solution does not need to check duplicates

#### Method2-Option2: Iterative, use Queue to hold candidate list
- 用个queue，每次poll()出来的list, 把在nums里面能加的挨个加一遍
- Time O(n!)
- Slow: checking candidate.contains() is O(logn) each time

#### Method2-Option3: Iterative, use queue to candidate list, and calculate remain list on the fly
- Almost same as Method2-Option2, but it builds remainingCandidate list on the fly list.removeall(xyz): O(n)
- Even slower than Method2-Option2



---

**85. [200. Number of Islands.java](https://github.com/awangdev/LintCode/blob/master/Java/200.%20Number%20of%20Islands.java)**      Level: Medium      Tags: [BFS, DFS, Matrix DFS, Union Find]
      

给一个2Dmatrix, 里面是1和0, 找#of island.

#### Method1, DFS
- visit all nodes connected with the starting node
    - double for loop, test all starting nodes
    - val == 1: 1) count++; 2)DFS from this (i,j);
    - Mark visited (x,y) = '0'
- time: O(n), visit all nodes
- space: O(n), stack

#### Method2, Union Find
- 可以用union-find， 就像Number of island II 一样.
    - 只不过这个不Return list, 而只是# of islands
    - Union Find is independent from the problem: it models the union status of integers.
    - Return the total # of unions (which is # of islands)
- in reality: it is a bit slow.
- time: visit all nodes just once, O(n). Union Find will visit all nodes once and union them
- space: O(n), union find takes O(n) space
- 记住UnionFind的模板和几个变化(Connecting Graph I, II, III), 最后归总的代码写起来就比较简单. 

#### Method3: BFS
- use queue to hold 1 island, keep adding 4-direction islands; mark visited with '0' 
- check entire board for any remaining one.



---

**86. [47. Permutations II.java](https://github.com/awangdev/LintCode/blob/master/Java/47.%20Permutations%20II.java)**      Level: Medium      Tags: [Backtracking, DFS]
      
space: O(n!)

给一串数组, 找出所有permutation数组. 注意: 给出的nums里面有重复数字, 而permutation的结果需要无重复.

Similar to 46. Permutations, but with dedup

#### Backtracking
- Sort the list, and on same level, if last element is the same as curr, skip this recursive call
- time O(n!)

#### Non-recursive, manuall swap
- Idea from: https://www.sigmainfy.com/blog/leetcode-permutations-i-and-ii.html
- 用到 sublist sort
- 用 swap function, 在原数组上调节出来新的permutation
- 注意: 每次拿到新的candidate, 都要把没有permutate的数位sort, 然后再开始swap.
- 这是为了确保, [j]和[j-1]在重复时候, 不用重新记录.



---

**87. [332. Reconstruct Itinerary.java](https://github.com/awangdev/LintCode/blob/master/Java/332.%20Reconstruct%20Itinerary.java)**      Level: Medium      Tags: [Backtracking, DFS, Graph]
      

#### DFS with backtcking
- Construct graph: `map<String, List<Destination>>`; sort the list of destinations.
- DFS:
    - with any curr city, go over the destination list: `graph.get(curr)`
    - add visit city to rst
    - remove visited city from the desitnation list
    - backtrack
- NOTE: 
    - 1) the graph allows cycle: revisiting same city. Do NOT assume no cycle
    - 2) it asks to us to treat `smaller lexical order city` with priority; however:
        - it does NOT mean visiting `smaller lexical order city` is THE correc anser
        - it can be a leaf sink node of the graph and does not provide correct trip plan
- time: O(n^n). n = # of cities. worst case, each city has (n-1) edges and need to try all combinations
- space: O(n^2), there can at most be n * (n - 1) edges



---

**88. [39. Combination Sum.java](https://github.com/awangdev/LintCode/blob/master/Java/39.%20Combination%20Sum.java)**      Level: Medium      Tags: [Array, Backtracking, Combination, DFS]
      

给一串数字candidates (no duplicates), 和一个target. 

找到所有unique的 组合(combination) int[], 要求每个combination的和 = target.

注意: 同一个candidate integer, 可以用任意多次.


#### DFS, Backtracking
- 考虑input: 没有duplicate, 不需要sort
- 考虑重复使用的规则: 可以重复使用, 那么for loop里面dfs的时候, 使用curr index i
- the result is trivial, save success list into result.
- Time and Space complexity:
    - transform the analysis as for `40. Combination Sum II`
    - Since this problem allows reuse of elemenets, assume they exist in original input as duplicates
    - time: O(k * 2^n), k = avg rst length
    - space: O(k) stack depth, if not counting result size



---

**89. [1106. Parsing A Boolean Expression.java](https://github.com/awangdev/LintCode/blob/master/Java/1106.%20Parsing%20A%20Boolean%20Expression.java)**      Level: Hard      Tags: [DFS, Stack, String]
      
#### Parse exp as sub problem
- Analyze the pattern: 1) single char, 2) with !, 3) with &, |
- Identify sub problem
    - Use stack to parse the data in "()", which is a sub problem to solve with recursive call
    - Handle &, | case: need to parse multiple
- Be comfortable with string parsing
- Slight improve: 
    - If see obvious result, directly return evaluation w/o further parsing
    - use memo to store evaluated exp

#### Evaluate inner exp and save back to Stack
- Use '(' and ')' to mark inner exp
- Evaluate the inner exp and save result back to Stack: the result will be 'f' or 't'
- This is slightly slow because:
    - It requires all stack items on top to be processed before reaching the operator
    - There is no room to optimize even there is simplification for specific operator



---

**90. [144. Binary Tree Preorder Traversal.java](https://github.com/awangdev/LintCode/blob/master/Java/144.%20Binary%20Tree%20Preorder%20Traversal.java)**      Level: Medium      Tags: [BFS, DFS, Stack, Tree]
      

#### Recursive, DFS, Divide and conquer
- 加root, left, then right. Obvious
- Option1: recursive on preorderTraversal. the dfs function returns List
- Option2: pass in rst, and write a void dfs.

#### Iterative
- 先加root, 然后push上需要末尾process的在stack垫底(root.right), 然后push root.left
- Stack: push curr, push right, push left.   



---

**91. [110. Balanced Binary Tree.java](https://github.com/awangdev/LintCode/blob/master/Java/110.%20Balanced%20Binary%20Tree.java)**      Level: Easy      Tags: [DFS, Tree]
      
给一个binary tree, 看是否是height-balanced

#### DFS with end state
- DFS using depth marker: 每个depth都存一下。然后如果有不符合条件的，存为-1.
- 一旦有 <0 或者差值大于1， 就全部返回Integer.MIN_VALUE. Integer.MIN_VALUE比较极端, 确保结果的正确性。
- 最后比较返回结果是不是<0. 是<0，那就false.
- Traverse 整个tree, O(n)


#### DFS, maxDepth function
- Same concept as above solution, but cost more traversal efforts
- 试图计算所有情况



---

**92. [100. Same Tree.java](https://github.com/awangdev/LintCode/blob/master/Java/100.%20Same%20Tree.java)**      Level: Easy      Tags: [BFS, DFS, Tree]
      

给两个 binary tree, 看两个tree是否identical.

#### Method1: DFS
- DFS. 确定leaf条件, && with all dfs(sub1, sub2).
- 这里无论如何都要走过所有的node, 所以dfs更加合适, 好写.

#### Method2: BFS with 2 queues
- 两个queue存每个tree的所有current level node. Check equality, check queue size.
- Populate next level by nodes at current level.



---

**93. [112. Path Sum.java](https://github.com/awangdev/LintCode/blob/master/Java/112.%20Path%20Sum.java)**      Level: Easy      Tags: [DFS, Tree]
      
给一个inputSum, 然后dfs, 找到是否有一条path, 得出的path sum 跟 inputSum 一样.

#### DFS
- 确定好结尾条件: `is leaf` && `val == sum`.
- 每一层减掉node.val, 然后dfs.
- 写一写: `root == null => false` 对parent nodes的影响. 这里发现没影响, 所以可以简化成用1个functionDFS.




---

**94. [1026. Maximum Difference Between Node and Ancestor.java](https://github.com/awangdev/LintCode/blob/master/Java/1026.%20Maximum%20Difference%20Between%20Node%20and%20Ancestor.java)**      Level: Medium      Tags: [DFS, Tree]
      

#### Method1: Top-Down DFS
- cache parent max and min => produce current max and min
- pass the max and min to dfs
- compare and return the max of dfs(left), dfs(right)
- time: O(n)
- space: O(logn)
- easy to write, a bit hard to think of 

#### Method2: Bottom-up DFS
- pass up the local (min, max) as object `Val{max, min}`
- easy to think of, but more code to write



---

**95. [78. Subsets.java](https://github.com/awangdev/LintCode/blob/master/Java/78.%20Subsets.java)**      Level: Medium      Tags: [Array, BFS, Backtracking, Bit Manipulation, DFS]
      

给一串unique integers, 找到所有可能的subset. result里面不能有重复.

#### DFS
- dfs的两种路子: 1. pick&&skip dfs, 2. for loop dfs
- 1. pick&&skip dfs: 取或者不取 + backtracking. 当level/index到底，return 一个list. Bottom-up, reach底部, 才生产第一个solution.
- 2. for loop dfs: for loop + backtracking. 记得：做subset的时候, 每个dfs recursive call是一种独特可能，先加进rst.  top-bottom: 有一个solution, 就先加上.
- Time&&space: subset means independent choice of either pick&&not pick. You pick n times: `O(2^n)`, 3ms
- space: O(2^n) results

#### Bit Manipulation
- n = nums.length, 那么在每一个index, 都是 pick / not pick: 0/1
- 考虑subset index 0/1的bit map: range 的就是 [0000...00 ~ 2^n-1]
- 每一个bitmap就能展现出一个subset的内容: all the 1 represents picked indexes
- 做法:
- 1. 找出Range
- 2. 遍历每一个bitmap candidate
- 3. 对每一个integer 的 bit representation 遍历, 如果是1, add to list
- time: O(2^n * 2^n) = O(4^n), still 3ms, fast.

#### Iterative, BFS
- BFS, 注意考虑如果让one level to generate next level
    - 1. maintain a list of Indexe to store candidate indexes.
    - 2. 每一次打开一层candiates, add them all to result
    - 3. 并且用每一轮的candidates, populate next level, back into queue.
- should be same O(2^n), but actual run time 7ms, slower
- O(n) space



---

**96. [210. Course Schedule II.java](https://github.com/awangdev/LintCode/blob/master/Java/210.%20Course%20Schedule%20II.java)**      Level: Medium      Tags: [BFS, DFS, Graph, Topological Sort]
      

- `207. Course Schedule` has more notes
- 一堆课用int[2] pair 来表示. [1, 0] 表示要上课1的话, 必须先把课0上了. 
- 每一个数字都是一个ndoe, 题目求这个最后排好的课的list
- 如果排不好, 就给个空就好
- input是 numOfCourses, 还有这个prerequisites [[]]


#### Topological Sort, Indegree, BFS
- 用`List[] edges; edges[i] = new ArrayList<>();` 来表示graph: 就是每个node, to all its neighbors
- 每个没有 inDegree==0 node, 都是可以加进 final list里面的. 比如一开始找到的那些 inDegree = 0的 node
- 注意, 如果 prerequisites = [], 那么就是说这些课都independent, 开个int[0 ~ n-1]的数组并赋值就好.
- 如果有cycle, 严格意义上就做不了topological sort, 也无法涵盖所有nodes,  那么return [ ]

#### DFS
- 根据 Course Schedule 里面的DFS 修改
- 维持visited int[]全局变量
- 维持sortedList int[] 全局变量, 注意加进去的时候是 add(0, node) 加在开头这样
- 每次到一个node的children全部DFS走完之后, 就可以把他加进final list里面
- 如果有cycle, 也就是dfs return false的时候, 这个题目判定排课失败, return new int[] { }



---

**97. [314. Binary Tree Vertical Order Traversal.java](https://github.com/awangdev/LintCode/blob/master/Java/314.%20Binary%20Tree%20Vertical%20Order%20Traversal.java)**      Level: Medium      Tags: [BFS, DFS, Hash Table, Tree]
      

给一个Binary Tree, traverse所有node, 按照vertial order 排列成output: List<List> 

重点是: col里面有排序, lower level的排在前面; 如果node遇到collision在同一个位置: 根据他们的相对位置 先放left, 再放right

#### BFS
- 1) level-traverse all nodes, 2) add node to appropriate col list(using map)
- For final output: 
    - Use min/max to track map keys, since the keys are continous
    - Map does not provide random access; unless map key is marked with sequence i = [min, max]
- Since each vertical list is appended level by level: no need to sort during output. FAST
- time: O(n), visit all nodes
- spac: O(n) to store

#### DFS
- Regular DFS to traverse all nodes, and add node to appropriate col list (using map)
- Problem: DFS does not provide natural ordering for nodes on a row.
    - Left side may have a super deep Right child branch, which will be added to col list first (since left side is visisted first)
    - It is wrong because right branch may have nodes in same column but at higher level
    - To Solve: preserve `level` for all nodes in same column
- Need to sort the final list, and slow: visit all nodes O(n) + O(KMlogM), K = # of cols, M = # of items in col
- Time: O(nLogN). O(n) + O(KMlogM), K = # of cols, M = # of items in col; in extrem, it can be a vertical line of nodes, then sort: O(nLogN)
- Space: O(n)




---

**98. [261. Graph Valid Tree.java](https://github.com/awangdev/LintCode/blob/master/Java/261.%20Graph%20Valid%20Tree.java)**      Level: Medium      Tags: [BFS, DFS, Graph, Union Find]
      
给一个数字n代表n nodes, marked from 1 ~ n, 和一串undirected edge int[][]. 

检查这些edge是否能合成一个 valid tree

#### Method1: Union Find
- 复习Union-Find的另外一个种形式, track union size: tree does not have cycle, so eventually union size should == 1
    - 1. 查找2个元素是不是在一个union里面。如果不在，false. 如果在，那就合并成一个set, 共享parent.   
    - 2. 验证cycle: `find(x) == find(y) => cycle`
        - ideally, this edges[i] should be the very first time x and y node connect;
        - however, if they have been grouped together under same ancestor before, there exist a feedback loop (cycle) between them.
- `father[x]`: element x (index x) stores its root ancestor
- 注意: 结尾要检查, 是否只剩下1个union: Tree必须连接到所有给出的node.
- 另一个union-find, 用hashmap的:
- http://www.lintcode.com/en/problem/find-the-weak-connected-component-in-the-directed-graph/
- Deep Dive into UnionFind: https://www.cs.princeton.edu/~rs/AlgsDS07/01UnionFind.pdf

#### Method2: Build Graph in adjacency list format: `Map<Integer, Set<Integer>>` and DFS
- Very similar to `Redundant Connection`
- Create adjacency list graph: Map<Integer, List<Integer>>
- 检查: 
- 1. 是否有cycle using dfs, check boolean[] visited
- 2. 是否所有的node全部链接起来: validate if all edge connected: # of visited node should match graph size
- IMPORTANT: use `pre` node to avoid linking backward/infinite loop such as (1)->(2), and (2)->(1)

#### Method3: BFS on adjacency list graph
- traverse through adjacency list graph: `Map<Integer, List<Integer>>` 
- 1. validate cycle with set: if revisit same node
    - avoid infinite loop: remove backward mapping from child node to parent node
- 2. validate check set size for connected



---

**99. [114. Flatten Binary Tree to Linked List.java](https://github.com/awangdev/LintCode/blob/master/Java/114.%20Flatten%20Binary%20Tree%20to%20Linked%20List.java)**      Level: Medium      Tags: [Binary Tree, DFS]
      

给一个binary tree, 把tree做成 linked list的形式, in-place.

#### Method1: DFS return tail node
- DFS to return the tail of the flattened list
- Careful handling the null child. Choose one and both works:
    - Option1: put non-null as right child and continue dfs
    - Option2: put non-null as left child and continue dfs

#### Method2: void DFS
- latten the tree, no extra space.
    - 1. Set right node in buffer, and connect: `root.right = root.left`, DFS flatten(root.right) 
    - 3. 移花接木: traverse to tail of the current root.right and attach the buffer node.
    - 3. flatten the remaining of buffer

##### 注意
- 顺序一定要清楚, 不能写错, 写几个example可以看出来
- 移动的那些node, 要把node.left = null, 清扫干净



---

**100. [516. Longest Palindromic Subsequence.java](https://github.com/awangdev/LintCode/blob/master/Java/516.%20Longest%20Palindromic%20Subsequence.java)**      Level: Medium      Tags: [DFS, DP, Interval DP, Memoization]
      

给一个string s, 找最长的sub-sequence which is also palindrome.

注意！subsequence并不是substring, 是可以skip letter / non-continuous character sequence
    
#### Interval DP
- Use example to understand: for any given ending char, 3 cases of palindromes
    - a. ss[i, j] is a palindrome. dp[i+1][j-1] + 2 since the two indexes are counted, assume dp[i + 1][j - 1] is calculated
    - b. ss[i + 1, j] is a palindrome
    - c. ss[i, j - 1] is a palindrome
- time/space: O(n^2)
- **Option1: start processing substring from tail**
    - set: `i = [n-1 towards 0]`, `j = i + 1`
    - consider ss[i, j], ss[i + 1, j], ss[i, j - 1]
    - since i starts from n - 1 -> 0 and j = i + 1, these are calculated and ready to go: dp[i+1][j-1], dp[i+1][j] and dp[i][j-1]  
    - FAST: skipped the initialization
- **Option2: start processing substring from head**
    - 用[i][j]表示区间的首尾: 考虑3个情况: 砍头, 砍尾, 砍头并砍尾 (考虑首尾关系)
    - Iteration on len:
    - len = j - i + 1; 那么反推, 如果len已知, `j = len + i - 1`;
    - 注意考虑len == 1, len == 2是的特殊情况.


#### Memoization
#### DFS + Memoization
- consider sub problems with 3 major cases
    - a. ss[i, j] is a palindrome: dfs check ss[i + 1, j - 1]
    - b. ss[i + 1, j] maybe a palindrome: dfs check ss[i + 1, j]
    - c. ss[i, j - 1] maybe a palindrome: dfs check ss[i, j - 1]
- memo[i][j]: max palindrome length in range [i, j], if calculated, return directly
- Init memo[i][j] = -1 to track the progress, memoization
    - 注意: init dp[i][j]=-1, dfs的时候查dp[i][j] 是否算过
    - more about dfs: bottom-up, first dive deep into dfs(i+1,j-1) till the base cases.
- Space: O(n^2)
- Time: O(n^2)
- prepare dp[n][n]: O(n^2); dfs: visit all combinations of [i,j]: O(n^2)





---

**101. [430. Flatten a Multilevel Doubly Linked List.java](https://github.com/awangdev/LintCode/blob/master/Java/430.%20Flatten%20a%20Multilevel%20Doubly%20Linked%20List.java)**      Level: Medium      Tags: [DFS, Linked List]
      

#### DFS
- Depth-first:
    - 1) process curr.child, return tailChild
    - 2) connect tailChild.next = curr.next
- function: link(Node a, Node b);



---

**102. [105. Construct Binary Tree from Preorder and Inorder Traversal.java](https://github.com/awangdev/LintCode/blob/master/Java/105.%20Construct%20Binary%20Tree%20from%20Preorder%20and%20Inorder%20Traversal.java)**      Level: Medium      Tags: [Array, DFS, Divide and Conquer, Hash Table, Tree]
      

如题

#### DFS ApproachA:
- use preorder to find root, one index at a time (global index)
- use the root to divide and conquer inorder int[] to 2 sides;
    - root.left = dfs(left); root.right = dfs(right)
    - end stage: start == end index, create a node
- can use a map to store inorder <val, index> for O(1) find

#### DFS
- 和Construct from Inorder && Postorder 想法一样。
- 写出Preorder和Inorder的字母例子，发现Preorder的开头总是这Level的root。依此写helper,注意处理index。
- 跟Convert Sorted Array to Binary Tree类似, 找到对应的index, 然后:
    - node.left = dfs(...), node.right = dfs(...)
- Divide and Conquer
    - optimize on finding `mid node`: given value, find mid of inorder:
- Instead of searching linearly, just store inorder sequence in `map <value -> index>`, O(1)
- IMPORATANT: the mid from inorder sequence will become the main baseline to tell range: 
- `range of subTree = (mid - inStart)`
- sapce: O(n), time: O(n) access



---

**103. [40. Combination Sum II.java](https://github.com/awangdev/LintCode/blob/master/Java/40.%20Combination%20Sum%20II.java)**      Level: Medium      Tags: [Array, Backtracking, Combination, DFS]
      

给一串数字candidates (can have duplicates), 和一个target. 

找到所有unique的 组合(combination) int[], 要求每个combination的和 = target.

注意: 同一个candidate integer, 只可以用一次.

#### DFS, Backtracking
- when the input has duplicates, and want to skip redundant items? 考虑重复使用的规则: 不可以重复使用
    - 1. sort.  考虑input: 有duplicate, 必须sort
    - 2. in for loop, skip same neighbor: `if (i > index && candidates[i] == candidates[i - 1]) continue;`
        - 因为在同一个level里面重复的数字在下一个dfs level里面是会被考虑到的, 这里必须skip
- the result is trivial, save success list into result.
- Time complexity: O(k * 2^n), k = average result length
    - 1) Assume on average, there are k elements in result 
    - 2) Since element can be used ONLY once, so the total # of solutions can be `C(n, k)`: `pick k out of n`
    - 3) Now let k be any number [0, n], so total # of solutions can be: `C(n,0) + C(n,1) + C(n,2) + ... C(n,n) = 2^n`
    - 4) Now: `the new ArrayList<>(list)` takes average O(k) time
    - Total: O(k * 2^n)
- Space: O(n), stack depth, if not counting results size



---

**104. [364. Nested List Weight Sum II.java](https://github.com/awangdev/LintCode/blob/master/Java/364.%20Nested%20List%20Weight%20Sum%20II.java)**      Level: Medium      Tags: [DFS, NestedInteger]
      

#### Method1: DFS
- Build a list of NestedInt
- DFS:
  - sum up integers in the list are integers
  - dfs on nested list
  - overallSum = sum * (depth+1)
  - End state: if no nested list (no more child dfs), return depth 1
- Parent level: sum up all ints and times the (depth+1)


#### Method2: BFS
- Using stack to flatten all nestedList, and process in the end
- Can actually use list, does not need to be stack.
- uses more memory



---

**105. [1043. Partition Array for Maximum Sum.java](https://github.com/awangdev/LintCode/blob/master/Java/1043.%20Partition%20Array%20for%20Maximum%20Sum.java)**      Level: Medium      Tags: [DFS, DP, Graph, Memoization]
      

#### Top-Down DFS + Memoization
- Pick a subset (max-size k), and produce sub problem to solve by dfs
- NOTE: no need to change actual index value. That makes this problem easier (no need to record the choice path)
- time: O(n), calc memo[n]
- space: O(n), memo + stack depth



---

**106. [133. Clone Graph.java](https://github.com/awangdev/LintCode/blob/master/Java/133.%20Clone%20Graph.java)**      Level: Medium      Tags: [BFS, DFS, Graph]
      

给一个graph node, 每个node有list of neighbors. 复制整个graph, return new head node.
       
实现起来就好像在crawl urls.

#### 思想
- Use HashMap to mark cloned nodes: `map<oldNode, newNode>`
    - 1) make new curr node; 
    - 2) clone all neibhors and add them
- Use the map to avoid visited nodes
- time: O(n). visit all nodes
- space: O(n). Technically only travels n levels/stacks to circle all nodes (undirected & connected)

#### DFS
- Given graph node obj `{val, list of neighbor}`: copy the node and all neighbors
- Mark visited using map<oldNode, newNode>
- for loop on the each one of the neighbors: map copy, record in map, and further dfs
- once dfs completes, add newNeighbor as neighbor of the new node (get to it via map)
- 主要思想是: 一旦复制过了, 不必要重新复制

#### BFS
- Copy the root node, then copy all the neighbors. 
- Mark copied node in map.
- Use queue to contain the newly added neighbors. Need to work on them in the future.



---

**107. [743. Network Delay Time.java](https://github.com/awangdev/LintCode/blob/master/Java/743.%20Network%20Delay%20Time.java)**      Level: Medium      Tags: [BFS, DFS, Graph, Heap, PQ]
      

quesiton: sorting by travel delay/time will find better answer earlier?

#### Method1: BFS with PQ on graph
- `Dijkstras algorithm` is based on repeatedly making the candidate move that has the least distance travelled.
- PQ: pick close node to vist, and add siblings back to PQ
- avoid visited
- time: O(nLogn), visit n nodes, each time insert to heap takes O(logn) time
- space: O(n)

#### Method2: DFS with Sort
- 1) build graph map, 2) traverse map, 3) prioritize short delay nodes first
- use a map`<node, timeElapsed>` globally track dealy to nodes; compare all at the end



---

**108. [426. Convert Binary Search Tree to Sorted Doubly Linked List.java](https://github.com/awangdev/LintCode/blob/master/Java/426.%20Convert%20Binary%20Search%20Tree%20to%20Sorted%20Doubly%20Linked%20List.java)**      Level: Medium      Tags: [BST, DFS, Divide and Conquer, Linked List, Tree]
      

把 BST 转换成一个 sorted doubly linked list. (in-place)

#### Tree, In-order traversal, Divide and Conquer
- Regular convert BST to sored list: in-order traversal
    - Carefully doubly link node head, tail
    - traverse all nodes,  DFS 好做: `left, curr, right`
- Tail:
    - Assume head is found for sub tree, then `tail = head.left`
    - Link `LeftTail <-> Curr Root <-> RightHead`
    - Link `RightTail <-> LeftHead`
- In place:
    - 同 `Node {val, left, right}`, w/o new doubley linked list class
    - different from `Convert Binary Search Tree to Sorted Doubly Linked List (extra space)`



---

**109. [98. Validate Binary Search Tree.java](https://github.com/awangdev/LintCode/blob/master/Java/98.%20Validate%20Binary%20Search%20Tree.java)**      Level: Medium      Tags: [BST, DFS, Divide and Conquer, Tree]
      

验证是否是BST by definition

#### DFS
- 查看每个parent-child关系: 
    - leftchild < root < rightChild
    - all of left child < curr < all of right child
- 方法: 把root.val 传下来作为 max 或者 min, valid child in (min, max)
- BST 有两个极端: left-most-leaf is the smallest element, and right-most-leaf is largest
    - imagine we know the two extreme border: Long.MIN_VALUE, Long.MAX_VALUE
- min/max: long type to meet edge case: node.val = Integer.MAX_VALUE



---

**110. [1123. Lowest Common Ancestor of Deepest Leaves.java](https://github.com/awangdev/LintCode/blob/master/Java/1123.%20Lowest%20Common%20Ancestor%20of%20Deepest%20Leaves.java)**      Level: Medium      Tags: [BFS, DFS, Tree]
      

#### Method1: DFS, top-down
- key concetpL the `common ancester of deppest leaves` must have its `two branch being same depth`. problem sovled.
- dfs on both branch
- if returned depth equals & equal to max depth, record common ancestor
- time: O(n) traversal 1 pass
- space: O(n) dfs worst case depth

#### Method2: bottom-up, find leaves first and traverse backwards
- 1) find leaf nodes, and store backward map to root (DFS/ BFS both work)
- 2) use leaf nodes to find way backwards till common node is found; return
- time: O(n) but two passes
- space: O(n) dsf + map storage
- this approach is more brutle and uses exrtra spaces



---

**111. [399. Evaluate Division.java](https://github.com/awangdev/LintCode/blob/master/Java/399.%20Evaluate%20Division.java)**      Level: Medium      Tags: [BFS, DFS, Graph, Union Find]
      
#### DFS
- build map of `x#y -> val` to store values[i] and 1/values[i]
- build map of `x -> list children`
- dfs to traverse the graph

#### BFS
- BFS should also work: build graph and valueMap
- for each starting item, add all next candidate to queue
- mark visited, loop until end item is found



---

**112. [785. Is Graph Bipartite.java](https://github.com/awangdev/LintCode/blob/master/Java/785.%20Is%20Graph%20Bipartite.java)**      Level: Medium      Tags: [BFS, DFS, Garph]
      

#### DFS marking each node with a state
- `bipartite` require each node to be in exact 1 party, which means it only has 1 state
- DFS to mark node with one state; and mark its edges as reversed state
  - If any node state has been assigned by different from desired one, return false.

#### BFS, Queue
- Use `Boolean states[i]` to represent visted & state
- Try all nodes with for loop, and skip visited nodes (similar validation rules as in dfs)
- In `int next : graph[curr]`, test next level first before adding.



---

**113. [124. Binary Tree Maximum Path Sum.java](https://github.com/awangdev/LintCode/blob/master/Java/124.%20Binary%20Tree%20Maximum%20Path%20Sum.java)**      Level: Hard      Tags: [DFS, DP, Tree, Tree DP]
      

找max path sum,  可以从任意treeNode 到任意 treeNode.

#### DFS
- IMPORTANT: DO NOT ASSUME positive integers
- Overall idea: write example and realize 2 cases at each node:
    - 1. `combo sum`: left + right + root
    - 2. `single path sum WITH curr node`: left/right + root
- DFS returns the path over curr node: a path needs to be continuous, so we cannot skip curr node.
- IMPORTANT, key discovery: if left/right single path over curr node is less than 0: reutrn 0. 
    - Parent path will simply drop this path, since we want **maximize** the path sum.
    - It is so IMPORTANT: when left or right becomes 0, when comparing with global combo path:
        - it automatically covers a special case: `single left/right path + node`, since one of left/right == 0!!!
- With the above understanding: what if I want to skip curr node and just want left/right path w/o curr node:
    - it is handled and compared with global in dfs(node.left) or dfs(node.right) automatically!
- time: O(n), go over whole tree
- space: O(logn), tree height.

#### DP的思想
- tree给我们2条branch, 每条branch就类似于 dp[i - 1], 这里类似于dp[left], dp[right] 这样
- 找到 dp[left], dp[right] 以后, 跟 curr node结合. 
- 因为是找max sum, 并且可以skip nodes, 所以需要全局变量max
- 每次dfs() return的一定是可以继续 `continuously link 的 path`, 所以return `one single path sum + curr value`.

#### DFS, PathSum object
- 用 PathSum 比较特别. 没有 data structure的时候, 写起来比较繁琐.
- 第一次做有点难理解，复杂原因是：因为可能有负值啊。不能乱assume正数。   
- single path max 的计算是为了给后面的comboMax用的。
- 如果single path max小于0，那没有什么加到parent上面的意义，所以就被再次刷为0.
- combo的三种情况：(root可能小于0)   
- 1. 只有left    
- 2. 只有right
- 3. root大于0，那么就left,right,curr全部加起来。
- 情况1和情况2取一个最大值，然后和情况三比较。做了两个Math.max(). 然后就有了这一层的comboMax



---

**114. [721. Accounts Merge.java](https://github.com/awangdev/LintCode/blob/master/Java/721.%20Accounts%20Merge.java)**      Level: Medium      Tags: [DFS, Hash Table, Union Find]
      
- time O(mn)

给一串account in format `[[name, email1, email2, email3], [name2, email,..]]`. 

要求把所有account merge起来 (可能多个record记录了同一个人, by common email)


#### Method1: Union Find
- 构建 `Map<email, email parent>`, 然后再反向整合: parent -> list of email
- init with <email, email> for all emails
- 因为不同account可能串email, 那么把所有email union的时候, 不同account 的email也会被串起来
- 最终: 所有的email都被union起来, 指向一个各自union的 parent email
- UnionFind 的 parent map 可以反向输出所有  child under parent.
- 同时要维护一个 <email -> account name> 的map, 最终用来输出.

#### Method2: Hash Table solution, passed but very slow
- Definitely need iterate over accounts: merge them by email.
- Account object {name, list of email}
- map<email, account>
- 1. iterate over accounts
- 2. find if 'account' exist;  if does, add emails
- 3. if not, add account to list and to map. map all emails to accounts.
- output -> all accounts, and sort emails
- space O(mn): m row, n = emails
- time O(mn)

### DFS
- TODO



---

**115. [101. Symmetric Tree.java](https://github.com/awangdev/LintCode/blob/master/Java/101.%20Symmetric%20Tree.java)**      Level: Easy      Tags: [BFS, DFS, Tree]
      

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



---

**116. [698. Partition to K Equal Sum Subsets.java](https://github.com/awangdev/LintCode/blob/master/Java/698.%20Partition%20to%20K%20Equal%20Sum%20Subsets.java)**      Level: Medium      Tags: [DFS, DP, Recursion]
      

#### Method1: Brutle DFS to find subsets and return results
- Target = total / k, fixed.
- DFS: Pick one num and dfs with the remaining nums for subproblem
    - subproblem1: accumulate local sum to target
        - EndState: accumulatedSum == target, continue with below
    - subproblem2: after accumulatedSum == target, continue dfs with k-1
        - EndState: k == 0, return overall true
- Option1: DFS with nums, and boolean[] visited. Fast
- Option2: DFS with queue. 
  - Specially handling: dfs(size+1) to prevent `while(size-- >0)` from skipping last item at index 0


#### Method2: DP
- the problem aims to find true/false capability
- bit-masking. TODO. The DP approach is kinda hard-level
- https://leetcode.com/problems/partition-to-k-equal-sum-subsets/discuss/335668/DP-with-Bit-Masking-Solution-%3A-Best-for-Interviews



---

**117. [366. Find Leaves of Binary Tree.java](https://github.com/awangdev/LintCode/blob/master/Java/366.%20Find%20Leaves%20of%20Binary%20Tree.java)**      Level: Medium      Tags: [DFS, Tree]
      

#### DFS: store nodes at the same depth
- the leaves are at depth 0 and the root is at highest depth
- dfs: the depth = index of the rst, start from depth = 0 at leaf
- end state: leaf node, add to rst, and return depth




---

**118. [235. Lowest Common Ancestor of a Binary Search Tree.java](https://github.com/awangdev/LintCode/blob/master/Java/235.%20Lowest%20Common%20Ancestor%20of%20a%20Binary%20Search%20Tree.java)**      Level: Easy      Tags: [BST, DFS, Tree]
      

给 binary search tree root, q node, p node. 找到p q 的lowest common ancestor

#### Find path with BST
- 利用 BST 的性质，可以直接搜到target node，而做成两个长度不一定相等的 path
- 然后很简单找到LCA 
- O(n) space, O(logn) time

#### DFS
- Beofre lasts common ancestor is found: p and q should follow same search pattern:
    - compare with root, then dfs(left) or dfs(right)
    - util p and q fall on two sides of root, then return root
    - 非常巧妙, 但是也比较局限; 稍微变条件, 就很难recursive.
- 几种情况:
    - 1. one of p, q 在leaf, 那么此时的root其实就是lowest common ancestor
    - 2. 如果p, q 在root的左右两边, 这就是分叉口, 那么root就是lowest common ancestor
    - 3. 如果p, q 在root的同一边 (左,右), 那么继续dfs
- O(logn) extra space: recursive stack space
- O(logn) time



---

**119. [156. Binary Tree Upside Down.java](https://github.com/awangdev/LintCode/blob/master/Java/156.%20Binary%20Tree%20Upside%20Down.java)**      Level: Medium      Tags: [DFS, Tree]
      

#### DFS
- Given that left & right nodes are always available in pair, at each level: 
  - perform dfs to find new root: return deepest left node as root
  - pick out curr left node and fix current level: 
    - add right node as left node
    - add root as right node



---

**120. [254. Factor Combinations.java](https://github.com/awangdev/LintCode/blob/master/Java/254.%20Factor%20Combinations.java)**      Level: Medium      Tags: [BFS, Backtracking, DFS]
      


#### Method1: DFS
- build candidate into dfs: treat each list candidate as success, add to rst
- remove last item from the candidate, try to add factor to it, and supply it with remain element
- backtrack after dfs


#### Method2: BFS
- Check if the number can be devided by [2, sqrt(n)], return a list of possible factors. Only check till `Math.sqrt(n)`
  - build suffixes: use the factor to devide last element of list and replace last element
  - build candidate: replace last element of the queue item with new list of suffixes; add to rst
  - add success item back to queue: in case last element can be simplified
- **remove dupilcates**: since we start factor from [2, sqrt(n)], the final factor list should be **ascending**!!
- time: O(x), x is the # of results
- space: O(y), y is all ongoing candidates in queue



---

