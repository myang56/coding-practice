class Solution {
    public int findTheLongestSubstring(String s) {
        
        Map<Character, Integer> voewlToIndex = new HashMap<>();
        voewlToIndex.put('a', 0);
        voewlToIndex.put('o', 1);
        voewlToIndex.put('e', 2);
        voewlToIndex.put('i', 3);
        voewlToIndex.put('u', 4);
        
        Map<Integer, Integer> stateToIndex = new HashMap<>(); // statetoIndex
        stateToIndex.put(0, -1);
        int state = 0, maxLen = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (voewlToIndex.containsKey(curr)) {
                
                int digit = voewlToIndex.get(curr);
                
                // flip the bit
                state = state ^ (1 << digit);
            }
            stateToIndex.putIfAbsent(state, i);
            maxLen = Math.max(maxLen, i - stateToIndex.get(state));
        }
        return maxLen;
    }
}