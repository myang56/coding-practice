class Solution {
    public boolean parseBoolExpr(String expression) {
        
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == ')') { // check previous char 
                Set<Character> seen = new HashSet<>();
                while (stack.peek() != '(') {
                  seen.add(stack.pop());
                }
                stack.pop(); // pop out '('
                char operator = stack.pop(); // get operator
                if (operator == '&') {
                    stack.push(seen.contains('f') ? 'f' : 't');
                } else if (operator == '|') {
                    stack.push(seen.contains('t') ? 't' : 'f');
                } else { // !
                    stack.push(seen.contains('t') ? 'f' : 't');
                }
            } else if (c != ',') {
                stack.push(c);
            }
        }
        return stack.peek() == 't';
    }
}