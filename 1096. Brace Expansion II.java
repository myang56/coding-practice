class Solution {
    public List<String> braceExpansionII(String expression) {
        
        // BFS
        // https://leetcode-cn.com/problems/brace-expansion-ii/solution/biao-zhun-bfs-ti-jie-by-tangweiqun-6/
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(expression);
        Set<String> res = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        while (!queue.isEmpty()) {
            
            String exp = queue.poll();
            if (!exp.contains("{")) { // 如果没有括号，直接加入解雇
                res.add(exp);
                continue;
            }
            
            // 找到第一对 {}
            int i = 0;
            int left = 0, right = 0;
            while (exp.charAt(i) != '}') {
                if (exp.charAt(i) == '{') { // 左括号的位置
                    left = i;
                }
                i++;
            }
            right = i; 
            
            // 第一对括号的前面和后面部分
            String before = exp.substring(0, left);
            String after = exp.substring(right + 1);
            
            // 将括号里面的内容分割
            String[] strs = exp.substring(left + 1, right).split(",");
            
            // before , after 和括号里的元素组成新的string，加入到queue里面
            for (String s : strs) {
                sb.setLength(0);
                String newStr = sb.append(before).append(s).append(after).toString();
                queue.offer(newStr);
            }
        }
        List<String> ans = new ArrayList<>(res);
        Collections.sort(ans);
        return ans;
    }
}