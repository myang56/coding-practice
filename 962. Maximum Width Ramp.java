class Solution {
    public int maxWidthRamp(int[] A) {
        
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        int n = A.length;
        // 从左往右，单调递减栈存index
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || A[stack.peek()] > A[i]) {
                stack.push(i);
            }
        }
        // 从右往左扫, 如果当前栈顶小于等于当前值，那么满足条件，取最大的width
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                res = Math.max(res, i - stack.pop());
            }
        }
        return res;
    }
}