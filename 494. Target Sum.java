class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return helper(nums, 0, 0, S);
    }
    
    private int helper(int[] nums, int index, int sum, int target) {
        
        if (index == nums.length) {
            return sum == target ? 1 : 0; 
        }
        return helper(nums, index + 1, sum + nums[index], target) + helper(nums, index + 1, sum - nums[index], target); 
    }
}