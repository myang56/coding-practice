class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> dict = new HashSet<>(wordList);
        
        if (!dict.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int len = 0;
        
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            len++;
            
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endWord)) {
                    return len;
                }
                List<String> neighbors = getNextWords(curr, dict);
                for (String next : neighbors) {
                    if (visited.contains(next)) {
                        continue;
                    }
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }
        return 0;
    }
    
    private List<String> getNextWords(String s, Set<String> dict) {
        
        List<String> res = new ArrayList<>();
        char[] ss = s.toCharArray();
        
        for (int i = 0; i < ss.length; i++) {
            char curr = ss[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (curr == c) {
                    continue;
                }
                ss[i] = c;
                String newWord = new String(ss);
                if (dict.contains(newWord)) {
                    res.add(newWord);
                }
            }
            ss[i] = curr;
        }
        return res;
        
    }
}