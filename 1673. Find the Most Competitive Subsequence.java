class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        
        // 返回长度为k的单调递增栈
        // 如果当前值比栈顶小，可以pop栈顶，栈元素小于k的时候，直接加入index，这样最后得到一个单调递增栈
        // pop 栈顶的时候还有一个条件需要判断，是否剩下的值加上栈已有的值大于 > k
        // nums.length - i + stack.size() > k
        
        int n = nums.length;
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[k];
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()] && n - i + stack.size() > k){
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(i);
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            res[i] = nums[stack.pop()];
        }
        return res;
    }
}