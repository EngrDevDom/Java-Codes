H
tags: DP, Partition DP, Enumeration
time: O(n)
space: O(n)

给出一串数字, 要翻译(decode)成英文字母. [1 ~ 26] 对应相对的英文字母. 求有多少种方法可以decode.

其中字符可能是 "*", 可以代表 [1 - 9]

#### DP
- 乘法原理, 加法原理
    - 跟decode way I 一样, 加法原理, 切割点时: 当下是取了 1 digit 还是 2 digits 来decode
    - 定义dp[i] = 前i个digits最多有多少种decode的方法. new dp[n + 1].
- 不同的情况是: 每一个partition里面, 如果有"*", 就会在自身延伸出很多不同的可能
- 那么: dp[i] = dp[i - 1] * (#variations of ss[i]) + dp[i - 2] * (#variations of ss[i,i+1])
- Enumeration: 
    - 具体分析 '*' 出现的位置, 枚举出数字, 基本功. 
    - 注意!!题目说 * in [1, 9].   (如果 0 ~ 9 会更难一些)
    - 枚举好以后, 其实这个题目的写法和思考过程都不难
- Mode:
    数字太大, 取mod来给最终结果: 其实在 10^9 + 7 这么大的 mod 下, 大部分例子是能通过的.


#### DFS + memoization
- DFS top-down approach is used to analyze the problem. The logic flow:
- 1) consider the case of 1 letter or 2 letters.
- 2) one letter:
    - [*]: + 9 * dfs(s, i + 1)
    - [0~9]: + dfs(s, i + 1)
- 3) two letters:
    - [_, *]: depends
    - [*, _]: depends
    - [*, *]: + 15 * dfs(s, i + 2)
- memo[i] records # of ways to decode from [i ~ n]
- space: O(n), Size of recursion tree can go upto n
- time: O(n), `memo array is filled exactly once`!!!

```
/*
A message containing letters from A-Z is being encoded to numbers using the following mapping way:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.

Given the encoded message containing digits and the character '*', return the total number of ways to decode it.

Also, since the answer may be very large, you should return the output mod 109 + 7.

Example 1:
Input: "*"
Output: 9
Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
Example 2:
Input: "1*"
Output: 9 + 9 = 18
Note:
The length of the input string will fit in range [1, 105].
The input string will only contain the character '*' and digits '0' - '9'.
*/


/*
Thoughts:
dp[i]: # ways to decode the first i digits
Carefully handle *: 
Single digit: either regular number (1 way) or * (9 ways)
Double digit:
1. [0, *] : 0 ways
2. [1, *] : 9 ways
3. [2, *] : 6 ways
Write a function to calculate the variations

dp[i] += dp[i - 1] * # of variations
*/
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length(), mod = 1000000007;
        
        char[] ss = s.toCharArray();
        long[] dp = new long[n + 1];
        dp[0] = 1; // need use 1 as base for calculating product
        
        for (int i = 1; i <= n; i++) {
            dp[i] += dp[i - 1] * countSingle(ss[i - 1]);
            if (i >= 2) dp[i] += dp[i - 2] * countDouble(ss[i - 2], ss[i - 1]);
            dp[i] %= mod;
        }
        
        return (int)dp[n];
    }

    // count single digit variations
    private int countSingle(char c) {
        if (c == '*') return 9; // 9 ways
        if (c == '0') return 0; // not applicable
        return 1; // regular char
    }
    
    // enumerate a
    private int countDouble(char a, char b) {
        // eliminate invalid cases for a
        if (a == '0' || (a >= '3' && a <= '9')) return 0; // not applicable to build 2-digit. a must be in [1, 2]
        
        // enumerate a == 1, a == 2
        if (a == '1') return b == '*' ? 9 : 1; // b can be *=[1~9] or one of [0~9]
        if (a == '2') { // b can be *=[1~6] or one of [0~6]
            if (b == '*') return 6;
            if (b <= '6') return 1;
            return 0;
        }
        
        // now a == *
        if (b >= '0' && b <= '6') return 2; // 1[b], 2[b]
        if (b >= '7' && b <= '9') return 1; // 1[b]
        
        // if ab = '**', there are ab=1[1~9], ab=2[1~6] => 15 ways
        return 15;
    }
}
```