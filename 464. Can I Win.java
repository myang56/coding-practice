class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        
        // 记忆化递归
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (sum < desiredTotal) {
            return false;
        }
        
        Map<Integer, Boolean> memo = new HashMap<>();
        return helper(desiredTotal, maxChoosableInteger, 0, memo);
    }
    
    private boolean helper(int total, int maxNum, int state,  Map<Integer, Boolean> memo) {
        if (memo.containsKey(state)) {
            return memo.get(state);
        }
        
        for (int i = 0; i < maxNum; i++) {
            
            int curr = 1 << i; // 1左移i位，这样第i位是1
            // ith bit of state
            if ((state & curr) != 0) { // 两者都等于1才为1，否则为0，说明这个数i + 1 使用过了 
                continue;
            }
            // state | curr, 相当于把第i为设为1， 或操作，两者都为0才为0，否则就是1
            // state | curr, if i th bit of state is 0, set it to be 1
            if (total <= i + 1 || !helper(total - (i + 1), maxNum, state | curr, memo)) {
                memo.put(state, true);
                return true;
            }
        }
        memo.put(state, false);
        return false;
    }
}