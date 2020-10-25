class Solution {
    public boolean splitArraySameAverage(int[] A) {
        
        int sum = 0;
        for (int num : A) {
            sum += num;
        }
        int n = A.length;
        boolean[][] dp = new boolean[sum + 1][n / 2 + 1];
        dp[0][0] = true;
        
        for (int num : A) {
            for (int i = sum; i >= num; i--) {
                for (int j = 1; j <= n / 2; j++) {
                    dp[i][j] = dp[i][j] || dp[i - num][j - 1];
                }
            }
        }
        
        // 因为平均值相等，所以 sum/n = sum1/k = sum2/(n - k)
        // => sum * k / n = sum1, 必须满足sum * k % n == 0
        for (int i = 1; i <= n / 2; i++) {
            if (sum * i % n == 0 && dp[sum * i / n][i]) {
                return true;
            }
        }
        return false;
    }
}