class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if (coins == null || coins.length == 0) {
           return -1;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            dp[i] = -1; // init as can not made up
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != -1) {
                    if (dp[i] == -1 || dp[i - coin] + 1 < dp[i]) {
                       dp[i] = dp[i - coin] + 1;
                    }
                } 
            }
        }
        return dp[amount];
    }
}