class Solution {
    public int longestSubstring(String s, int k) {
        
        // divide and conquer
        if (s == null || s.length() == 0 || s.length () < k) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap();
        char[] ss = s.toCharArray();
        
        for (char c : ss) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int i = 0;
        while (i < ss.length && map.get(ss[i]) >= k) {
            i++;
        } 
        // current i  < k
        if (i == ss.length) {
            return ss.length;
        }
        
        int left = longestSubstring(s.substring(0, i), k);
        // find the next i that >= k
        while (i < ss.length && map.get(ss[i]) < k) {
            i++;
        }
        int right = longestSubstring(s.substring(i), k);
        return Math.max(left, right);   
    }
}