class Solution {
    public boolean stoneGame(int[] piles) {
        
        // huahua 
        // dp[i] = max (your stone - op-stone) for piles[i]  - piles[i + l - 1]
        int n = piles.length;
        int[] dp = new int[n];
        
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                dp[i] = Math.max(piles[i] - dp[i + 1], piles[i + l - 1] - dp[i]);
            }
        }
        return dp[0] > 0;
    }
}