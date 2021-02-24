class WordDictionary {
    
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
    public WordDictionary() {
       root = new TrieNode(); 
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        
        TrieNode node = root;
        
        for (int i = 0; i < word.length(); i++) {
            
            int index = word.charAt(i) - 'a';
            
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            } 
                node = node.children[index];
            
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        
        return helper(word, root, 0);
    }
    
    private boolean helper(String word, TrieNode node, int depth) {
        
        if (node == null) {
            return false;
        }
        
        if (depth == word.length()) {
            return node.isEnd;
        }
        
        char c = word.charAt(depth);
        
        if (c != '.') {
            return helper(word, node.children[c - 'a'], depth + 1);
        } else {
            
            for (TrieNode next : node.children) {
                if (helper(word, next, depth + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}