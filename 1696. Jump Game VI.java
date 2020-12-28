class Solution {
    public int maxResult(int[] nums, int k) {
        
        // dp + 单调队列
        int n = nums.length;
        int[] score = new int[n];
        score[0] = nums[0];
        Deque<Integer> dq = new ArrayDeque<>(); // 单调递减队列
        dq.offerLast(0);
        
        for (int i = 1; i < n; i++) {
            // pop the old index
            while (!dq.isEmpty() && i - dq.peekFirst() > k) {
              dq.pollFirst();
            }
            score[i] = score[dq.peekFirst()] + nums[i]; // 最大的值在队首
            // 保持单调递减
            while (!dq.isEmpty() && score[dq.peekLast()] <= score[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return score[n - 1];
    }
}