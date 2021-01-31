class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        
        // BFS 找最短路径
        int n = watchedVideos.size();
        Map<String, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(id);
        visited[id] = true;
        
        // 得到在level层的id
        while (!queue.isEmpty() && level > 0) {
            
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                
                // check neighbors
                for (int next : friends[curr]) {
                    if (visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    queue.offer(next);
                }
            }
           level--;
        }
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (String video : watchedVideos.get(curr)) {
                map.put(video, map.getOrDefault(video, 0) + 1);
            }
        }
        List<String> res = new ArrayList<>(map.keySet());
        res.sort((a, b)-> map.get(a) == map.get(b) ? a.compareTo(b) : map.get(a) - map.get(b));
        return res;
    }
}