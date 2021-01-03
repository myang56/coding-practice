class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
            // build the graph
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        
        for (int[] pre : prerequisites) {
            map.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[numCourses];
        
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0;
        int[] res = new int[numCourses];
        
        while (!queue.isEmpty()) {
            
            int curr = queue.poll();
            visited[curr] = true;
            res[count] = curr;
            count++;
            
            
            List<Integer> neighbors = map.get(curr);
            for (int next : neighbors) {
                if (visited[next]) {
                    continue;
                }
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return count == numCourses ? res : new int[0];
    }
}