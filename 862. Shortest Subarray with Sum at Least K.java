class Solution {
    public int shortestSubarray(int[] A, int K) {
        
        int n = A.length;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + A[i];
        }
        int res = n + 1;
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i <= n; i++) {
            
            while (!deque.isEmpty() && preSum[i] >= preSum[deque.peekFirst()] + K) {
                res = Math.min(res, i - deque.pollFirst());
            } 
            // making increas deque
            while (!deque.isEmpty() && preSum[i] <= preSum[deque.peekLast()]) {
                deque.pollLast();
            }
        
            deque.offer(i);
        }
        return res < n + 1 ?  res : -1;
    }
}