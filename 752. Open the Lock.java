class Solution {
    public int openLock(String[] deadends, String target) {
        
        // bfs level by level
        Set<String> deadendsSet = new HashSet<>(Arrays.asList(deadends));
        
        String start = "0000";
        if (deadendsSet.contains(start)) {
            return -1;
        }
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(target)) {
                    return steps;
                }
                for (int j = 0; j < curr.length(); j++) {
                   for (int k = -1; k <= 1; k += 2) {  // 往上或往下拨
                       char[] ss = curr.toCharArray();
                       ss[j] = (char) ((ss[j] - '0' + k + 10) % 10 + '0'); // 0 减 1 就可以拨到9， 9 + 1 就到了0
                       String next = new String(ss);    
                       if (!visited.contains(next) && !deadendsSet.contains(next)) {
                           visited.add(next);
                           queue.offer(next);
                       }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}