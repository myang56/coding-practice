 class Solution {
    public String simplifyPath(String path) {
        // edward shi method
        // t: O(N), s: O(N)
        Deque<String> stack = new ArrayDeque<>();
        String[] paths = path.split("/+"); // one or more /
        
        for (String s: paths) {
            
            if (s.equals("..")){
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!s.equals(".") && !s.equals("")) {
                stack.push(s);
            }
        }
        
        String res = "";
        
       while (!stack.isEmpty()) {
          res = "/" + stack.pop() + res;
        }
        
        if (res.length() == 0) {
            return "/";
        }
        return res;
    }
}