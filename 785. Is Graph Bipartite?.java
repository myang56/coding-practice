class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int[] colors = new int[graph.length]; // 0 1 -1
        
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length > 0 && colors[i] == 0) {
                
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                colors[i] = 1; // mark as visited
                
                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    
                    for (int next : graph[curr]) {
                        if (colors[next] == 0) {
                            colors[next] = -colors[curr];
                            queue.offer(next);
                        } else {
                            if (colors[next] == colors[curr]) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}