fclass Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        
        List<List<int[]>> graph = new ArrayList();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList());
        }
        
        for (int[] time : times) {
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }
        
        pq.offer(new int[]{K, 0});
        Set<Integer> visited = new HashSet();
        // visited.add(K);
        
        int dist = 0;
        
        while (!pq.isEmpty()) {
            
            int[] curr = pq.poll();
            
            if (visited.contains(curr[0])) {
                continue;
            }
            visited.add(curr[0]);
            dist = curr[1];
        
            // check next 
            for (int[] next : graph.get(curr[0])) {
                
                if (!visited.contains(next[0])) {
                    pq.offer(new int[]{next[0], next[1] + dist});
                }
                
            }    
        }
        return visited.size() == N? dist : -1;
    }
}