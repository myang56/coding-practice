class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {

        int i = 0, res = 0, n = nums.length;
        for (int j = 0; j < n; j++) {
            k -= nums[j] % 2 == 0 ? 0 : 1; // 可以巧妙的转为为 k -= nums[j] % 2; // 因为刚好奇数是要-1

            while (k < 0) { // 当k < 0 时需要滑动左边窗口了，直到k >= 0
                k += nums[i++] % 2;
            }
            res += j - i + 1;
        }
        return res;
    }
}