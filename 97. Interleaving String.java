class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        int m = s1.length();
        int n = s2.length();
        boolean[][] dp = new boolean[m + 1][n + 1]; 
        
        if (s3.length() != m + n) {
            return false;
        }
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true; // 空对空
                    continue;
                }
                dp[i][j] = false;
                
                if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) { // s1最后一位对上s3最后一位
                    dp[i][j] |= dp[i - 1][j]; // 看去掉s1最后一位，是否能组成剩余的s3
                }
                
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) { // s2最后一位对上s3最后一位
                    dp[i][j] |= dp[i][j - 1]; // 看去掉s2最后一位，是否能组成剩余的s3
                }
            }
        }
        return dp[m][n];
    }
}