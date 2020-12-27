class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        
        return atMost(A, K) - atMost(A, K - 1);
    }
    
    private int atMost(int[] A, int k) {
        
        int left = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
            
            while (map.size() > k) {
                if (map.get(A[left]) == left) {
                    map.remove(A[left]);
                }
                left++;
            }
            res += i - left + 1;
        }
        return res;
    }
}