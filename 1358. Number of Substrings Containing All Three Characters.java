class Solution {
    public int numberOfSubstrings(String s) {
        
        // lee215
        int[] count = new int[3];
        int res = 0, i = 0;
        
        for (int j = 0; j < s.length(); j++) {
            count[s.charAt(j) - 'a']++;
            
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                count[s.charAt(i++) - 'a']--;
            }
            // 这样至少从[i - 1, j] 是满足至少满足abc都有的，满足abc都有最小的窗口，那么之前的当然也满足，总共有0 -- i - 1= i个
            res += i;
        }
        return res;
    }
}