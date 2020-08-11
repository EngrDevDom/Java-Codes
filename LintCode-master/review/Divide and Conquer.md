 
 
 
## Divide and Conquer (38)
**0. [Search a 2D Matrix II.java](https://github.com/awangdev/LintCode/blob/master/Java/Search%20a%202D%20Matrix%20II.java)**      Level: Medium      Tags: [Binary Search, Divide and Conquer]
      
给matrix, 每一行sorted, 每一列从上往下sorted, 找target是否存在

#### Binary Search
- 根据给定的性质, 其实点选的极端一点: x = 最下面的row, y = 当下一行里面最小的left position. 
- (x,y)在左下角
- 在此情况下, 只能往一个方向运行: 如果小于target, y++; 如果大于target, 那么只能x--
- 每次操作, 都是删掉一行, 或者一列, 再也不需要回头看
- `while (x >= 0 && y < col) {}` 确保不会跑脱
- 同样的方式: 可以从右上角(0, col - 1) 开始, 代码稍微改一改

#### Divide and Conquer?
- TODO



---

**1. [Fast Power.java](https://github.com/awangdev/LintCode/blob/master/Java/Fast%20Power.java)**      Level: Medium      Tags: [DFS, Divide and Conquer]
      
如题: Calculate the a^n % b where a, b and n are all 32bit integers.

#### Divide and Conquer
- a^n可以被拆解成(a*a*a*a....*a)， 是乘机形式，而%是可以把每一项都mod一下的。所以就拆开来take mod.
- 这里用个二分的方法，recursively二分下去，直到n/2为0或者1，然后分别对待. 
- 注意1: 二分后要conquer，乘积可能大于Integer.MAX_VALUE, 所以用个long.
- 注意2: 要处理n%2==1的情况，二分时候自动省掉了一份 a，要乘一下。




---

**2. [Interval Minimum Number.java](https://github.com/awangdev/LintCode/blob/master/Java/Interval%20Minimum%20Number.java)**      Level: Medium      Tags: [Binary Search, Divide and Conquer, Lint, Segment Tree]
      
给一串数字 int[], 然后一个query Interval[], 每个interval是 [start, end], 找query 区间里的最小值.

#### Segment Tree
- SegtmentTree, methods: Build, Query. 这题是在SegmentTreeNode里面存min.
- 类似的有存:max, sum, min



---

**3. [Binary Tree Longest Consecutive Sequence II.java](https://github.com/awangdev/LintCode/blob/master/Java/Binary%20Tree%20Longest%20Consecutive%20Sequence%20II.java)**      Level: Medium      Tags: [DFS, Divide and Conquer, Double Recursive, Tree]
      
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

**4. [Subtree of Another Tree.java](https://github.com/awangdev/LintCode/blob/master/Java/Subtree%20of%20Another%20Tree.java)**      Level: Easy      Tags: [DFS, Divide and Conquer, Tree]
      
#### Tree 
- Traverse tree: left, right
- Concept of partial compare vs. whole compare



---

**5. [Decode String.java](https://github.com/awangdev/LintCode/blob/master/Java/Decode%20String.java)**      Level: Medium      Tags: [DFS, Divide and Conquer, Stack]
      
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

**6. [Median of Two Sorted Arrays.java](https://github.com/awangdev/LintCode/blob/master/Java/Median%20of%20Two%20Sorted%20Arrays.java)**      Level: Hard      Tags: [Array, Binary Search, DFS, Divide and Conquer]
      
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

**7. [Construct Binary Tree from Inorder and Postorder Traversal.java](https://github.com/awangdev/LintCode/blob/master/Java/Construct%20Binary%20Tree%20from%20Inorder%20and%20Postorder%20Traversal.java)**      Level: Medium      Tags: [Array, DFS, Divide and Conquer, Tree]
      
#### DFS, Divide and Conquer
- 写个Inorder和Postorder的例子。利用他们分left/right subtree的规律解题。
- Postorder array 的末尾， 就是当下层的root.   
- 在Inorder array 里面找到这个root,就刚好把左右两边分割成left/right tree。
- 这题比较tricky地用了一个helper做recursive。 特别要注意处理index的变化, precisely考虑开头结尾
- runtime: O(n), visit && build all nodes

#### Improvement
- `findMid(arr)` can be replaced with a map<value, index>, no need execute O(n) search at runtime



---

**8. [Sort List.java](https://github.com/awangdev/LintCode/blob/master/Java/Sort%20List.java)**      Level: Medium      Tags: [Divide and Conquer, Linked List, Merge Sort, Sort]
      
#### Merge sort
- 1. find middle. 快慢指针
- 2. Sort: 切开两半，先sort前半, 如果先sort了mid.next~end, sort后，中间点mid.next == null，再sort前半段
- 3. Merge:  假设given list A, B 已经是sorted, 然后按照大小，混合。
- 要recursively call sortList() on partial list.

#### Quick sort
- 想做可以看讲义：http://www.jiuzhang.com/solutions/sort-list/
- 但是quick sort不建议用在list上面。
- 排列list, merge sort可能更可行和合理。原因分析在下面， 以及： http://www.geeksforgeeks.org/why-quick-sort-preferred-for-arrays-and-merge-sort-for-linked-lists/



---

**9. [Convert Sorted Array to Binary Search Tree.java](https://github.com/awangdev/LintCode/blob/master/Java/Convert%20Sorted%20Array%20to%20Binary%20Search%20Tree.java)**      Level: Easy      Tags: [DFS, Divide and Conquer, Tree]
      
如题, build balanced BST from sorted array

#### DFS
- Binary Search Tree特点: 左边的node都比右边的node小. 
- height balance, subtree height 相差<1, 必须左右sub tree均分. 做DFS(num, start, end)
- 在每一个level, 找到中间点, 然后分割2半, 继续dfs
- Divide and Conquer
- time/space: O(n), visit all nodes, no redundant visits.



---

**10. [Populating Next Right Pointers in Each Node.java](https://github.com/awangdev/LintCode/blob/master/Java/Populating%20Next%20Right%20Pointers%20in%20Each%20Node.java)**      Level: Medium      Tags: [DFS, Divide and Conquer, Tree]
      
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

**11. [Find Peak Element II.java](https://github.com/awangdev/LintCode/blob/master/Java/Find%20Peak%20Element%20II.java)**      Level: Hard      Tags: [Binary Search, DFS, Divide and Conquer]
      
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

**12. [Segment Tree Modify.java](https://github.com/awangdev/LintCode/blob/master/Java/Segment%20Tree%20Modify.java)**      Level: Medium      Tags: [Binary Tree, DFS, Divide and Conquer, Lint, Segment Tree]
      
给一个segmentTree, node里面存max. 写一个modify function: modify(node, index, value).

#### Segment Tree, Divide and Conquer
- Recursively 在segment tree里面找index, update it with value.   
- 每个iteration，很可能（要么左手，要么右手）max就变了。所以每次都left.max and right.max compare一下
- 最后轮回到头顶，头顶一下包括头顶，就全部都是max了



---

**13. [Unique Binary Search Tree II.java](https://github.com/awangdev/LintCode/blob/master/Java/Unique%20Binary%20Search%20Tree%20II.java)**      Level: Medium      Tags: [BST, DP, Divide and Conquer, Tree]
      
给一个数字n, 找到以(1...n)为node的所有unique BST.

#### BST
- 根据BST规则, divide and conquer
- 取一个value, 然后分两半(start, value - 1), (value + 1, end) 分别dfs
- 然后左右两边的结果cross match

#### DP? Memoization?



---

**14. [Expression Add Operators.java](https://github.com/awangdev/LintCode/blob/master/Java/Expression%20Add%20Operators.java)**      Level: Hard      Tags: [Backtracking, DFS, Divide and Conquer, String]
      

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

**15. [Segment Tree Query II.java](https://github.com/awangdev/LintCode/blob/master/Java/Segment%20Tree%20Query%20II.java)**      Level: Medium      Tags: [Binary Tree, DFS, Divide and Conquer, Lint, Segment Tree]
      
#### Segment Tree
- 和 Segment Tree Query I 以及其他Segment Tree类似: 这个SegmentTreeNode return count of elements in range
- 这个题目考了validate input source：input 的start,end可能超出root[start,end]。   
- 那么第一步就要先clear一下: 1. 完全不在range就return 0. 2. 有range重合就规整到root的range.




---

**16. [Convert Sorted List to Binary Search Tree.java](https://github.com/awangdev/LintCode/blob/master/Java/Convert%20Sorted%20List%20to%20Binary%20Search%20Tree.java)**      Level: Medium      Tags: [BST, DFS, Divide and Conquer, Linked List]
      
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

**17. [Burst Balloons.java](https://github.com/awangdev/LintCode/blob/master/Java/Burst%20Balloons.java)**      Level: Hard      Tags: [DP, Divide and Conquer, Interval DP, Memoization]
      
一排球, 每个球有value, 每次扎破一个, 就会积分: 左*中间*右 的值. 求, 怎么扎, 最大值?

TODO: Need more thoughts on why using dp[n + 2][n + 2] for memoization, but dp[n][n] for interval DP.

#### Interval DP
- 因为数组规律会变, 所以很难找'第一个burst的球'. 反之, 想哪一个是最后burst?
- 最后burst的那个变成一堵墙: 分开两边, 分开考虑, 加法原理; 最后再把中间的加上.
- dp[i][j] represent max value on range [i, j)
- Need to calculate dp[i][j] incrementally, starting from range size == 3 ---> n
- Use k to divide the range [i, j) and conquer each side.

##### Interval DP 三把斧:
- 中间劈开
- 砍断首或尾
- Range区间作为iteration的根本

##### Print the calculation process
- use pi[i][j] and print recursively.
- Print k, using pi[i][j]: max value taken at k

#### Memoization
- 其实会做之后挺好想的一个DP
- dp[i][j] =  balloons i~j 之间的 max. 
- 然后找哪个点开始burst? 设为x。
- For loop 所有的点作为x， 去burst。
- 每次burst都切成了三份：左边可以recusive 求左边剩下的部分的最大值 + 中间3项相乘 + 右边递归下去求最大值。
- Note: 这个是Memoization, 而不纯是DP
- 因为recursive了，其实还是搜索，但是memorize了求过的值，节省了Processing




---

**18. [Kth Largest Element in an Array.java](https://github.com/awangdev/LintCode/blob/master/Java/Kth%20Largest%20Element%20in%20an%20Array.java)**      Level: Medium      Tags: [Divide and Conquer, Heap, MinHeap, PriorityQueue, Quick Sort]
      
kth largest in array

#### PriorityQueue, MinHeap
- Need to maintain k large elements, where the smallest will be compared and dropped if applicable: 
- Maintain k elements with min value: consider using minHeap
- add k base elements first
- Maintain MinHeap: only allow larger elements (which will squzze out the min value)
- Remove peek() of queue if over size
- O(nlogk)


#### Quick Sort
- 用Quick Sort 里面partion的一部分
- sort结束后是ascending的, 那么 n - k 就是第k大. 
- partion的结果是那个low, 去找 low==nums.size() - k， 也就是倒数第K个。    
- 没找到继续partion recursively.
- sort的过程是排一个从小到大的list. (同样的代码还可以好xth smallest，mid变成x就好)
- Steps:
- 每个iteration, 找一个pivot,然后从low,和high都和pivot作比较。    
- 找到一个low>pivot, high<pivot, 也就可以swap了。    
- 得到的low就是当下的partion point了
- Overall O(nlogN), average O(n) for this problem.



---

**19. [Smallest Subtree with all the Deepest Nodes.java](https://github.com/awangdev/LintCode/blob/master/Java/Smallest%20Subtree%20with%20all%20the%20Deepest%20Nodes.java)**      Level: Medium      Tags: [DFS, Divide and Conquer, Tree]
      

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

**20. [Binary Tree Longest Consecutive Sequence.java](https://github.com/awangdev/LintCode/blob/master/Java/Binary%20Tree%20Longest%20Consecutive%20Sequence.java)**      Level: Medium      Tags: [DFS, Divide and Conquer, Tree]
      
找到binary tree 里的最长 consecutive sequence.

#### DFS
- Divide and Conquer. dfs
- 分开 看左边/右边
- 如果左边满足连续递增的规则, dfs (depth + 1), 如果不满足规则, dfs(depth = 1)
- 右边也是一样
- 对结果跟max作比较, return



---

**21. [[lint]. Segment Tree Build II.java](https://github.com/awangdev/LintCode/blob/master/Java/[lint].%20Segment%20Tree%20Build%20II.java)**      Level: Medium      Tags: [Binary Tree, Divide and Conquer, Lint, Segment Tree]
      
给一个array, 建造segment tree structure, 

每个treeNode 里面存这个range里的 max value, return root node.

#### Segemnt Tree
- 给的是Array. 注意找区间内的max, assign给区间. 其余和普通的segment tree build一样   
- 注意, segment tree是根据array index range 排位: 根据index in [0, array.length - 1]割开区间, break到底
- 最终start==end做结尾
- 这道题要trackmax, 那么在leaf node assign max=A[start] or A[end]
- 往上,parent一层的max:就是比较左右孩子,其实都是在两个sub-tree里面比较sub-tree的max。   

- Devide and Conquer
- 先分，找到left/right，比较max,在create current node,再append到当前node上面。
- 实际上是depth-first, 自底向上建立起的。



---

**22. [[lint]. Segment Tree Query.java](https://github.com/awangdev/LintCode/blob/master/Java/[lint].%20Segment%20Tree%20Query.java)**      Level: Medium      Tags: [Binary Tree, DFS, Divide and Conquer, Lint, Segment Tree]
      
给了segment Tree, node里面有Max value, 找[start,end]里面的max

#### Segment Tree, Divide and Conquer
- 根据[start,end]跟 mid of (root.start, root.end) 做比较:
	- 1) [start,end] on LEFT of mid
	- 2) [start, end] on RIGHT of mid
	- 3) [start, end] includes mid: break into 2 queries
		- query [leftNode, start, node.left.end]
		- query [rightNode, node.right.start, end]



---

**23. [[lint]. Segment Tree Build.java](https://github.com/awangdev/LintCode/blob/master/Java/[lint].%20Segment%20Tree%20Build.java)**      Level: Medium      Tags: [Binary Tree, Divide and Conquer, Lint, Segment Tree]
      
给一个区间[startIndex, endIndex], 建造segment tree structure, return root node.

#### Segment Tree
- Usage
  - which of these intervals contain a given point
  - which of these points are in a given interval
- Recursively build the binary tree
  - 左孩子：（A.left, (A.left+A.rigth)/2）   
  - 右孩子：（(A.left+A.rigth)/2＋1， A.right）   



---

**24. [327. Count of Range Sum.java](https://github.com/awangdev/LintCode/blob/master/Java/327.%20Count%20of%20Range%20Sum.java)**      Level: Hard      Tags: [BIT, Divide and Conquer, Merge Sort, PreSum, Segment Tree]
      

TODO: Write the code + merge function

#### Divide and Conquer + PreSum + MergeSort
- https://leetcode.com/problems/count-of-range-sum/discuss/77990/Share-my-solution
- 1) build preSum[n+1]: then sum range [i,j]= preSum[j+1] - preSum[i]
- 2) Divide and Conquer: 
    - 先考虑[start, mid] range里的 ran sum result
    - 再考虑[mid, end] range里面的结果
    - 最后考虑[low, high]总体的结果
- NOTE: should write merge() function, but that is minor, just use `Arrays.sort(nums, start, end)`, OJ passed
- Every mergeSort() has a for loop => O(n log n)
- 如何 count range?
    - 这里比较特别的一个做法: 找一个 [low, mid]里面的i, mid 之后的preSum作比较 (解释源自: https://blog.csdn.net/qq508618087/article/details/51435944)
    - 即在右边数组找到两个边界, 设为`m, n`, 
    - 其中m是在右边数组中第一个使得`sum[m] - sum[i] >= lower`的位置, 
    - n是第一个使得`sum[n] - sum[i] > upper`的位置, 
    - 这样`n-m`就是与左边元素i所构成的位于`[lower, upper]`范围的区间个数. 

##### 神奇的重点: 为什么要 merge and sort
- 边界[lower, higher] 在 sorted array 好作比较, 一旦过界, 就可以停止计算, 减少不必要计算.
- 上面这个n,m的做法可行的前提: preSum[]里面前后两个 range[low, mid], [mid, high]已经sorted了
    - 也就是说, 在recursively mergeSort()的时候, 真的需要merge sorted 2 partitions
    - 也许会问: 能不能sort呢, sort不久打乱了顺序? 对,打乱的是preSum[]的顺序.
    - 但是不要紧: 很巧妙的, 分治的时候, 前半段/后半段 都在原顺序保留的情况下 分开process完了, 最后才merge
- 在做m,n 的range的时候, 原理如下, 比如preSum被分成这么两段: `[A,B,C]`, `[D,E,F]`
    - 每一个preSum value `A` 在跟 preSum[i] 作比较的时候 `A - preSum < lower`, 都是单一作比较, 不牵扯到 B, C
    - 因此, `[A, B, C]` 是否保留一开始 preSum的顺序在此时不重要
- 此时最重要的是, `[A,B,C]`以及排序好, 那么在于 `lower` boundary 作比较的时候, 一旦过界, 就可以停止计算(减少不必要的计算)


#### BIT
- TODO?

#### Segment Tree
- This segment tree approach(https://leetcode.com/problems/count-of-range-sum/discuss/77987/Java-SegmentTree-Solution-36ms) 
    - does not build segment tree based on given nums index
    - it is built on sorted preSum array.
- regular segment tree based on nums array does not work:
    - segment tree based on input array is good for: search/query by index
    - is NOT good at: given range sum/value, find indexes
    - why? segment tree is built based on index division, not by range value division.



---

**25. [53. Maximum Subarray.java](https://github.com/awangdev/LintCode/blob/master/Java/53.%20Maximum%20Subarray.java)**      Level: Easy      Tags: [Array, DFS, DP, Divide and Conquer, PreSum, Sequence DP, Subarray]
      

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

**26. [1110. Delete Nodes And Return Forest.java](https://github.com/awangdev/LintCode/blob/master/Java/1110.%20Delete%20Nodes%20And%20Return%20Forest.java)**      Level: Medium      Tags: [DFS, Divide and Conquer, Tree]
      

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

**27. [493. Reverse Pairs.java](https://github.com/awangdev/LintCode/blob/master/Java/493.%20Reverse%20Pairs.java)**      Level: Medium      Tags: [BST, Binary Indexed Tree, Divide and Conquer, Merge Sort, Segment Tree]
      
给一串数字, count total reverse pair `nums[i] > 2*nums[j]`, i < j

This problem can be solved with Merge sort concept, BST, Segment Tree and Binary Indexed Tree. Good for learning/review.

#### Merge Sort, Divide and Conquer
- Using merge sort concept (NOT merge sort impl).
- One very simply desire: if we want to know # elements between [i, j] such that `nums[i] > 2*nums[j]`, it would be so great if array is **sorted**! 
    - If sorted,  fix index i, keep j++ for all `nums[i]/2.0 > nums[j]`
    - We CANNOT just sort entire array. WHY? Because it distrupts the value of curr index i, and the restriction is: `find matching elements on right side of curr index i`
    - BUT, what about just sort `right side of i`, and make sure the subproblem (i+1, end) is solved first?
- 灵感: use merge sort concept.divide and conquer [i ~ n] into 2 sections:
    - 1) solve subProblem(start,mid) & subProblem(mid+1, end). sort the sub array so that it can be used recursively at parent level.
    - 2) solve the curr pblem: for all [i, mid], check against [mid+1, end].
- Question1: does it cover all use cases?
    - First, subProblem(start,mid) & subProblem(mid+1, end) recursively solves its own range
    - Last, the only range is the current level problem check `[i, mid]` against its entire right side range: `[mid+1, end]`. DONE. all covered.
- Question2: what it is okay for `subProblem(start,mid) & subProblem(mid+1, end)` partially sort the array?
    - that is the goal: 1) we want the right side range to be sorted; 2) left range is sorted but it does not matter since we treat [start, mid] as 1 group
- use classic while loop `while(j<=e && nums[i]/2.0 > nums[j])` to count pairs


#### Segment tree
- TODO
- split the array into index-based segment tree, where each element is at leaf
- store min of range: use min to determine if certain range is needed for further query
- query for each element right side range (i + 1, end), where it recursively query&aggregate sub-range if meeting requirement `nums[i] > 2*nums[j]`
- only when target > subRange.min * 2: there are possible candidates, query further
- worst case O(n^2) when all tailing elements are meeting requirement.

#### BST
- TODO
- Build the BST based on node value. It will be not applicable if we search after entire tree is built (our goal is right range), so we need to build right elements, and search/count right after the elements is added
- Worst case is still O(n^2), if all added nodes are meeting requirement 
- search(tree, curr / 2.0)



#### O(n^2)
- check each one of them




---

**28. [297. Serialize and Deserialize Binary Tree.java](https://github.com/awangdev/LintCode/blob/master/Java/297.%20Serialize%20and%20Deserialize%20Binary%20Tree.java)**      Level: Hard      Tags: [BFS, DFS, Deque, Design, Divide and Conquer, Tree]
      

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

**29. [973. K Closest Points to Origin.java](https://github.com/awangdev/LintCode/blob/master/Java/973.%20K%20Closest%20Points%20to%20Origin.java)**      Level: Medium      Tags: [Divide and Conquer, Heap, Sort]
      

#### PriorityQueue
- Create customized Point{} class
- Sort by distance
- Maintain queue size <= K

#### Divide and Conquer
- ?, select sort?



---

**30. [315. Count of Smaller Numbers After Self.java](https://github.com/awangdev/LintCode/blob/master/Java/315.%20Count%20of%20Smaller%20Numbers%20After%20Self.java)**      Level: Hard      Tags: [BST, Binary Indexed Tree, Binary Search, Divide and Conquer, Segment Tree]
      

给一串数字nums[], 求一个新数组result, where result[i] = # of smaller items on right of nums[i]

#### Method1: Binary Search on processed list
- What if `the processed list is sorted`, so that I can BinarySeach for curr target?
    - process from end
    - binary search for `index to insert new element` in sorted ascending list
    - that index = # of smaller numbers; record it for final result
- time: O(nlogn)
- space: O(n)


#### Method2: Segment Tree based on actual value
- Segment Tree functions:
    - `Build`: construct segment tree based on min/max range: at leaf node, update count of numbers in range
    - `modify(SegmentTreeNode root, int value, int count)`: find leaft at with value, and update count for leaf & all parent nodes
    - `query(SegmentTreeNode root, int start, int end)`: return count # of numbers in range [start, end]
- Very similar to `Count of Smaller Number`, where segment tree is built on actual value!!
- IMPORTANT to drop processed number from left-hand-side: 
    - only find on remaining numbers. 
    - Utilize `modify(root, target, -1)` to erase element count & update the tree.
- time: `n * log(m)`, where m = Math.abs(max-min). log(m) is used to modify() the leaf element
- space: O(m)
- `Define the positive range`
    - negative nubmer division `rounds up towards 0` (this is a problem). (i.e. `(-2 - 1) / 2 = -1.5 = -1`), which causes range error.
    - We want the entire segment tree range to be ascending, and we want the mid = (start+end)/2 to round down.
    - Solution: 
        - build entire segment tree based on [min, max], where min must be >= 0. 
        - we can do this by adding Math.abs(min) onto both min/max, as well as +offset during accessing nums[i]



#### Method3: Binary Search Tree
- https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76580/9ms-short-Java-BST-solution-get-answer-when-building-BST
- Assume we have a BST, where each node has smallerCount and a val, for any new target, how to find smaller items?
    - 1) add the # of smaller count to current node
    - 2) compare:
        - if target < node.val, keep searching `countVisit(node.left, target)`
        - if target > node.val: 1) add currNode.smallerCount, 2) minus node.right.smallertCount (reduce double-counting), 3) plus `countVisit(node.right, target)`
    - remember to create left/right node before dfs countVisit into the sides.


#### Method4: Binary Indexed Tree



---

**31. [169. Majority Element.java](https://github.com/awangdev/LintCode/blob/master/Java/169.%20Majority%20Element.java)**      Level: Easy      Tags: [Array, Bit Manipulation, Divide and Conquer, Moore Voting, Sort]
      

#### HashMap count occurance
- Time, Space: O(n)


#### Moore Voting Algorithm 投票消减
- 前提: input必须valid, 比较罕见少用. Moore Voting Algorithm: https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
- 与当下candidate相同, vote++. 与之不同, vote--.
- Majority Number是指超半数, 多1个就行: 消减至最后, 会至少有vote>=1.
- 那么: vote++, vote--到最后剩下的就是winner. 
- 这个方法比较greedy, 前提是: valid input, 是一定有一个majority number的。否则此法不成。[1,1,1,2,2,2,3]是个invalid input,结果是3，当然也错了。
- time: O(n), space O(1)

#### Sort
- sort entire nums array
- assume there is a solution, then nums[n/2] must be that majority num
- time O(nlogn)

#### Divide and Conquer
1. Recursive approach
1. For ange rangeA & rangeB, rangeA has majorElementA and rangeB has majorElementB
    - majorElementA = majorElementB, of course this element will be the major number for whole range
    - if majorElementA != majorElementB, then need to count both elements in whole range
    - of course the larger occurance will be the major num

#### Bit manipulation
- TODO

#### Related Problems
- Majority Number II，超1/3, 那么就分三份处理，countA, countB来计算最多出现的两个。
- Majority Number III, 超1/k, 那么自然分k份。这里用到 HashMap。



---

**32. [23. Merge k Sorted Lists.java](https://github.com/awangdev/LintCode/blob/master/Java/23.%20Merge%20k%20Sorted%20Lists.java)**      Level: Medium      Tags: [Divide and Conquer, Heap, Linked List, Merge Sort, PriorityQueue]
      

给一个array of ListNode, 把所有node按照大小连成一条.

#### Method1: Divide and Conquer, Merge sort
- By Definition, merge sort: divide the list into 2 parts
- recursively merge them together.
- time complexity: O(nlogk) divide by log(k) times, each recursive call can work on n nodes.
- space: O(logk) stacks 

#### Method2: Priorityqueue
- Iterative, PQ来排列所有list的leading node.
- Note: k lists need to be sorted (luckily, already given)
- 时间：n*O(logk), where n = total node number, and PriorityQueue: logk, 
- Note:
    - 1. 不要忘记customized priority需要一个customized new Comparator<T>()
    - 2. Given list 里面也可能有null node, 不要忘记查.

#### Followup
- 如果k很大，一个机器上放不下所有的k list怎么办？ 
- 如果Merge起来的很长，一个机器上放不下怎么办？




---

**33. [218. The Skyline Problem.java](https://github.com/awangdev/LintCode/blob/master/Java/218.%20The%20Skyline%20Problem.java)**      Level: Hard      Tags: [BIT, Divide and Conquer, HashHeap, Heap, PriorityQueue, Segment Tree, Sweep Line]
      

#### Sweep Line, Time O(nLogN), Space O(n)
- Analysis (inspired by, but not same solution: https://leetcode.com/problems/the-skyline-problem/solution/)
    - If there are just 2 overlapping building (totally 4 points on x-axis), here is the outline process:
    - Process x coordinate from left->right, one at a time.
        - 1) compare all `on-going heights` and find max, add as new outline point
        - 2) Handling building end: if the position ends a building, need to remove this height from the list of `on-going heights`
    - Requires 2 heap:
        1) sort by x coordinates
        2) `on-going heights`: maintain a pq of ongoing heights
- Steps: 
    - original reference http://codechen.blogspot.com/2015/06/leetcode-skyline-problem.html?_sm_au_=isVmHvFmFs40TWRt
    - 画图分析: 需要找到 non-overlaping height point at current index; also height needs to be different than prev height peek to be visible.
    - `on-going heights`: 用max-heap (reversed priorityqueue)，再iterate heightPoints 来存最大的height
    - NOTE: heightQueue里面加一个0, 用来在结尾的时候做closure
- time: initial sort O(nlogn) + calculate n * O(nlogn) [maxQueue sort]
- space: O(n)

#### Segment Tree
- 看了一些做法, segment tree写法很复杂, 估计在面试中难以用segment tree来写: https://www.cnblogs.com/tiezhibieek/p/5021202.html

#### HashHeap
- HashHeap template 可以考虑: https://www.jiuzhang.com/solution/building-outline/#tag-highlight-lang-java

Binary Indexed Tree?





---

**34. [105. Construct Binary Tree from Preorder and Inorder Traversal.java](https://github.com/awangdev/LintCode/blob/master/Java/105.%20Construct%20Binary%20Tree%20from%20Preorder%20and%20Inorder%20Traversal.java)**      Level: Medium      Tags: [Array, DFS, Divide and Conquer, Hash Table, Tree]
      

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

**35. [426. Convert Binary Search Tree to Sorted Doubly Linked List.java](https://github.com/awangdev/LintCode/blob/master/Java/426.%20Convert%20Binary%20Search%20Tree%20to%20Sorted%20Doubly%20Linked%20List.java)**      Level: Medium      Tags: [BST, DFS, Divide and Conquer, Linked List, Tree]
      

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

**36. [98. Validate Binary Search Tree.java](https://github.com/awangdev/LintCode/blob/master/Java/98.%20Validate%20Binary%20Search%20Tree.java)**      Level: Medium      Tags: [BST, DFS, Divide and Conquer, Tree]
      

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

**37. [215. Kth Largest Element in an Array.java](https://github.com/awangdev/LintCode/blob/master/Java/215.%20Kth%20Largest%20Element%20in%20an%20Array.java)**      Level: Medium      Tags: [Divide and Conquer, Heap, MinHeap, PriorityQueue, Quick Select, Quick Sort]
      

kth largest in array

#### PriorityQueue, MinHeap
- Use minHeap to maintain PQ of k size and return PQ.peek()
    - Maintain MinHeap: only allow larger elements (which will squzze out the min value)
    - Remove peek() of queue if over size
- O(nlogk)

#### Quick Select, Quick Sort
- 用Quick Sort 里面partion的一部分: sort结束后是ascending的.
  - kth largest = (n - k)th smallest
  - in partioned array (quick sort), the portion before pivot are less than pivot
  - that is, the `pivot value` is the divider: anything after pivot is larger than it.
  - after `swap(nums, low, pivot)`: index low has the (n-k)th smallest, if `low = n-k`
- Steps:
  - each iteration: pick pivot,然后从low,和high都和pivot作比较
  - Find `low>pivot, high<pivot` to swap
  - The new low is the next partion point
- Time: average O(n), worst case O(n^2)
- space: O(1) extra spaces besides recursive stack



---

