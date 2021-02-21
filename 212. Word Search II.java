class Solution {
    
    class TrieNode {
        TrieNode[] children;
        String word;
        
        public TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        
        // build trie and dfs 
        List<String> res = new ArrayList<>();
        TrieNode trie = buildTrieNode(words);
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, trie, res);
            }
        }
        return res;
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode node,  List<String> res) {
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '*') {
            return;
        }
        int index = board[i][j] - 'a';
        
        if (node.children[index] == null) {
            return;
        }
        node = node.children[index];
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        
        char c = board[i][j];
        board[i][j] = '*';
        dfs(board, i + 1, j, node, res);
        dfs(board, i - 1, j, node, res);
        dfs(board, i, j + 1, node, res);
        dfs(board, i, j - 1, node, res);
        board[i][j] = c;
    }
    
    private TrieNode buildTrieNode(String[] words) {
        
        TrieNode root = new TrieNode();
        
        for (String w : words) {
            TrieNode node = root;
            for (char c : w.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = w;
        }
        return root;
    }
}