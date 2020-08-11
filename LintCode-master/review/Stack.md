 
 
 
## Stack (38)
**0. [Convert Expression to Polish Notation.java](https://github.com/awangdev/LintCode/blob/master/Java/Convert%20Expression%20to%20Polish%20Notation.java)**      Level: Hard      Tags: [Binary Tree, DFS, Expression Tree, Stack]
      
给一串字符, 用来表示公式expression. 把这个expression转换成 Polish Notation (PN).

#### Expression Tree
- Expression Tree: Minimum Binary Tree (https://lintcode.com/en/problem/expression-tree-build/)
- 根据题意做出Expression Tree出来以后: 来个Pre-order-traversal 就能记录下 Polish Notation
- 本题没有给'ExpressionTreeNode', 所以把TreeNode就当做成我们需要的node, 里面扩展成有left/right child就可以了.
- Note: label需要是String. 虽然 Operator是长度为1的char, 但是数字可为多位



---

**1. [Decode String.java](https://github.com/awangdev/LintCode/blob/master/Java/Decode%20String.java)**      Level: Medium      Tags: [DFS, Divide and Conquer, Stack]
      
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

**2. [Remove Duplicate Letters.java](https://github.com/awangdev/LintCode/blob/master/Java/Remove%20Duplicate%20Letters.java)**      Level: Hard      Tags: [Greedy, Hash Table, Stack]
      
#### Hash Table, Greedy
- count[] = int[256], 不需要 `c-'a'`
- boolean visited[]: 一旦一个字母固定了位置后, 再次遇到时候, 直接跳过用过的character
- 如果tail字母可以变小, 那就delete掉tail, 重新接上新字母 (前提条件: 去掉的字母后面还会再出现, set visited[tail] = false)
- Space: O(1) count[], visited[].
- Time: Go through all letters O(n)

#### Stack
- Use stack instead of stringBuffer: keep append/remove last added item
- However, stringBuffer appears to be faster than stack.



---

**3. [Backspace String Compare.java](https://github.com/awangdev/LintCode/blob/master/Java/Backspace%20String%20Compare.java)**      Level: Easy      Tags: [Stack, Two Pointers]
      


---

**4. [Implement Stack using Queues.java](https://github.com/awangdev/LintCode/blob/master/Java/Implement%20Stack%20using%20Queues.java)**      Level: Easy      Tags: [Design, Stack]
      
如题.

#### Queue, 倒水
- 两个Queue,交互倒水
- 用一个Temp做swap

##### 做法1
- 逻辑在push里面:
- 1. x 放q2。
- 2. q1全部offer/append到q2.
- 3. 用一个Temp做swap q1, q2.
- q1的头，就一直是最后加进去的值.


##### 做法2
- 逻辑在top()/pop()里, 每次换水，查看末尾项.




---

**5. [Maximum Binary Tree.java](https://github.com/awangdev/LintCode/blob/master/Java/Maximum%20Binary%20Tree.java)**      Level: Medium      Tags: [Stack, Tree]
      
给一串数字, 做一个 maximum binary tree: 最顶上的root最大; 左child也是一个max tree, 右child也必须是max tree.

#### Monotonous Stack
- 用到bottom->top递减的stack: 最底下的root维持成最大的element.
- 过程当中, 一旦遇到currNode.val > stack.peek(), 就意味着需要把这个currNode放在 stack的底层位置.
- 也就是说, 遇到这个条件, process, pop()所有 currNode.val > stack.peek(), 最后把currNode加进去.

- maxTree题目本身的要求是: 大的在最中间, 左右两边的subTree也要是maxTree:
- Monotonous Stack在这里帮助 keep/track of max value, 但是left/right tree的logic是MaxTree独有的.
- left/right node的assignment是根据题目要求: 中间最大值分开后, 左边的是左边subTree, 右边的作为右边subTree.

#### Previous notes
- Should memorize MaxTree. 依次类推，会做Min-Tree, Expression Tree
- Stack里，最大的值在下面。利用此性质，有这样几个step:

##### Step1
- 把所有小于curr node的，全Pop出来, while loop, keep it going.    
- 最后pop出的这个小于Curr的node：它同时也是stack里面pop出来小于curr的最大的一个，最接近curr大小。（因为这个stack最大值靠下面）    
- 把这个最大的小于curr的node放在curr.left.    

##### Step2   
- 那么，接下去stack里面的一定是大于curr：   
- 那就变成curr的left parent. set stack.peek().right = curr.

##### Step3   
- 结尾：stack底部一定是最大的那个，也就是max tree的头。





---

**6. [Maximal Rectangle.java](https://github.com/awangdev/LintCode/blob/master/Java/Maximal%20Rectangle.java)**      Level: Hard      Tags: [Array, DP, Hash Table, Stack]
      
#### 方法1: monotonous stack
分解开来, 其实是'Largest Rectangle in Histogram', 只不过这里要自己model heights.
一个2D array里面的rectangle, 最终也是用height * width做出来的.
巧妙在于, 把每一行当做底边, 算出这个底边, 到顶部的height: 
- 如果底边上的一个value==0, 那么算作没有height(以这个底边做rectangle, value==0的位置是空中楼阁, 不能用)
- 如果底边上的value==1, 那么就把上面的height加下来, 做成histogram

如果看具体实例, 有些row似乎是白算的, 但是没有办法, 这是一个搜索的过程, 最终会比较出最优解.

#### 方法2: DP
Coordinate DP?



---

**7. [Expression Evaluation.java](https://github.com/awangdev/LintCode/blob/master/Java/Expression%20Evaluation.java)**      Level: Hard      Tags: [Binary Tree, DFS, Expression Tree, Minimum Binary Tree, Stack]
      
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

**8. [Min Stack.java](https://github.com/awangdev/LintCode/blob/master/Java/Min%20Stack.java)**      Level: Easy      Tags: [Design, Stack]
      
双Stack：一个正常stack，另一个minStack存当下level最小值. 注意维护minStack的变化

另外. 如果要maxStack，也是类似做法



---

**9. [Kth Smallest Element in a BST.java](https://github.com/awangdev/LintCode/blob/master/Java/Kth%20Smallest%20Element%20in%20a%20BST.java)**      Level: Medium      Tags: [BST, DFS, Stack, Tree]
      
#### Iterative + stack: inorder traversal
- 很容想到Inorder-binary-search-tree Traversal
- Iterative 稍微难想点：先把最左边的add， pop() stack， 加上右边（如果存在）； 下一个轮回，如果又左孩子，又是一顿加。

#### Recursive + DFS
- 然后稍微优化一下，确保rst.size() == k 时候，就可以return了
- check leaf => dfs left => add root => dfs right



---

**10. [Implement Stack.java](https://github.com/awangdev/LintCode/blob/master/Java/Implement%20Stack.java)**      Level: Easy      Tags: [Stack]
      
随便用一个data structure, implement stack.

#### Stack, 先入, 后出
- ArrayList: return/remove ArrayList的末尾项。
- 2 Queues



---

**11. [Longest Valid Parentheses.java](https://github.com/awangdev/LintCode/blob/master/Java/Longest%20Valid%20Parentheses.java)**      Level: Hard      Tags: [Coordinate DP, Stack, String]
      
给一串string, 里面只有`(`, `)`. 找最长valid parentheses 的长度.

#### 1D Coordinate DP
- use dp[i] track local max, maintain global max
- int[] dp. dp[i]: longest valid string that ends on i.
- 结尾是 ')', 2种情况: 1. 刚好s[i-1]是'('; 2. s[i]的')'更前面的一个起始'(' 对应
- 注意, 结尾如果是'('属于不合理情况, 忽略.
- init: dp[0] = 0, 单个char不可能成型.
- 计算顺序: 从左到右, 找local max, maintain global max
- O(n) space, O(n) runtime

#### Stack
- Stack 里面存所有的open/close parentheses.
- 如果遇到stack.top()刚好开合结掉, 就stack.pop().
- 剩下的都是不合理的elements.
- 有点像negatively找 solution: `endIndex - 最后一个failedIndex(stack.pop()) - 1`, 应该就是最后一个succeeded string的长度
- 每次更新 endIndex 为stack.top(), 然后从stack继续找下一个failedIndex
- 所有的length作比较, 就可以找出最长length
- O(n) stack space, O(n) runtime. 应该比dp慢一点, 因为做了2遍O(n)




---

**12. [Expression Tree Build.java](https://github.com/awangdev/LintCode/blob/master/Java/Expression%20Tree%20Build.java)**      Level: Hard      Tags: [Binary Tree, Expression Tree, Minimum Binary Tree, Stack]
      
给一串字符, 表示的是 公式 expression. 把公式变成expression tree

#### Monotonous Stack
- 和Max-tree一样，https://leetcode.com/problems/maximum-binary-tree
- 用到bottom->top递增的stack: 最底下的root维持成最小的element.
- 这个题目是Min-tree， 头上最小，Logic 和max-tree如出一辙   
- Space: O(n) 
- Time on average: O(n).

#### 特点
- TreeNode: 用一个并不是最终结果的TreeNode, 存weight, 用来排序
- 用base weight的概念权衡同一个层面的 符号, 数字 顺序
- 每一个character都是一个节点, 都有自己的weight. 用一个TreeNode来存weight value, 利用用weight来判断: 
- 1. (while loop) 如果node.val <= stack.peek().nodeValue, 把当前stack.peek() 变成 left child. 
- 2. (if condition) 如果stack有残余, 把当前node变成 stack.peek().rightChild 




---

**13. [Evaluate Reverse Polish Notation.java](https://github.com/awangdev/LintCode/blob/master/Java/Evaluate%20Reverse%20Polish%20Notation.java)**      Level: Medium      Tags: [Stack]
      

给一个 RPN string list, 根据这个list, 计算结果.

#### Stack
- stack 里面 存数字
- 每次遇到operator, 都拿前2个数字计算
- 计算结果存回到stack里面, 方便下一轮使用.
- Time,Space O(n)




---

**14. [Implement Queue using Stacks.java](https://github.com/awangdev/LintCode/blob/master/Java/Implement%20Queue%20using%20Stacks.java)**      Level: Easy      Tags: [Design, Stack]
      
#### 双Stack
画图, 知道最后maintain的stack是那个 reverseStack: pop(), peek(), empty() 都在这个stack上, 无需变换.
push()里面做stack和reverseStack的来回倾倒.
相比老的code, 在PUSH里面做倾倒, 更容易读.

#### Previous notes
双Stack. 一个是等于是queue，一个是backfillStack.
Tricky: 是在pop()和peek()的时候backfill, 并且要等到stack用完再backfill.
写一下例子就知道，如果提早backfill，stack.peek()就不是queue的head了.




---

**15. [Basic Calculator.java](https://github.com/awangdev/LintCode/blob/master/Java/Basic%20Calculator.java)**      Level: Hard      Tags: [Binary Tree, Expression Tree, Math, Minimum Binary Tree, Stack]
      
给一个expression String, 要evaluate这个expression的值.

Expression string 里面包括 +, -, 整数, 开合括号, 还有space.

#### Expression Tree
- Expression Tree是一个 weight-based的 min-tree 
- 基于 运算符号 + 数字的 tree: 数字永远在leaf, 然后符号是tree node,  括号不出现在tree里面
- 用 monotonuous stack 来构建这个tree

##### Thinking points
- Understand Expression Tree
- Use stack to build the expression tree + understand the weight system
- Use post-order traversal to evaluate the tree
- 注意, input里面的数字不会是single digit, 所以需要一个buffer存number string
- 整个题目的做法, 可以参照 `Expression Evaluation`



---

**16. [Convert Binary Search Tree to Sorted Doubly Linked List (extra space).java](https://github.com/awangdev/LintCode/blob/master/Java/Convert%20Binary%20Search%20Tree%20to%20Sorted%20Doubly%20Linked%20List%20(extra%20space).java)**      Level: Medium      Tags: [Linked List, Stack, Tree]
      

给一个BST, convert成 sorted doubly DoublyListNode.

#### Inorder Traversal, Linked List
- 会iterative traverse Binary Search Tree（Stack && handle left-dig-down）
- create Doubly-ListNode, 注意用一个dNode作为tail node of the list

##### Iterative inorder traversal
- 在check right node的事后，    
- 不论right == null or != null, 每次都要强行move to right.    
- 如果不node = node.right,     
- 很可能发生窘境：       
- node always  = stack.top(), 然后stack.top()一直是一开始把left 全部遍历的内容。所以就会infinite loop, 永远在左边上下上下。      



---

**17. [Convert Expression to Reverse Polish Notation.java](https://github.com/awangdev/LintCode/blob/master/Java/Convert%20Expression%20to%20Reverse%20Polish%20Notation.java)**      Level: Hard      Tags: [Binary Tree, DFS, Expression Tree, Stack]
      
给一串字符, 用来表示公式expression. 把这个expression转换成 Reverse Polish Notation (RPN).

#### Expression Tree
- Expression Tree: Minimum Binary Tree (https://lintcode.com/en/problem/expression-tree-build/)
- 根据题意做出Expression Tree出来以后: 来个Post-order-traversal 就能记录下 Reverse Polish Notation
- 本题没有给'ExpressionTreeNode', 所以把TreeNode就当做成我们需要的node, 里面扩展成有left/right child就可以了.



---

**18. [Largest Rectangle in Histogram.java](https://github.com/awangdev/LintCode/blob/master/Java/Largest%20Rectangle%20in%20Histogram.java)**      Level: Hard      Tags: [Array, Monotonous Stack, Stack]
      
给n个bar,组成柱状图histogram. 求在这一排柱状图里面可以找到的面积最大的长方形.

思考: 找长方形面积, 无非是找两个index, 然后底边长度 * height.

#### Monotonous Stack
- 重点是根据找Histogram里面rectangle的性质, 维持一个单调递增的Stack
- 在loop over indexes的时候:
- 如果高度>= previous peek(), 那么对于那个peek, 就意味着, 往下走, 一直走高嘛, 之前的peek总可以继续抄底
- 什么时候不能抄底了呢? 就是有一个下降趋势的时候
- 这时候并不是calculate所有前面的peek, 而是考虑 大于 current height的之前所有的peek.
- 把这些peek到 current height 前一格的rectangle全部找出来: stack.pop()
- 这个stack.pop()的过程里面, 其实没有算上 current height, 因为需要留到下一轮, 把current index加进stack 再说
- 为什么用stack? 因为需要知道连续递增的peek, stack.peek() O(1), 好用
  而其实不用stack, 也可以用其他方式记录所有height, 只不过要 O(n)去找peek不方便

#### 知识点
- 理解monotonous stack 是如何被维护的
- 维护monotonous stack 是题目需要, 而不是stack本身性质, 是一种借助 stack.peek() O(1)的巧妙用法.




---

**19. [42. Trapping Rain Water.java](https://github.com/awangdev/LintCode/blob/master/Java/42.%20Trapping%20Rain%20Water.java)**      Level: Hard      Tags: [Array, Stack, Two Pointers]
      

这道题目的方法比较多.

#### Method1: Max wall from both sides
- Array: Left Max Wall vs Right Max Wall.
- 对于每个index而言, vertically 能存放的最大水柱, 就是靠 左 右 最高墙决定的: 
    - min(leftHighestWall, rightHighestWall) - currHeight.
- time: O(n)
- space: O(n)

#### Method2: Two Pointers
- Optimization from Method1: two pointer, 还是找左边最高和右边最高. O(1) space.
- 利用到了方法3里面的想法一样: 整个structure是被中间的最高bar 二分天下:
- always limited by the shorter wall: 左边按照maxLeft来计算, 右边按照maxRight来计算.
- time: O(n)
- space: O(1)

#### Method3: 2 Pointers, start from 2 sides
- 1. 找中间最高bar的index    
- 2. 两面往中心扫：每次加上（topBarIndex - currIndex）* (elevation from previous index).也就是每次加一个横条
- 3. 每次还要减去block自身的height
- time: O(n)
- space: O(1)

#### Method4: Stack
- 主要想法和方法3一致: 在山坡下坡的基础上, 一直用stack堆积bottom. 
- 最后遇到上升之前, 此时bottom可以用来跟stack之前堆积的所有下坡index做比较, 算跟他们高度相差的积水.
- 用了stack记录下坡, 然后用个while loop一挖到底的想法非常棒.
- time: O(n)
- space: O(n)




---

**20. [1021. Remove Outermost Parentheses.java](https://github.com/awangdev/LintCode/blob/master/Java/1021.%20Remove%20Outermost%20Parentheses.java)**      Level: Easy      Tags: [Stack]
      
#### Stack
- use stack to hold potential pair
- when stack is empty: detect outtermost element, dont add to final result
- time: O(n), space O(n)

#### Count occurance
- solution from discussion, time O(n), space O(1)
- save space, but less scalable: think about if there are 100 different pairs, then the couting will be a bit complex to handle.



---

**21. [496. Next Greater Element I.java](https://github.com/awangdev/LintCode/blob/master/Java/496.%20Next%20Greater%20Element%20I.java)**      Level: Easy      Tags: [Hash Table, Stack]
      

#### stack
- use stack to hold all elements
    - keep poping if `stack.peek() < num`
    - use map to record (top, num)
- time O(n), run through base once and sub-sequence once
- space O(n), stack, map

#### HashMap
- O(n) space, O(n^2) time worst case



---

**22. [1249. Minimum Remove to Make Valid Parentheses.java](https://github.com/awangdev/LintCode/blob/master/Java/1249.%20Minimum%20Remove%20to%20Make%20Valid%20Parentheses.java)**      Level: Medium      Tags: [Stack, String]
      

#### Stack
- Goal: remove extra '(' or ')' so it is valid.
- Forward thinking: use stack to track '(' and ')', then keep appending partial string to output
- Backward thinking: use stack to filter out false indexes, and remove them in the end




---

**23. [173. Binary Search Tree Iterator.java](https://github.com/awangdev/LintCode/blob/master/Java/173.%20Binary%20Search%20Tree%20Iterator.java)**      Level: Medium      Tags: [BST, Design, Stack, Tree]
      

#### BST in order traversal
- 用stack记录最小值, 放在top. O(h) space.
- 每次消耗TreeNode, 都看看rightNode(其实就是下一个最小的candidate), 并且一条龙stack叠上rightNode所有的left子孙.

#### Previous Notes:
- 用O(1)空间的做法：不存stack, 时刻update current为最小值。
- 找下一个最小值,
    - 如果current有right child: 和用stack时的iteration类似,那么再找一遍current.right的left-most child,就是最小值了。
    - 如果current没有right child: 那么就要找current node的右上parent, search in BinarySearchTree from root.
- 注意：
    - 一定要确保找到的parent满足parent.left == current.
    - 反而言之，如果current是parent的 right child, 那么下一轮就会重新process parent。
    - 但是有错:binary search tree里面parent是小于right child的，也就是在之前一步肯定visit过，如此便会死循环。




---

**24. [844. Backspace String Compare.java](https://github.com/awangdev/LintCode/blob/master/Java/844.%20Backspace%20String%20Compare.java)**      Level: Easy      Tags: [Stack, Two Pointers]
      

#### Method1: Two pointers to backtack from end of string
- time: O(n)
- space: O(1)

#### Method2: Stack
- need to remove entity just added 
- use stack to hold array content; pop if # is found



---

**25. [1106. Parsing A Boolean Expression.java](https://github.com/awangdev/LintCode/blob/master/Java/1106.%20Parsing%20A%20Boolean%20Expression.java)**      Level: Hard      Tags: [DFS, Stack, String]
      
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

**26. [144. Binary Tree Preorder Traversal.java](https://github.com/awangdev/LintCode/blob/master/Java/144.%20Binary%20Tree%20Preorder%20Traversal.java)**      Level: Medium      Tags: [BFS, DFS, Stack, Tree]
      

#### Recursive, DFS, Divide and conquer
- 加root, left, then right. Obvious
- Option1: recursive on preorderTraversal. the dfs function returns List
- Option2: pass in rst, and write a void dfs.

#### Iterative
- 先加root, 然后push上需要末尾process的在stack垫底(root.right), 然后push root.left
- Stack: push curr, push right, push left.   



---

**27. [20. Valid Parentheses.java](https://github.com/awangdev/LintCode/blob/master/Java/20.%20Valid%20Parentheses.java)**      Level: Easy      Tags: [Stack, String]
      

#### Stack
- 剥皮过程。解铃还须系铃人   
- 左边的外皮'{['在stack底部   
- 右边的外皮应该和stack顶上的左外皮一一对应 



---

**28. [145. Binary Tree Postorder Traversal.java](https://github.com/awangdev/LintCode/blob/master/Java/145.%20Binary%20Tree%20Postorder%20Traversal.java)**      Level: Medium      Tags: [Stack, Tree, Two Stacks]
      

如题, POST-ORDER traversal.

LeetCode给了hard, 应该是觉得stack的做法比较难想到.

#### Method1: DFS, Recursive
- trivial, 先加left recursively, 再加right recursively, 然后组成头部.
- Option1 w/o helper; option2 with dfs helper.

#### Method2, Iterative, Stack
- Option1: reversely add to list
- 双stack的思想, 需要在图纸上画一画
    - 原本需要的顺序是: 先leftChild, rightChild, currNode.
    - 营造一个stack, reversely process: 先currNode, 再rightChild, 再leftChild
    - 这样出来的结果是reverse的, 那么翻转一下就可以了.
- reverse add: `list.add(0, x)`;
- 利用stack的特点
    - 每次加element进stack的时候, 想要在 bottom/后process的, 先加
    - 想要下一轮立刻process的, 最后push进stack.
- Option2: regular sequence add to stack: add curr, right, left
    - Use set to contain the processed children 
    - only process curr if its children is processed




---

**29. [103. Binary Tree Zigzag Level Order Traversal.java](https://github.com/awangdev/LintCode/blob/master/Java/103.%20Binary%20Tree%20Zigzag%20Level%20Order%20Traversal.java)**      Level: Medium      Tags: [BFS, Stack, Tree]
      
    
#### Queue
- 简单的level traversal.根据level奇数偶数而add到不同位子.
- Option1: based on level % 2, insert to front/end of list
- Option2: based on level, insert right/left of node into queue



---

**30. [636. Exclusive Time of Functions.java](https://github.com/awangdev/LintCode/blob/master/Java/636.%20Exclusive%20Time%20of%20Functions.java)**      Level: Medium      Tags: [Stack]
      

#### Stack
- Task time range: 
    - start range = next task timestamp - start.timestamp
    - end range = curr task timestamp - last task timestamp + 1; because end node is inclusive.
- How to think of using stack: a task cannot finish until end is met; a early task cannot stop until a later task ends
    - Alternatively, we can use a hashmap to track as well
- Keep track of the timestamp
- make sure to +1 when end node is met because end task is inclusive to this finishing task




---

**31. [94. Binary Tree Inorder Traversal.java](https://github.com/awangdev/LintCode/blob/master/Java/94.%20Binary%20Tree%20Inorder%20Traversal.java)**      Level: Easy      Tags: [Hash Table, Stack, Tree]
      

Inorder traverse Binary Tree

#### Method1: DFS
- option1: dfs + rst list to carry results
- option2: Divide and Conquer, 在自己的基础上recursive, 不用helper function
- O(n) time

#### Method2: Iterative, Stack inorder traversal
- 1) Add root.leftPath all the way to leaf, 2) process curr 3) Move to right if applicable 4) add all right.leftPath
- O(n) time, O(h) space




---

**32. [402. Remove K Digits.java](https://github.com/awangdev/LintCode/blob/master/Java/402.%20Remove%20K%20Digits.java)**      Level: Medium      Tags: [Greedy, Monotonous Stack, Stack]
      

#### Monotonous Stack (Increasing)
- Greedy: Remove 1) earlier digits(数位靠前权值大), 2) large digits
- Keep a increasing stack that:
    - use stack.peek() to guard incoming digit
    - if peek is larger than incoming digit, continue `stack.pop()`
- Result: monotonous increasing stack. Print it in correct order.




---

**33. [71. Simplify Path.java](https://github.com/awangdev/LintCode/blob/master/Java/71.%20Simplify%20Path.java)**      Level: Medium      Tags: [Stack, String]
      

给一个path, simplify成最简单形式. 注意考虑edge case

#### Stack
- 理解unix path:
    - 1. `.` 代表current directory, 可以忽略. 
    - 2. `../` 表示previous level. 
    - 3. double slash 可以忽略.
    - 4. empty string 要output `/`
- parse by '/', and go over using stack
    - put [folder] in stack
    - ".." pop() 1 element of the stack, if anything
    - "." stays the same
- output stack reversely: connect with '/', skip tail



---

**34. [716. Max Stack.java](https://github.com/awangdev/LintCode/blob/master/Java/716.%20Max%20Stack.java)**      Level: Medium      Tags: [Design, Doubly Linked List, Stack, TreeMap]
      

#### Two Stack
- one to keep regular elements
- one to repat the max at current stack level
- time: O(n) for popMax() and O(1) for the rest operations
- space: O(n)

#### TreeMap
- Reference: https://leetcode.com/problems/max-stack/solution/
- Use TreeMap to store <Int, List of Nodes>, which gives: **O(logN) insert, delete and find MAX**
- Key reason to use `DoubleLinkedList` is to perform O(1) removal for `popMax()`
- The problem becomes finding the target value & remove from DoubleLinkedList
- time: O(1) for popMax() and O(logN) for the rest
- space: O(n)



---

**35. [341. Flatten Nested List Iterator.java](https://github.com/awangdev/LintCode/blob/master/Java/341.%20Flatten%20Nested%20List%20Iterator.java)**      Level: Medium      Tags: [Design, NestedInteger, Stack]
      

#### Method1: Stack holds items from back of the list
- Option1: always set integer on top of the stack everywhere
    - if not, poping stack until the top is integer
    - code is easy
- Option2: in hasNext(), faltten the list in stack

#### Method2: DFS preprocessing.
- 用queue to store all items. Kinda hack. Defeat the purpose of the problem.
- Super fast to query next(), however, needs to holds everything in memory
- O(n)



---

**36. [739. Daily Temperatures.java](https://github.com/awangdev/LintCode/blob/master/Java/739.%20Daily%20Temperatures.java)**      Level: Medium      Tags: [Hash Table, Monotonous Stack, Stack]
      

#### Method1: Monotonous Stack
- Goal: given a index i, want right-side closest & higer number
- Draw example: right-most number at base, and builds up monotonous stack (mountain shape)
    - add smaller item on top of stack
    - keep popping if peek is higher than incoming
- space: O(n), time:O(n)

#### Method2: `Map <fixed value(temperature), Index>`, kinda of like bucket sort
- Refernece: https://leetcode.com/problems/daily-temperatures/solution/
- From right side: 
    - 1) record tempIndex[currTemp] = i; 
    - 2) Brutle find smallest temp index in range [currTemp + 1, 100] and record as result


---

**37. [272. Closest Binary Search Tree Value II.java](https://github.com/awangdev/LintCode/blob/master/Java/272.%20Closest%20Binary%20Search%20Tree%20Value%20II.java)**      Level: Hard      Tags: [Stack, Tree]
      

#### Method1: Stack, DFS, Inorder Traversal
- find successors and predecessors using BST (both list will be sorted); in the end, we can easily get top k from the two sorted list
    - with BST: **inorder traversal gives us sorted predecessors
    - with BST: **reversed-inorder traversal gives us sorted successors
    - smallest on top of the stack
- time: O(n) visit all nodes, O(k) to output
- space overall: O(n) to store all nodes

#### Method2: BFS, brutle force
- Itereate over all nodes and maintain pq<TreeNode> (improvemenet point: how to avoid traversing entire tree?)
- prioritize nodes that are closer to target, so we may stop early when result reaches k candidates
- time: O(n*logn)
- kinds slow and not utilizing BST



---

