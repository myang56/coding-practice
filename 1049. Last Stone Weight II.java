class Solution {
    public int lastStoneWeightII(int[] stones) {
        
        // https://leetcode-cn.com/problems/last-stone-weight-ii/solution/dong-tai-gui-hua-jie-zui-hou-yi-kuai-shi-tou-de-zh/
        // dp[i][j] 到第i个石头时，j的背包容量(能装石头的重量)
        // 选或者不选第i个石头
        // 不选, 依赖前一个石头的情况 dp[i - 1][j]
        // 选，减去当前的背包容量 加上当前的价值
        
        int n = stones.length;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int[][] dp = new int[n + 1][sum / 2 + 1];
        for (int i = 1; i <= n; i++) {
            int currStone = stones[i - 1];
            for (int j = 1; j <= sum / 2; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                if (j >= currStone) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - currStone] + currStone);
                }
                
            }
        }
        return sum - 2 * dp[n][sum / 2];
    }
}