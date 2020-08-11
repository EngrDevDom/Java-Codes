M
1528732676
tags: Math, DFS, Sequence DFS, Enumeration

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

```
/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"].

Hint:
Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.

Tags: Math Recursion
Similar Problems: (E) Strobogrammatic Number, (H) Strobogrammatic Number III

*/

class Solution {
    List<String> singleDigitList = new ArrayList<>(Arrays.asList("0", "1", "8"));
    char[][] digitPair = {{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};
    public List<String> findStrobogrammatic(int n) {
        return dfs(n, n);
    }
    
    public List<String> dfs(int n, int max) {
        if (n <= 0) return new ArrayList<String>(Arrays.asList(""));
        if (n == 1) return singleDigitList;
        
        List<String> subList = dfs(n - 2, max);
        List<String> list = new ArrayList<>();
        for (String str : subList) {
            if (n != max) list.add("0" + str + "0");
            for (int i = 1; i < digitPair.length; i++) {
                list.add(digitPair[i][0] + str + digitPair[i][1]);
            }
        }
        return list;
    }
}

/*
Thoughts:
The items will be in three pattern:
1. Single digits: 0, 1, 8
2. Double digits: 00, 11, 88, 69, 96
3. More digits: adding digit-pair on front/tail sides on given digit
Note: validate that '0' appears on front/tail won't be counted.
Recursion untill n reaches 1
*/
class Solution {
    List<String> singleDigitList = new ArrayList<>(Arrays.asList("0", "1", "8"));
    List<String> doubleDigitList = new ArrayList<>(Arrays.asList("00", "11", "88", "69", "96"));
    char[][] digitPair = {{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};
    public List<String> findStrobogrammatic(int n) {
        List<String> result = dfs(n);
        for (int i = 0; i < result.size(); i++) {
            String num = result.get(i);
            if ((Long.parseLong(num) + "").length() != n) {
                result.remove(i);
                i--;
            }
        }
        return result;
    }
    
    public List<String> dfs(int n) {
        List<String> list = new ArrayList<>();
        if (n <= 0) return list;
        if (n == 1) return singleDigitList;
        if (n == 2) return doubleDigitList;
        
        List<String> subList = dfs(n - 2);
        for (String str : subList) {
            for (int i = 0; i < digitPair.length; i++) {
                list.add(digitPair[i][0] + str + digitPair[i][1]);
            }
        }
        return list;
    }
}

/*
Thoughts:
For n, there can be k kinds of combination. Save it to map(n,k-list)
For n+2, there can be x + k-kinds-of-inner-number + y;
Treat n=0,1,2 differently. Then recurse on rest, layer by layer
At end end, do a O(n) scan to remove non-wanted items.
*/
public class Solution {
	private HashMap<String, String> candidate = new HashMap<String, String>();
    public List<String> findStrobogrammatic(int n) {
		List<String> rst = new ArrayList<String>();
		candidate.put("0", "0");
		candidate.put("1", "1");
		candidate.put("8", "8");
		candidate.put("6", "9");
		candidate.put("9", "6");
		rst = searchAndCombine(n);
		for (int i = 0; i < rst.size(); i++) {
			if ((Long.parseLong(rst.get(i))+"").length() != n) {
				rst.remove(i);
				i--;
			}
		}
		return rst;
    }

    public List<String> searchAndCombine(int n) {
    	List<String> list = new ArrayList<String>();
    	if (n <= 0) {
			return list;
		} else if (n == 1) {
			list.add("0");
			list.add("1");
			list.add("8");
			return list;
		} else if (n == 2){
			list.add("69");
			list.add("11");
			list.add("88");
			list.add("96");
			list.add("00");
			return list;
		}else {//n >= 2
			List<String> temp = searchAndCombine(n - 2);
			for (String str : temp) {
				for (Map.Entry<String, String> entry : candidate.entrySet()) {
					list.add(entry.getKey() + str + entry.getValue());
				}
			}
		}
		return list;
    }
}
```