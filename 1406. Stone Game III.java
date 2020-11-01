class Solution {
    public String stoneGameIII(int[] stoneValue) {
        
        int n = stoneValue.length;
        int[] f = new int[n + 1];
        
        for (int i = n - 1; i >= 0; i--) {
            f[i] = stoneValue[i] - f[i + 1];
            if (i < n - 1) {
                f[i] = Math.max(f[i], stoneValue[i] + stoneValue[i + 1] - f[i + 2]);
            }
            
            if (i < n - 2) {
                f[i] = Math.max(f[i], stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - f[i + 3]);
            }
        }
        if (f[0] == 0) {
            return "Tie";
        } else if (f[0] > 0) {
            return "Alice";
        } else {
            return "Bob";
        }
    }
}