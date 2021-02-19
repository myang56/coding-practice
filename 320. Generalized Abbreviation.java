class Solution {
    public List<String> generateAbbreviations(String word) {
        
        // 021821
        // O(n * 2 ^ n) O(n) for sb to construct in the leaves node
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] ss = word.toCharArray();
        helper(ss, 0, 0, sb, res);
        return res;
    }
    
    private void helper(char[] ss, int index, int num,  StringBuilder sb, List<String> res) {
        
        int len = sb.length();
        // base case
        if (index == ss.length) {
            if (num > 0) {
                sb.append(num);
            }
            res.add(sb.toString());
        } else {
            helper(ss, index + 1, num + 1, sb, res);
            if (num > 0) {
               sb.append(num);
            }
            sb.append(ss[index]);
            helper(ss, index + 1, 0, sb, res);
        }
        
        sb.setLength(len);
    }
}