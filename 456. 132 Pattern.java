class Solution {
    public boolean find132pattern(int[] nums) {
        
        // 从右往左递减栈，需要找第二大mid的值，如果当前值小于mid，说明从右往左，已经有第二大的值， 最大值，返回true
        // while当前值大于栈顶，那么把中间值设为mid
        Deque<Integer> stack = new LinkedList<>();
        int mid = Integer.MIN_VALUE; // 第二大
        
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < mid) {
                return true;
            } else {
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    mid = stack.pop();
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }
}