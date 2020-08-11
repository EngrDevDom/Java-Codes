M
1517465602
tags: Two Pointers, Array, Sort

1. Similar to 15. 3Sum, but simpler.
1. 只需要count triplet, 但是不需要save triplet, 而且还不需要handle duplicated triplets
1. 发现start, end满足条件时候，(end - start)就是所有 sum <target的情况了。
1. 而一旦 > target, 那么就end--
1. 两层循环, O(n2)

```
/*
Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n 
that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2:

[-2, 0, 1]
[-2, 0, 3]

Follow up:
Could you solve it in O(n2) runtime?

Tags: Array Two Pointers
Similar Problems:(M) 3Sum, (M) 3Sum Closest

*/

/*
Thoughts:
For loop over initial selection. Have 2sum solution within (2 pointer).
When < target, count+= end-start, start++.
When >= target, end--.
*/
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) { // first num, num[i] is the fixed item
            int start = i + 1, end = nums.length - 1;  // move start, end
            while (start < end) {
                if (nums[i] + nums[start] + nums[end] < target) {
                    count += end - start;
                    start++;
                } else {
                    end--;
                }
            }
        }
        return count;
    }
}

/*
Thoughts:
Similar to 3 sum, but ofcourse, this one check on '<' so we can not use HashMap anymore.
Basic concept is to fix first number, then check for the rest two numbers, see if they addup < target.
When checking j and k, realize something nice:
	if nums[j] + nums[k] < target - nums[i], that means for all index <= k will work, so directly add (k - j) to result (that's: index = j+1, j+2, ....,k)
	also, move j forward for next round.
OR, if three-add-up >= target, since j can only increase, we do k-- to make the three-add-up smaller

Note:
Don't forget to sort, otherwise the sequence/order is unpredictable
*/
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length <= 2) {
        	return 0;
        }
        Arrays.sort(nums);
        int rst = 0;
        for (int i = 0; i < nums.length - 2; i++) {
        	int j = i + 1; 
        	int k = nums.length - 1;
        	while (j < k) {
        		if (nums[i] + nums[j] + nums[k] >= target) {
        			k--;
        		} else {
        			rst += (k - j);
        			j++;
        		}
        	}
        }//END for
        return rst;
    }
}
```