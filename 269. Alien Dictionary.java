class Solution {
    public String alienOrder(String[] words) {
        
        Map<Character, Set<Character>> graph = new HashMap<>();
        // build graph
        // build node
        for (String w : words) {
            for (int i = 0; i < w.length(); i++) {
                graph.putIfAbsent(w.charAt(i), new HashSet<>());
            }
        }
        // build edge
        for (int i = 0; i < words.length - 1; i++) {
            int index = 0;
            // 两两对比
            while (index < words[i].length() && index < words[i + 1].length()) {
                if (words[i].charAt(index) != words[i + 1].charAt(index)) {
                    graph.get(words[i].charAt(index)).add(words[i+1].charAt(index));
                    break; 
                }
                index++;
            }
            // deal with edge case ["abc", "ab"]
            if (index == Math.min(words[i].length(), words[i + 1].length())) {
               if (words[i].length() > words[i + 1].length()) {
                   return "";
               }
            }
        }
        // indegree 
        Map<Character, Integer> indegree = new HashMap<>();
        for (char u : graph.keySet()) {
            indegree.put(u, 0);
        }
                
        for (char u : graph.keySet()) {
            for (char v : graph.get(u)) {
                indegree.put(v, indegree.get(v) + 1);
            }
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>();
        
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                pq.offer(c);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char curr = pq.poll();
            sb.append(curr);
            
            // check neighbors
            for (char next : graph.get(curr)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    pq.offer(next);
                }
            }
        }
        if (sb.length() != indegree.size()) {
            return "";
        }
        return sb.toString();
    }
}