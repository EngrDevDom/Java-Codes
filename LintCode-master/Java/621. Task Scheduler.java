M
tags: Array, Greedy, Enumeration, Queue, PriorityQueue
time: O(n)
space: O(1)

#### PriorityQueue; Greedy
- 正面去做: 
    - count task出现的次数
    - 然后PQ sort Task object in descending order
- 每个section: k slots = n + 1. Same task being n slots apart, meaning one section has n + 1 slots.
    - 目标是穷尽 k, or 穷尽 pq (poll k times, but will save it back to queue if Task # > 0)
    - 如果qp 真的穷尽, break, return count
    - 不然, count += k, where k are just # of idle intervals
- time O(n) + constant time O(xlogx), where x = 26
- extra space O(x) ~ O(1)


#### Array, count frequency, enumerate
- Enumerate to understand: 
    - 1.module tasks in module/section; 
    - 2.Only need sum the intervals/slots, not return actual layout
    - Perfect case: all letters appear identical # times: just line them up separate in order.
    - Real case: task appears different times
- 1. Place maxCount task as header followed with n slots: define (maxCount-1) sections
- 2. For tasks with less # than maxCount# can fill the (maxCount-1) sections; what about the tail section?
- 3. Any task with same maxTask#, of if prior sections all filled, will fill the tail section
- To count overall slots/intervals, come up with this equation:
    - 1. Fixed sections: `(maxCount - 1) * (n + 1)`
    - 2. Plus all repeating maxCount tasks: calculate by couting identical maxCount of them
    - 3. Exception: if the first (max - 1) sections are all filled completely, and we still have extra task (ex: when n is not large enough), then just return tasks.length
- time O(n), space O(1)
- ??? Need to study

```
/*
Given a char array representing tasks CPU need to do. 
It contains capital letters A to Z where different letters represent different tasks.
Tasks could be done without original order. Each task could be done in one interval. 
For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, 
there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example 1:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
Note:
The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].

*/


// Method1: Priority Queue
class Solution {
    class Task {
        public int count, c;
        public Task(int c, int count) {
            this.c = c;
            this.count = count;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null) return 0;
        
        // Prepare priority queue of Task
        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
        int[] taskCount = new int[26];
        for (char c : tasks) taskCount[c - 'A']++;
        for (int i = 0; i < taskCount.length; i++) {
            if (taskCount[i] > 0) pq.offer(new Task(i, taskCount[i]));
        }

        // process queue and count for each section, where k = n + 1 slots
        int count = 0;
        while (!pq.isEmpty()) {
            int k = n + 1; // slots in on section
            Set<Task> tempSet = new HashSet<>();
            while (k > 0 && !pq.isEmpty()) {
                Task task = pq.poll();
                if (task.count > 1) {
                    task.count = task.count - 1;
                    tempSet.add(task);
                }
                count++;
                k--;
            }

            pq.addAll(tempSet); // add valid tasks back to pq
            if (pq.isEmpty()) break;
            count += k; // if k > 0, the section are all filled with idle interval
        }
        return count;
    }
}
// Simplification: Only need the `letter count` to in the priorityQueue
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null) return 0;
        
        // Prepare priority queue of Task count
        PriorityQueue<Integer> pq = new PriorityQueue<>(26, Collections.reverseOrder());
        int[] counts = new int[26];
        for (char c : tasks) counts[c - 'A']++;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) pq.offer(counts[i]);
        }

        // process queue and count for each section, where k = n + 1 slots
        int count = 0;
        while (!pq.isEmpty()) {
            int k = n + 1; // slots in on section
            List<Integer> list = new ArrayList<>();
            while (k > 0 && !pq.isEmpty()) {
                Integer taskCount = pq.poll();
                if (taskCount-- > 1) list.add(taskCount);
                count++;
                k--;
            }

            pq.addAll(list); // add valid task count back to pq
            if (pq.isEmpty()) break;
            count += k; // if k > 0, the section are all filled with idle interval
        }
        return count;
    }
}

// Method2: enumeration and analyaze
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null) return 0;

        int[] count = new int[26];
        for (char c : tasks) count[c - 'A']++;
        Arrays.sort(count); // ascending

        int max = count[25], i = 25;
        while (i >= 0 && count[i] == max) i--;
        int countRepeatedTopTask = 25 - i;

        return Math.max(tasks.length, (max - 1) * (n + 1) + countRepeatedTopTask);
    }
}

```