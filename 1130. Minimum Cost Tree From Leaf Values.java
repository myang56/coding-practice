class Solution {
    public int mctFromLeafValues(int[] arr) {
        // lee215, 可以转化为类似LC503，  分别找到左右两边的next greater elements
        Deque<Integer> stack = new LinkedList();
        stack.push(Integer.MAX_VALUE);
        int res = 0;
        
        for (int a : arr) { 
            
            while (stack.peek() <= a) {
                int curr = stack.pop();
                res += curr * Math.min(stack.peek(), a);
            }
            stack.push(a);
        }
        
        while (stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }
        return res;
    }
}