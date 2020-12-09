class Solution {
    
    public int calculate(String s) {
        
        Deque<Integer> stack = new ArrayDeque<>();
        char operator = '+';
        int num = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
            }
            if (i >= s.length() || c == '+' || c == '-' || c == '*' || c == '/') {
                if (operator == '+') {
                    stack.push(num);
                } else if (operator == '-') {
                    stack.push(-num);
                } else if (operator == '*') {
                    stack.push(stack.pop() * num);
                } else {
                    stack.push(stack.pop() / num);
                }
                operator = c;
                num = 0;
            }
        }
        return stack.stream().mapToInt(x -> x).sum();
    }
}