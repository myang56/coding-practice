class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        // 古城
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            int startWindowIndex = i - k + 1;
            while (!deque.isEmpty() && i - deque.peekFirst() >= k) { // 左出deque，保证当前点到deque的头的窗口就是k - 1, 后面加一个index进去之后，窗口就是k了
                deque.pollFirst(); 
            }
            // 右出queue,保证递减队列
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            
            if (startWindowIndex >= 0) {
                res[startWindowIndex] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}