class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int[] count = new int[256];
        int res = 0, left = 0;
        
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
            
            while (count[s.charAt(i)] > 1) {
                count[s.charAt(left)]--;
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}