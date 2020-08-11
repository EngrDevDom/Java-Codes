M
tags: Design, Trie

Implement Tire, 也即是 Prefix Tree. 做三个function: insert, search, startWith

#### Trie
- Trie Structure: 
    - trace the char to children node: Map<char, TrieNode>
    - boolean isEnd to indicate if there is string end with this node
    - `TrieNode {boolean isEnd; Map<Character, TrieNode> children}`.
- No need to store letter c in TrieNode
- HashMap构建Trie. Trie三个Method:
- 1. Inset: 加 word   
- 2. Search: 找word    
- 3. StartWith: 找prefix    

##### 特点
- 只有两条children的是binary tree. 那么多个children就是Trie
- 那么没有left/right pointer怎么找孩子？   
- 用HashMap，以child的label为Key，value就是child node。 HashMap走位   

##### 其他
- node里的char在这是optional. 只要在每个TrieNode里面用map存储向下分布的children就好了.  
- 另外有种题目，比如是跟其他种类的search相关，在结尾要return whole string，就可以在node里存一个up-to-this-point的String。

##### Previous Note
- 如果是遇到一个一个字查询的题，可以考虑一下。
- 构建TrieNode的时候要注意：如何找孩子？如果是个map的话，其实就挺好走位的。
- 而且，每个node里面的 char 或者string有时候用处不大，
- 可以为空。但是有些题目，比如在结尾要return一些什么String，就可以在end string那边存一个真的String。



```
/**
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
*/
/*
Trie Structure: 
- trace the char to children node: Map<char, TrieNode>
- boolean isEnd to indicate if there is string end with this node
*/
class Trie {
    class TrieNode {
        boolean isEnd = false;
        Map<Character, TrieNode> children = new HashMap<>();
    }
    
    /** Initialize your data structure here. */
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = findNode(word);
        if (node == null || !node.isEnd) return false;
        return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = findNode(prefix);
        return node != null;
    }
    
    private TrieNode findNode(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            if (!node.children.containsKey(c)) return null;
            node = node.children.get(c);
        }
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
```