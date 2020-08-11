 
 
 
## Linked List (34)
**0. [Linked List Cycle II.java](https://github.com/awangdev/LintCode/blob/master/Java/Linked%20List%20Cycle%20II.java)**      Level: Medium      Tags: [Linked List, Math, Two Pointers]
      
LinkedList 里面有 cycle, 找到cycle的起始点(第一个重复出现的element).

#### Slow, fast Pointer
- 快慢指针, O(1)space.
- 1. 确认有cycle后 2. 数学问题:找到开头.
- 当head == slow.next时候， head就是cycle starting point.
- 也就是说，当slow 移动到了那个回溯点，slow.next那个点就刚好是head的那个点...

#### 证明
- 1. 假设慢指针走t步, 快指针走快一倍, 也就是2t.
- 2. 我们假设cycle的长度是Y, 而进入cycle之前的长度为X.
- 3. 假设慢指针走了m圈cycle, 而快指针走了n圈cycle之后, 两个pointer相遇.
- 4. 最终在Y cycle里面的K点相遇, 也就是两个指针都在这最后一圈里面走了K 步.
- 那么:
- t = X + mY + K
- 2t = X + nY + K
- 整合公式: X + K = (n - 2m)Y
- 这里的m和n不过是整数的跑圈数, 也就是说X和K加在一起, 总归是结束cycle. X 和 K 互补
- 结论: 当slow/fast 指针在K点相遇后, 再走X步, 就到了cycle的起点, 也就是题目要求的起点.

#### Hash Table, O(n) space




---

**1. [Two Lists Sum.java](https://github.com/awangdev/LintCode/blob/master/Java/Two%20Lists%20Sum.java)**      Level: Medium      Tags: [Linked List]
      
给两个Linked list, sum up and 合成新的list



---

**2. [Rotate List.java](https://github.com/awangdev/LintCode/blob/master/Java/Rotate%20List.java)**      Level: Medium      Tags: [Linked List, Two Pointers]
      
给一个single linked list, 右移k steps. k non-negative.

#### Linked List basics
- 记得用dummy.next来存head.
- 特殊: 这里k可能大于list总长. 写一写linked node 移动的步数, 然后 k = k % n.
- 找到newTail, newHead, 然后利用dummy, 换位子



---

**3. [Swap Nodes in Pairs.java](https://github.com/awangdev/LintCode/blob/master/Java/Swap%20Nodes%20in%20Pairs.java)**      Level: Medium      Tags: [Linked List]
      
#### enumurate 
基本原理, 写出来, 然后连线:
pre -> A -> B -> C -> ...
需要一个虚拟 preNode做起始node, 不然无法把后面的node换到开头.

#### 注意
用dummy = pre作为head前一格.
用 `pre.next == null && pre.next.next` 来check是否为NULL.
pre.next.next 保证了至少有一次swap.



---

**4. [Sort List.java](https://github.com/awangdev/LintCode/blob/master/Java/Sort%20List.java)**      Level: Medium      Tags: [Divide and Conquer, Linked List, Merge Sort, Sort]
      
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

**5. [Reverse Linked List II .java](https://github.com/awangdev/LintCode/blob/master/Java/Reverse%20Linked%20List%20II%20.java)**      Level: Medium      Tags: [Linked List]
      
reverse 一个 linked list 中  [m ~ n] 的一部分.

#### Reverse linked list
- 在基本的reverse linked list 上面 多了一层: 找到front node,  接下来的 [m ~ n] node 需要被reverse
- 只需要reverse中间的部分.
- Reverse的时候: 用一个dummyNode, 这道题里面, 其实就用 nodeFront, 那么 dummy.next 就是整个reversed list.

##### 注意
- 一定要Mark开头的那个mth node, 最后用它接上 剩下node tail. 不然后面的node会断掉

#### Previous notes
- 遍历到M前，
- 存一下那个点，
- 从M开始， for loop， reverse [m~n]。 然后把三段链接在一起。




---

**6. [Reorder List.java](https://github.com/awangdev/LintCode/blob/master/Java/Reorder%20List.java)**      Level: Medium      Tags: [Linked List]
      
给一个Linked list, reorder: 从head/tail 两个方向 向中间进发, re-order like: one node at a time,

#### Linked List 功能大集合
- reverse list, find mid of list, merge two list
- 先find mid, 然后把 mid.next reverse了, 最后merge 两段.
- 注意, 用完mid.next之后, 一定要 mid.next = null, 不然merge会出问题



---

**7. [Majority Number III.java](https://github.com/awangdev/LintCode/blob/master/Java/Majority%20Number%20III.java)**      Level: Medium      Tags: [Hash Table, Linked List]
      
TODO: 
1. hash table solution not passing
2. Find O(n) solution

#### Hash Table
- 与其他Majority Number一样。
- 出现次数多余1/k，就要分成k份count occurance.用HashMap。 存在的+1；不存在map里的，分情况:    
- 若map.size() == k,说明candidate都满了，要在map里把所有现存的都-1；
- 若map.size() < k, 说明该加新candidate，那么map.put(xxx, 1);
- 最后在HashMap里找出所留下的occurance最大的那个数。
- 但这样的worst case是 O(nk)



---

**8. [Partition List.java](https://github.com/awangdev/LintCode/blob/master/Java/Partition%20List.java)**      Level: Medium      Tags: [Linked List, Two Pointers]
      
#### Linked List
- linked list 不能像partitioin array一样从两边遍历
- 把小于value的加在前半段, 把 >= value的加在后半段
- 做法很普通: 建造两个list, midTail pointer, post pointer
- 把满足条件（<x, >=x）的数字分别放到两个list里面
- 记得用dummyNode track head.
- 最终midTail.next = post链接起来。



---

**9. [Remove Duplicates from Unsorted List.java](https://github.com/awangdev/LintCode/blob/master/Java/Remove%20Duplicates%20from%20Unsorted%20List.java)**      Level: Medium      Tags: [Linked List]
      
基本方法: O(n) sapce, time
遍历。
遇到duplicate(可能多个),  while直到node.next不是duplicate.
接下去,既然不是duplicate,那就add 进 set


如果不用extra memory, do it in place:
那就要sort linked list. 用merge sort.

复习merge sort:
1. find middle.
2. recursively: right = sort(mid.next); left = sort(head).
3. within sort(), at the end call merge(left, right)


---

**10. [Remove Duplicates from Sorted List II.java](https://github.com/awangdev/LintCode/blob/master/Java/Remove%20Duplicates%20from%20Sorted%20List%20II.java)**      Level: Medium      Tags: [Linked List]
      
从Linked list 里面摘掉重复元素: 只要重复过, 全部都删掉; 重复出现过得元素一个不留.

#### Linked List
- sorted list, 重复元素都在一起
- 运用 dummyHead: 如果要去掉所有重复元素, 就要有个dummyHead作为局外人在开头牵线
- 只要发现一个 node.val == node.next.val, 就记下这个duplicated val, move forward, 过掉所有重复过的元素
- 思想:
- 用第二个 inner while loop, 把所有的重复元素都处理干净, 然后再move forward
- 优点: outter while loop 不需要考虑太多case, 在inner loop 都把主要的business logic 解决了.

##### 注意DummyHead 的使用
- 当我们有了DummyHead 作为Linked List 的局外线头, 其实可以选择每次遇到duplicate, 就把更加后面的元素 强行assign 给 dummyHead.next 
- 下面还尝试过一种做法: 但是需要考虑的edge case 太多了: 不断移动node, 知道不重复, assign prev.next = node. 
- 这样的做法比较直白, 但是需要考虑很多edge case, 而且并没有很好利用到 dummy head, 注意规避.

##### Previous Note
- 斩草除根。
- 多个node，check node.next ?= node.next.next




---

**11. [Add Two Numbers II.java](https://github.com/awangdev/LintCode/blob/master/Java/Add%20Two%20Numbers%20II.java)**      Level: Medium      Tags: [Linked List]
      
Singly-linked list需要reverse, 用stack.
最终结果要恢复成input list 那样的sequence方向, 用stack一个个pop()刚好就可以做到.

加法都一样:
   1. sum = carry
   2. carry = sum / 10
   3. sum = sum % 10;



---

**12. [Insertion Sort List.java](https://github.com/awangdev/LintCode/blob/master/Java/Insertion%20Sort%20List.java)**      Level: Medium      Tags: [Linked List, Sort]
      
input一串数字, 需要出sorted output. 每次insert一个数字时, 都要放到正确的sorted的位置

每次insertion的时候, 都从input里面减掉这个数字

#### Linked List
- 把list里面每个元素都拿出来，scan and insert一遍
- Time O(n^2), worst case, 每次放入n个数字里面的element, 刚好都是最大的
- 所以每次要traverse n nodes, 然后走n次

##### 思考方法
- 如果已经有个sorted list, insert一个element进去。怎么做？
- while 里面每个元素都小于 curr, keep going
- 一旦curr在某个点小了，加进去当下这个空隙。



---

**13. [Convert Sorted List to Binary Search Tree.java](https://github.com/awangdev/LintCode/blob/master/Java/Convert%20Sorted%20List%20to%20Binary%20Search%20Tree.java)**      Level: Medium      Tags: [BST, DFS, Divide and Conquer, Linked List]
      
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

**14. [Convert Binary Search Tree to Sorted Doubly Linked List (extra space).java](https://github.com/awangdev/LintCode/blob/master/Java/Convert%20Binary%20Search%20Tree%20to%20Sorted%20Doubly%20Linked%20List%20(extra%20space).java)**      Level: Medium      Tags: [Linked List, Stack, Tree]
      

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

**15. [[lint]. Nth to Last Node in List.java](https://github.com/awangdev/LintCode/blob/master/Java/[lint].%20Nth%20to%20Last%20Node%20in%20List.java)**      Level: Easy      Tags: [Linked List, Lint]
      
#### Linked List
- 先找到nth node
- 然后head开始跑
- node 到底，而head ~ node刚好是 n 距离。所以head就是要找的last nth



---

**16. [21. Merge Two Sorted Lists.java](https://github.com/awangdev/LintCode/blob/master/Java/21.%20Merge%20Two%20Sorted%20Lists.java)**      Level: Easy      Tags: [Linked List]
      

如题

#### Basics
- 小的放前。每次比head大小 
- while过后，把没完的list一口气接上。   
- 一开始建一个node用来跑路, 每次都存node.next = xxx。存一个dummy。用来return dummy.next.



---

**17. [237. Delete Node in a Linked List.java](https://github.com/awangdev/LintCode/blob/master/Java/237.%20Delete%20Node%20in%20a%20Linked%20List.java)**      Level: Easy      Tags: [Linked List]
      
Given Singlely linked list, 删除一个任意node (不能是head node)

#### Basic
- update node.val
- Link curr.next to curr.next.next



---

**18. [142. Linked List Cycle II.java](https://github.com/awangdev/LintCode/blob/master/Java/142.%20Linked%20List%20Cycle%20II.java)**      Level: Medium      Tags: [Cycle Detection, Linked List, Slow Fast Pointer, Two Pointers]
      

#### Slow Fast Pointers
- find slow/fast to detect the meeting point
- find begin node of the cycle: traverse from head, also move slow; utill head/slow meets slow



---

**19. [83. Remove Duplicates from Sorted List.java](https://github.com/awangdev/LintCode/blob/master/Java/83.%20Remove%20Duplicates%20from%20Sorted%20List.java)**      Level: Easy      Tags: [Linked List]
      
从Linked list 里面摘掉重复元素, 只留下unique元素.

#### Linked List
- sorted list, 重复元素都在一起
- 知道如何构建Linked List.
- 一点遇到重复元素: node.val == node.next.val, 就去掉.
- 用一个dummy node 来跑路
- 注意:
- 只有当没有重复的时候, 才node = node.next; 
- 有重复的时候, 当后面第三个元素被提上来之后, 还是可能跟当下元素重复, 所以不能前移node.
- ex: A -> A -> A
- while loop 里面check node 和 node.next 比较好, 这样ending position会非常清晰



---

**20. [203. Remove Linked List Elements.java](https://github.com/awangdev/LintCode/blob/master/Java/203.%20Remove%20Linked%20List%20Elements.java)**      Level: Easy      Tags: [Linked List]
      
从linked list 里面去掉所有的 target

#### Basics
- 如果match: node.next = head.next;
- 如果不match, node 和 head 一起移动



---

**21. [19. Remove Nth Node From End of List.java](https://github.com/awangdev/LintCode/blob/master/Java/19.%20Remove%20Nth%20Node%20From%20End%20of%20List.java)**      Level: Medium      Tags: [Linked List, Two Pointers]
      

#### Two Pointer
- 1 end pointer to define the window based n steps
- 1 pre pointer to track the node before the targeting node
- when end reaches null, remove nth node: link pre and head.next 



---

**22. [206. Reverse Linked List.java](https://github.com/awangdev/LintCode/blob/master/Java/206.%20Reverse%20Linked%20List.java)**      Level: Easy      Tags: [Linked List]
      
#### Iterative
- Linked List的基本操作: 每次insert在开头
- 用head来循环所有node
- 不需要额外空间
- Time O(n), Space O(1)

#### Recursive with a helper function
- source node: head
- target node: new head



---

**23. [141. Linked List Cycle.java](https://github.com/awangdev/LintCode/blob/master/Java/141.%20Linked%20List%20Cycle.java)**      Level: Easy      Tags: [Cycle Detection, Linked List, Slow Fast Pointer, Two Pointers]
      

#### Method1: Two Pointer: Slow Fast Pointer
- Imagine two runners running on a track at different speed. What happens when the track is actually a circle?
- https://leetcode.com/problems/linked-list-cycle/solution/
- O(1) sapce: 用快慢指针, `start=head.next`, `end=head.next.next`
- Fast pointer will eventually catch up to slow pointer

#### Method1: Hash Table
- O(n) space: 用HashMap，一直add elements.  如果有重复，那么很显然是有Cycle



---

**24. [369. Plus One Linked List.java](https://github.com/awangdev/LintCode/blob/master/Java/369.%20Plus%20One%20Linked%20List.java)**      Level: Medium      Tags: [Linked List]
      

#### Reverse to make significant digit at tail
- Need add from the back and calculate carry
- Reverse list, so insignificant digit at head; calculate carry
- Reverse back when output



---

**25. [146. LRU Cache.java](https://github.com/awangdev/LintCode/blob/master/Java/146.%20LRU%20Cache.java)**      Level: Medium      Tags: [Design, Doubly Linked List, Hash Table, Linked List]
      

#### Double Linked List
- 用了一个特别的双向的ListNode，有了head和tail，这样就大大加快了速度
- 主要加快的就是那个‘更新排位’的过程，找到item hashmap O(1), 做减法换位也都是O(1)
- Overall O(1)
- 巧妙点
    - 1. head和tail特别巧妙：除掉头和尾，和加上头和尾，都O(1)
    - 2. remove node: 把node.pre和node.next 连起来, node就自然而然的断开不要了
- 一旦知道怎么解决了，就不是很特别，并不是难写的算法
- moveToHead()    
- insertHead()    
- remove()

#### Deque, less efficient
- Instead of building `Double Linked List`, utilize Java `Deque<E> queue = new LinkedList<>()`
- works but problem: `queue.remove(E)` is O(n)
- time: O(1) on average but much slower



---

**26. [234. Palindrome Linked List.java](https://github.com/awangdev/LintCode/blob/master/Java/234.%20Palindrome%20Linked%20List.java)**      Level: Easy      Tags: [Linked List, Two Pointers]
      

#### Reverse Linked List
- Palindrome概念很简单: 两边回溯相等. However: 
    - 1) cannot random access index on linkded list
    - 2) cannot reverse iterating linked list
- solution: reverse linked list: 遍历接开头
    - 1) 用快慢指正找到mid point
    - 2) reverse 2nd half
    - 3) compare leftList and rightList
- Time O(n), 而且不需要用额外的空间(只是调换半个list的内部顺序), 所以空间O(1)



---

**27. [876. Middle of Linked List.java](https://github.com/awangdev/LintCode/blob/master/Java/876.%20Middle%20of%20Linked%20List.java)**      Level: Easy      Tags: [Linked List]
      
找Linked List的中间node

#### 快慢指针
- 不在乎slow是不是到底，因为fast肯定先到。
- 确保fast, fast.next不是Null就好



---

**28. [2. Add Two Numbers.java](https://github.com/awangdev/LintCode/blob/master/Java/2.%20Add%20Two%20Numbers.java)**      Level: Medium      Tags: [Linked List, Math]
      

LinkedList都已经反转好了，直接做. 跟Add Binary的理解方式一模一样.

#### Math, Linked List
- reverse order helps calculation
    - add additional carry to end
    - not same length: align on left
- traverse till both ends
- 遍历两个l1,l2把carry-on处理好，每次生成一个新node，最后检查carry-on.




---

**29. [23. Merge k Sorted Lists.java](https://github.com/awangdev/LintCode/blob/master/Java/23.%20Merge%20k%20Sorted%20Lists.java)**      Level: Medium      Tags: [Divide and Conquer, Heap, Linked List, Merge Sort, PriorityQueue]
      

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

**30. [430. Flatten a Multilevel Doubly Linked List.java](https://github.com/awangdev/LintCode/blob/master/Java/430.%20Flatten%20a%20Multilevel%20Doubly%20Linked%20List.java)**      Level: Medium      Tags: [DFS, Linked List]
      

#### DFS
- Depth-first:
    - 1) process curr.child, return tailChild
    - 2) connect tailChild.next = curr.next
- function: link(Node a, Node b);



---

**31. [160. Intersection of Two Linked Lists.java](https://github.com/awangdev/LintCode/blob/master/Java/160.%20Intersection%20of%20Two%20Linked%20Lists.java)**      Level: Easy      Tags: [Linked List]
      
给两个 linked list, 问从哪个node开始, 两个 linked list 开始有重复?

#### Basics
- 长短list，找重合点
- 长度不同的话，切掉长的list那个的extra length
- 那么起点一样后，重合点就会同时到达
- Time O(n) * 2, constant space



---

**32. [138. Copy List with Random Pointer.java](https://github.com/awangdev/LintCode/blob/master/Java/138.%20Copy%20List%20with%20Random%20Pointer.java)**      Level: Medium      Tags: [Hash Table, Linked List]
      

deep copy linked list. linked list 上有random pointer to other nodes.

#### HashMap, Linked List, time, space: O(n)
- Basic Implementation of copy linked list:
    - use a iterator node to iterate over the list: 遍历head.next .... null.    
    - use a dummy node to hold reference to the iterator node.
- Map<original, new node>: 1. avoid creating same node; 2. return the new node if existing
    - 每一步都check map里面有没有head. 没有? 加上
    - 每一步都check map里面有没有head.random. 没有? 加上
- Note, there is a way to skip the extra map O(n): https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43491/A-solution-with-constant-space-complexity-O(1)-and-linear-time-complexity-O(N)
    - However, creating a deep clone of the list is already O(n) extra space, so it is NOT effectively O(1) w/o map
    - It may be beneficial, if we can not hold all nodes in memory, then the approach w/o map is more applicable.



---

**33. [426. Convert Binary Search Tree to Sorted Doubly Linked List.java](https://github.com/awangdev/LintCode/blob/master/Java/426.%20Convert%20Binary%20Search%20Tree%20to%20Sorted%20Doubly%20Linked%20List.java)**      Level: Medium      Tags: [BST, DFS, Divide and Conquer, Linked List, Tree]
      

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

