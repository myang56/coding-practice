class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        
        int n = nums.length;
        int[] sum = new int[n]; // sum[i] local max until i
        int res = nums[0];
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            sum[i] = nums[i];
            if (!deque.isEmpty()) {
                sum[i] += sum[deque.peekFirst()];
            }
            res = Math.max(res, sum[i]);
            if (!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && sum[deque.peekLast()] <= sum[i]) {
                deque.pollLast();
            }
            if (sum[i] > 0) {
                deque.offerLast(i);
            }
        }
        return res;
    }
}