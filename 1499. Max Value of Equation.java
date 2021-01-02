class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        
        // pair key: y - x  value: x
        Deque<Pair<Integer, Integer>> q = new ArrayDeque<>();
        int res = Integer.MIN_VALUE;
        
        for (int[] point : points) {
            
            while (!q.isEmpty() && point[0] - q.peekFirst().getValue() > k) {
              q.pollFirst();
            }
            
            if (!q.isEmpty()) {
                res = Math.max(res, q.peekFirst().getKey() + point[0] + point[1]);
            }
            // y - x 递减队列
            while (!q.isEmpty() && q.peekLast().getKey() < point[1] - point[0]) {
                q.pollLast();
            }
            q.offerLast(new Pair<>(point[1] - point[0], point[0]));
        }
        return res;
    }
}