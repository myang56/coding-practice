class Solution {
    public int minOperations(int[] nums, int x) {
        
        // 跟930类似，因为是从两边减，总共减去x, 要使这个过程最少 , 那么中间需要最长的subarray，
        // 这里可以转化为找到最长的middle subarray
        int target = -x;
        for (int num : nums) {
            target += num;
        }
        if (target == 0) {
            return nums.length;
        }
        Map<Integer, Integer> map = new HashMap<>(); // prefix sum 对应的index
        map.put(0, -1);
        int sum = 0;
        int res = Integer.MIN_VALUE; // 最长的middle subarray的长度
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if (map.containsKey(sum - target)) {
                res = Math.max(res, i - map.get(sum - target));
            }
            map.put(sum, i);
        }
        return res == Integer.MIN_VALUE ? -1 : nums.length - res;
    }
}