class Solution {
    public int longestOnes(int[] A, int K) {
        
        // sliding window
        int res = 0, left = 0;
        int zeroCount = 0;
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                zeroCount++;
            }
            while (zeroCount > K) {
                if (A[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}