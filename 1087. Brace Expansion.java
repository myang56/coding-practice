class Solution {
    public String[] expand(String S) {
        
        // 需要对s做处理，把括号里的char合并成一个string，把这些string都存到一个list里面
        // 这样就相当于从这个list的string里面每取一个值能组成的所有可能的string
        // DFS 找所有可能性
        List<String> list = new ArrayList<>();
        int n = S.length();
        
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == '{') {
                // 把括号里值合并成一个string
                int j = i + 1;
                StringBuilder sb = new StringBuilder();
                while (j < n && S.charAt(j) != '}') {
                    if (S.charAt(j) != ',') {
                       sb.append(S.charAt(j));
                    }
                    j++;
                }
                list.add(sb.toString());
                i = j; // 后面又++，跳过了闭括号
            } else {
              list.add(S.charAt(i) + "");
            }
        }
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(list, 0, sb, res);
        String[] ans = res.stream().toArray(k -> new String[k]); // String[] ans = res.toArray(new String[res.size()]);
        Arrays.sort(ans);
        return ans;
    }
    
    private void dfs(List<String> list, int index, StringBuilder sb, List<String> res) {
        
        if (sb.length() == list.size()) {
            res.add(sb.toString());
            return;
        }
        String curr = list.get(index);
        for (int i = 0; i < curr.length(); i++) {
            sb.append(curr.charAt(i));
            dfs(list, index + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}