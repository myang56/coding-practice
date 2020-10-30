class Solution {
    public int stoneGameII(int[] piles) {
        
        // https://www.acwing.com/solution/LeetCode/content/3172/
        int n = piles.length;
        int[] sum = new int[n + 1];
        int[][] f = new int[n + 1][n + 1];
        
        for (int i = n - 1; i >= 0; i--) {
            sum[i] = sum[i + 1] + piles[i];
        }
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= 2 * j && i + k <= n; k++) {
                   f[i][j] = Math.max(f[i][j], sum[i] - f[i + k][Math.max(j, k)]);
                }
            }
        }
        return f[0][1];
    }
}