class Solution {
    public boolean isValidPalindrome(String s, int k) {
        
        // 跟516 类似 https://www.acwing.com/solution/LeetCode/content/5099/
        // f(i,j) 表示区间 [i, j] 变为回文串最少需要删除多少字符
        // 初始时，f(i,i)=0, f(i,i−1)=0，其余为正无穷。如果 s[i]==s[j] 则 f(i,j)=f(i+1,j−1)；否则，f(i,j)=min(f(i+1,j)+1,f(i,j−1)+1) 这里需要按照区间长度枚举。
        // 去头或去尾来删除，i表示头，j 表示尾
        // 最后判断f(0,n−1)≤k
        // O(n ^ 2)
        int n = s.length();
        int[][] f = new int[n][n];
        
        for (int i = 0; i < n; i++) { // 一个字符的时候就是回文
            f[i][i] = 0;
        }
        
        for (int len = 2; len <= n; len++) {
            
            // left: max(n - len), right j - i + 1 = len; => j = i + len - 1;
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) { // 头尾相等，看中间的
                    f[i][j] = f[i + 1][j - 1]; 
                } else {
                    f[i][j] = Math.min(f[i + 1][j] + 1, f[i][j - 1] + 1); // 去头或者去尾
                }
            }
        }
        return f[0][n - 1] <= k;
    }
}