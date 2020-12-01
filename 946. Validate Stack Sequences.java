class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        // 模拟stack的操作，遍历pushed，把值加到stack里面，如果栈顶跟popped值相等，pop出来，记录pop的次数
         // 最后判断pop次数跟popped 的长度是否相等
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return i == popped.length;
    }
}