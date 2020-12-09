class Solution {
    
    int i = 0; // global variable to point to the pos in the string
    public int calculate(String s) {
        
        // 还是用stack更加直观
        // https://www.bilibili.com/video/BV1F5411G7NQ
        Deque<Integer> stack = new ArrayDeque<>();
        char operator = '+';
        int num = 0;
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (Character.isDigit(c)) { //  if (c >= '0' && c <= '9') 
                num = num * 10 + (c - '0'); // 后面括号先计算减号可以避免overflow
            }
            if (c == '(') { // meet (, run into a recursion
                num = calculate(s);
            }
            if (i >= s.length() || c == '+' || c == '-' || c == ')') {
                 if (operator == '+') {
                     stack.push(num);
                 } else {
                     stack.push(-num);
                 }
                operator = c; //update to current op
                num = 0; 
            }
            if (c == ')') { // meet ), jump out of the recursion
                break;
            }
        }
        return stack.stream().mapToInt(x -> x).sum();
    }
}