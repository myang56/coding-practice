class Trie {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        
        public TrieNode() {
          children = new TrieNode[26];
          isEnd = false;
        }
    }
    
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
       root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        TrieNode node = root;
        for (char c : word.toCharArray()) {
       
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
         TrieNode node = root;
        for (char c : prefix.toCharArray()) {
           if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }
}