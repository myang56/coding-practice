class Solution {
    public List<String> letterCasePermutation(String S) {
        
        char[] ss = S.toCharArray();
        List<String> res = new ArrayList();
        helper(ss, 0, res);
        return res;
    }
    
    private void helper(char[] ss, int index, List<String> res) {
        if (index == ss.length) {
            res.add(new String(ss));
            return;
        }
        if (Character.isDigit(ss[index])) {
            helper(ss, index + 1, res);
            return;
        }
        ss[index] = Character.toLowerCase(ss[index]);
        helper(ss, index + 1, res);
        
        ss[index] = Character.toUpperCase(ss[index]);
        helper(ss, index + 1, res);
    }
}