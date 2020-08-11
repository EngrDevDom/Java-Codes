E
1517979387
tags: Bit Manipulation

a^b 是: 不完全加法.
a&b 是: 所有可能的进位. a&b<<1是向左边进位的形态.

Goal: 先a^b裸加, 算出进位; 再把结果和进位裸加, 再算出这一轮的进位; 再..裸价, 算进位....直到进位数==0. 

那么就，首先记录好进位的数字：carry. 然后 a^b 不完全加法一次。然后b用来放剩下的carry, 每次移动一位，继续加，知道b循环为0为止。

在第一回 a ^ b 之后, b 的本身意义就消失. 接下去应该给parameter重新命名.
sum = a ^ b; // sum without adding carries
nextCarry = (a & b) << 1;

用其他variable name 取代 a, b 会更好理解一点.

Bit Operation    
Steps: 
   a & b: 每bit可能出现的进位数       
   a ^ b: 每bit在此次操作可能留下的值，XOR 操作         
   每次左移余数1位，然后存到b, 再去跟a做第一步。loop until b == 0    

(http://www.meetqun.com/thread-6580-1-1.html)

```
/*
Also on LeetCode: Sum of Two Integers. https://leetcode.com/problems/sum-of-two-integers/
Write a function that add two numbers A and B. You should not use + or any arithmetic operators.

Example
Given a=1 and b=2 return 3

Note
There is no need to read data from standard input stream. Both parameters are given in function aplusb, you job is to calculate the sum and return it.

Challenge
Of course you can just return a + b to get accepted. But Can you challenge not do it like that?

Clarification
Are a and b both 32-bit integers?

Yes.
Can I use bit operation?

Sure you can.
Tags Expand 
Cracking The Coding Interview Bit Manipulation


*/

/*
Thoughts:
Wring down truth table for a and b:
a + b on each bit becomes OR operation, exception when they are both 1, where they becomes 0 and add forward to next bit.
- We can use a carryOver
- Use long to hold the result
*/
class Solution {
    public int getSum(int a, int b) {
        int sum = a ^ b; // incomplete sum
        int nextCarry = (a & b) << 1;
        while (nextCarry != 0) {
            int currentCarry = sum & nextCarry;
            sum = sum ^ nextCarry;
            nextCarry = currentCarry << 1;
        }
        return sum;
    }
}

/*
Thought:
    Bit operation. Just to remmeber this problem, doing A+B using bit.
*/
class Solution {
    public int aplusb(int a, int b) {
        int numA = a;
        int numB = b;
        int incompleteSum = 0;
        while (numB != 0) {
            incompleteSum = numA ^ numB;
            numB = (numA & numB) << 1; // carry
            numA = incompleteSum;
        }
        return incompleteSum; // sum completes when the carry in numB is finished.
    }
};


```