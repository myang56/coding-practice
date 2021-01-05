class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                graph.putIfAbsent(seq.get(i), new ArrayList<>());
                indegree.putIfAbsent(seq.get(i), 0);
                
                if (i > 0) {
                    graph.get(seq.get(i - 1)).add(seq.get(i));
                    indegree.put(seq.get(i), indegree.get(seq.get(i)) + 1);
                }
            }
        }
        
        if (org.length != indegree.size()) {
            return false;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
               queue.offer(key);
            }
        }
        
        int index = 0;
        while (!queue.isEmpty()) {
            
            if (queue.size() > 1) {
                return false;
            }
            int curr = queue.poll();
            if (org[index++] != curr) {
                return false;
            }
            
            for (int next : graph.get(curr)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        return index == org.length;
    }
}