class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Set<Integer>> prereqMap = new HashMap<>(); // course and its prereq course list
        int[] indegree = new int[n];
        
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
            prereqMap.put(i, new HashSet<>());
        }
        
        for (int[] pre : prerequisites) {
            indegree[pre[1]]++;
            graph.get(pre[0]).add(pre[1]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            for (int next : graph.get(curr)) {
                prereqMap.get(next).add(curr);
                prereqMap.get(next).addAll(prereqMap.get(curr)); // 当前node的上级的所有prereq都加进来
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        List<Boolean> res = new ArrayList<>();
        
        for (int[] query : queries) {
            Set<Integer> prereqSet = prereqMap.get(query[1]);
            res.add(prereqSet.contains(query[0]));
        }
        return res;
    }
}