class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        
        int m = s1.length();
        int n = s2.length();
        
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += s1.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            sum += s2.charAt(i);
        }
        int[][] dp = new int[m + 1][n + 1]; // ascii values from max common subsequence 
         
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return sum - 2 * dp[m][n];
    }
}