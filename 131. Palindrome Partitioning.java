class Solution {
    public List<List<String>> partition(String s) {
        
        // get all substring, check if it is palindrome
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        helper(s, 0, new ArrayList<>(), res);
        return res;
    }
    
    private void helper(String s, int start, List<String> list, List<List<String>> res) {
        
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            
            String sub = s.substring(start, i + 1);
            if (!isPali(sub)) {
                continue;
            }
            list.add(sub);
            helper(s, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
    
    private boolean isPali(String s) {
        
        int i = 0, j = s.length() - 1;
        
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}