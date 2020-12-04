class Solution {
    public String removeKdigits(String num, int k) {
        
        // 09/12/19
        int n = num.length();
        int count = n - k;
        char[] stack = new char[n];
        int top = 0; // top > 0 时top - 1 为栈顶的元素
        
        for (int i = 0; i < n; i++) {
            
            char c = num.charAt(i);
            
            while (top > 0 && c < stack[top - 1] && k > 0) { // 当前char比栈顶的要小，就pop出来
                top -= 1;
                k--;
            } 
            stack[top++] = c;
        }
        
        // 找到第一个非0的元素即开始的位置
        int start = 0;
        
        while (start < count && stack[start] == '0') {
            start++;
        }
        
        return start == count ? "0" : new String(stack, start, count - start);
    }
}
