class Solution {
    public int shortestPathLength(int[][] graph) {
        
        if (graph == null || graph.length <= 1) {
            return 0;
        }
        int n = graph.length;
        boolean[][] visited = new boolean[n][1 << n];
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i, 1<<i});
            visited[i][1<<i] = true;
        }
        
        int steps = 0;
        int target = (1 << n) - 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int index = curr[0], state = curr[1];
                
                for (int next : graph[index]) {
                    int nextState = state | (1 << next); 
                    if (nextState == target) {
                        return steps;
                    }
                    if (visited[next][nextState]) {
                        continue;
                    }
                    queue.offer(new int[]{next, nextState});
                    visited[next][nextState] = true;
                }
            }
        }
        return -1;
    }
}