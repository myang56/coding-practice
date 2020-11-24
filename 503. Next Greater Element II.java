class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Deque<Integer> stack = new LinkedList<>(); // 存index，解决重复元素问题
        int n = nums.length;
        int[] res = new int[n];
        
        // 因为是circualr，所以这里需要扫两遍, 从后往前扫，如果当前值大于栈顶就pop出来，这样每次栈顶都是当前值的next greater
        for (int i = 2 * n - 1; i >= 0; i--) {
            
            while (!stack.isEmpty() && nums[i % n] >= nums[stack.peek()]) {
                stack.pop();
            }
            res[i % n] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.push(i % n);
        }
        return res;
    }
}