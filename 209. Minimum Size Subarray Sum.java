class Solution {
    public int minSubArrayLen(int s, int[] nums) {

        // O(N) two points
        int res = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
              sum += nums[i];

              while (sum >= s) {
              	res = Math.min(res, i - left + 1);
              	sum -= nums[left++];
              }
        }
        return res == Integer.MAX_VALUE? 0 : res;
    }
}