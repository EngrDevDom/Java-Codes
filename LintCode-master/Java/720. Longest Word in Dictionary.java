E
tags: Hash Table, Trie
time: O(nlogn)
space: O(n)

给串word[], 找最长的Word, 满足条件: 这个Word可以从 word[] 里面一个字母一个字母被build出来.

如果多种答案, respect smallest lexicographical order.

#### Sort, HashSet
- 先排序(lexicographically), 排序以后才能逐个看是否partial string已经存在
    - 用 set.contains(substring(0, n - 1)) 来查看上一步的 substring 是否存在
    - 如果找到, 因为已经按照字母表排序, 找到的这个肯定是这个长度里面最符合的解答.
- 然后brutally找下一个更大的.
- Sort O(n log n), O(n) set space

#### Trie
- 可以先sort words Array: 
    - 长 string 排在前;
    - 相等length, 按照dictionary order 排序
- 全部放入Trie. Trie.insert()
    - 针对sorted words array, 从最长的开始找 Trie.startWith.
    - 一旦找到, 就是符合题意的, 直接return.
- 注意: startWith 必须每一个node都是 isEnd, 才满足'逐个字母拼出' 的条件.
- Time: build Trie O(mn) + sort:O(nlogn) => O(nlogn)
- Space: O(mn)

#### 从最长的word开始做
- 按大小排序 -> 从最大的开始做contains()的比较 -> 结果再按照字母表顺序(lexicographically) sort一下.
- 但是Collections.sort()了两次, 而且再list.contains(), 比较慢


```
/*
Given a list of strings words representing an English Dictionary, 
find the longest word in words that can be built one character at a time
by other words in words. 

If there is more than one possible answer, 
return the longest word with the smallest lexicographical order.

If there is no answer, return the empty string.
Example 1:
Input: 
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation: 
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
Example 2:
Input: 
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation: 
Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
Note:

All the strings in the input will only contain lowercase letters.
The length of words will be in the range [1, 1000].
The length of words[i] will be in the range [1, 30].

*/

class Solution {
    public String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }
        String result = "";
        Arrays.sort(words);
        
        Set<String> set = new HashSet<>();
        set.add(result);
        
        for (String word : words) {
            if (set.contains(word.substring(0, word.length() - 1))) {
                if (word.length() > result.length()) {
                    result = word;    
                }
                set.add(word);
            }
        }
        
        return result;
    }
}




/*
Same as above
Thoughts:
1. Sort lexicographically
2. Any new word.substring(0, length-1) should appear before itself in the sorted list
3. save the ongoing matched string in set such that it can be used to do set.contains()
4. maintain a longest result. Go through entire words array.

Note: bacause it's lexicographically sorted, the very first matched word will be the 
exact one we want in this length range. The following step becomes: only look for matched
ones in larger length.
*/



/**
Trie Solution

 */
class Solution {
    class TrieNode {
        public boolean isEnd;
        public Map<Character, TrieNode> children;
        public TrieNode() {
            this.isEnd = false;
            this.children = new HashMap<>();
        }
    }
    TrieNode root;
        
    public String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }
        
        // 1. Longer word is in front. 2. if same length, sort by lexicographically(directory order)
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    return s1.length() > s2.length() ? -1 : 1;
                }
                return s1.compareTo(s2);
            }
        });
        
        root = new TrieNode();
        for (String word : words) {
            insert(word);
        }
        
        for (String word: words) {
            if (startsWith(word)) {
                return word;
            }
        }
        
        return null;
    }

    /** Inserts a word into the trie. */
    private void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }

        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
            if (i == word.length() - 1) {
                node.isEnd = true;
            }
        }
    }

    // skip the search function

    /** Returns if there is any word in the trie that starts with the given prefix. */
    private boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        }
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
            // IMPORTANT: check if the input prefix is word, if not, fail to find word
            if (!node.isEnd) {
                return false;
            }
        }
        return true;
    }
}



/*
竟然是 O(nlogn) + O(nm) + O(nlon), 最差, over complicated
Thoughts:
1. Put arrays in to ArrayList, and Collections.sort(..) by the length
2. Starting from last element && cut off last index && check for exisitance 
3. Save result to ArrayList, and maintain the length of succeeded word as breaking point.
4. sort the result by it's lexicographically.
*/
class Solution {
    public String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList(words));
        Collections.sort(wordList, new Comparator<String>(){
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });

        ArrayList<String> result = matchWords(wordList);
        Collections.sort(result);
        
        if (result.size() != 0) {
            return result.get(0);
        }
        return null;
    }
    
    private ArrayList<String> matchWords(ArrayList<String> wordList) {
        int maxWordLength = Integer.MIN_VALUE;
        ArrayList<String> result = new ArrayList<>();
        for (int i = wordList.size() - 1; i >= 0; i--) {
            String word = wordList.get(i);
            // Validate if word can be built by with wordList
            while(word.length() != 0) {
                if (wordList.contains(word)) {
                    if (word.length() == 1) {
                        if (wordList.get(i).length() < maxWordLength) {
                            return result;
                        } else {
                            result.add(wordList.get(i));
                            maxWordLength = wordList.get(i).length();
                        }
                    }
                    word = word.substring(0, word.length() - 1);
                } else {
                    break;
                }
            }
        }
        return result;
    }
}

```