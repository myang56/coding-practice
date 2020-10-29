class Solution {
    public int getMoneyAmount(int n) {
        
         int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int temp = Integer.MAX_VALUE;
                for (int k = start; k < start + len - 1; k++) {
                    int res = k + Math.max(dp[start][k - 1], dp[k + 1][start + len - 1]);
                    temp = Math.min(res, temp);
                }
                dp[start][start + len - 1] = temp;
            }

        }
        return dp[1][n];
    }
}