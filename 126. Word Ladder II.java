class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return res;
        }
        dict.add(beginWord);
        Map<String, Integer> distance = new HashMap<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : dict) {
            map.put(s, new ArrayList<>());
        }
       
        List<String> path = new ArrayList<>();
        
        bfs(endWord, beginWord, dict, distance, map);
        dfs(beginWord, endWord, distance, map, path, res);
        return res;
    }
    
    private void bfs(String start, String end, Set<String> dict,  Map<String, Integer> distance, Map<String, List<String>> map) {
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);
        
        while (!queue.isEmpty()) {

                String curr = queue.poll();
                List<String> nextWords = getNextWords(curr, dict);
                for (String next : nextWords) {
                    if (!distance.containsKey(next)) {
                        queue.offer(next);
                        distance.put(next, distance.get(curr) + 1);
                    }
                    map.get(next).add(curr);
                    if (next.equals(end)) {
                        break;
                    }
                }
        }
    }
    
    private List<String> getNextWords(String s, Set<String> dict) {
        
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                if (curr == c) {
                    continue;
                }
                String newWord = s.substring(0, i) + c + s.substring(i + 1);
                if (dict.contains(newWord)) {
                    res.add(newWord);
                }
            }
        }
        return res;
    }
    
    private void dfs(String start, String end,  Map<String, Integer> distance, Map<String, List<String>> map,  List<String> path, List<List<String>> res) {
        
        path.add(start);
        if (start.equals(end)) {
            res.add(new ArrayList<>(path));
        } 
        List<String> nextWords = map.get(start);
        
        for (String next : nextWords) {
             if (distance.containsKey(next) && distance.get(next) + 1 == distance.get(start)) {
                 dfs(next, end, distance, map, path, res);
              }
        }
    
        path.remove(path.size() - 1);
    }
}