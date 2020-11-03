class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int [] f = new int [n + 1];
        f[0] = 0;
        f[1] = nums[0];
        for (int i = 2; i <= n; i++) {
                        //  不偷房子i- 1，      偷房子 i - 1
            f[i] = Math.max(f[i - 1], f[i - 2] + nums[i -1]);
        }
        return f[n];
    }
}