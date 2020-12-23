class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) { 
        
        int[] map = new int[256];
        int count = 0;
        int res = 0, l = 0;
        
        for (int r = 0; r < s.length(); r++) {
            map[s.charAt(r)]++;
            
            if (map[s.charAt(r)] == 1) {
                count++;
            }
            
            while (count > k) {
                map[s.charAt(l)]--;
                
                if (map[s.charAt(l)] == 0) {
                    count--;
                }
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}