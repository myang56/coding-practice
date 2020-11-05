class Solution {
    public int maxCoins(int[] nums) {
        
        // O(N ^ 3) O(N ^ 2)
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // 首先要建立一个新的aray使得当前两端都为1
        int n = nums.length;
        int[] temp = new int[n + 2];
        temp[0] = temp[n + 1] = 1;
        
        for (int i = 0; i < n; i++) {
            temp[i + 1] = nums[i];
        }
        n += 2;
        int[][] f = new int[n][n];
        
        // 如果中间没有气球可以扎，长度为2
        for (int i = 0; i < n - 1; i++) {
            f[i][i + 1] = 0;
        }
        
        // 长度为3以上，找到最大的
        for (int len = 3; len <= n; len++) {
            
            for (int i = 0; i <= n - len; i++) {
                
                int j = i + len - 1; 
                // i ...k ... j
                f[i][j] = 0;
                // 选择k气球去扎破，求最大的值
                for (int k = i + 1; k < j; k++) {
                    f[i][j] = Math.max(f[i][j], f[i][k] + f[k][j] + temp[i] * temp[k] * temp[j]);
                }
            }
        }
        return f[0][n - 1];
    }
}