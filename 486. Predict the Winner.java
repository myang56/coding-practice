class Solution {
    public boolean PredictTheWinner(int[] nums) {
        
        int n = nums.length;
        Integer[][] memo = new Integer[n][n];
        return helper(nums, 0, n - 1, memo) >= 0;   
    }
    
    private int helper(int[] nums, int l, int r, Integer[][] memo) {
        
        if (l == r) {
            return nums[l];
        }
        
        if (memo[l][r] != null) {
            return memo[l][r];
        }
        int a = nums[l] - helper(nums, l + 1, r, memo);
        int b = nums[r] - helper(nums, l, r - 1, memo);
        memo[l][r] = Math.max(a, b);
        return memo[l][r];
    }
}