class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();
        helper(n, n, "", res);
        return res;
    }
    
    private void helper(int l, int r, String s,  List<String> res) {
        
        if (l == 0 && r == 0) {
            res.add(s);
            return;
        }
        if (l > 0) {
            helper(l - 1, r, s + "(", res);
        }
        if (r > l) {
           helper(l, r - 1, s + ")", res); 
        }
    }
}