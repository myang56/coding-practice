class Solution {
    public int[] dailyTemperatures(int[] T) {
		
        // 跟503写法一样
        // next greater number
        Deque<Integer> stack = new LinkedList<>(); // save index
        int n = T.length;
        int[] res = new int[n];
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int day = i - stack.peek();
                res[stack.pop()] =  day;
            }
            stack.push(i);
        }
        return res;
    }
}
