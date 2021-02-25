class WordFilter {
    
    class TrieNode {
        TrieNode[] children;
        int index;
        
        public TrieNode() {
            children = new TrieNode[27]; // add {, { if after z
            index = 0;
        }
    }

    TrieNode root;
    // key suffix{prefix
    public WordFilter(String[] words) {
        
    // add "apple{apple", "pple{apple", "ple{apple", "le{apple", "e{apple", "{apple" into the Trie
        root = new TrieNode();
        for (int index = 0; index < words.length; index++) {
            String word = words[index] + "{"; // apple{
            int n = word.length();
            for (int i = 0; i < n; i++) {
                TrieNode curr = root;
                for (int j = i; j < 2 * word.length() - 1; j++) {
                    int pos = word.charAt(j % n) - 'a';
                    if (curr.children[pos] == null) {
                        curr.children[pos] = new TrieNode();
                    }
                    curr = curr.children[pos];
                    curr.index = index;
                }
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        
        TrieNode curr = root;
        String word = suffix + "{" + prefix;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (curr.children[pos] == null) {
                return -1;
            }
            curr = curr.children[pos];
        }
        return curr.index;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */