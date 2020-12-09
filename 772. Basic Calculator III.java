class Solution {
    
    int i = 0;
    public int calculate(String s) {
        // 120820 模板 古城
        // https://www.bilibili.com/video/BV1F5411G7NQ
        Deque<Integer> stack = new ArrayDeque<>();
        char operator = '+';
        int num = 0;
        
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (c == '(') {
                num = calculate(s);
            }
            
            if (i >= s.length() || c == '+' || c == '-' || c == '*' || c == '/' || c == ')') {
                
                if (operator == '+') {
                    stack.push(num);
                } else if (operator  == '-') {
                    stack.push(-num);
                } else if (operator  == '*') {
                    stack.push(stack.pop() * num);
                } else if (operator == '/'){
                     stack.push(stack.pop() / num);
                }
                operator = c;
                num = 0;
            }

            if (c == ')') {
                break;
            }
        }
        return stack.stream().mapToInt(x -> x).sum();
    }
}