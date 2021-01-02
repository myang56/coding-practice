class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        Deque<Integer> maxd = new ArrayDeque<>();
        Deque<Integer> mind = new ArrayDeque<>();
        int res = 0, l = 0;
        
        for (int r = 0; r < nums.length; r++) {
            
            // decrease
            while (!maxd.isEmpty() && maxd.peekLast() < nums[r]) {
               maxd.pollLast();
            }
            
            // increase
            while (!mind.isEmpty() && mind.peekLast() > nums[r]) {
               mind.pollLast();
            }
            
            maxd.offerLast(nums[r]);
            mind.offerLast(nums[r]);
            
            while (maxd.peekFirst() - mind.peekFirst() > limit) {
                if (maxd.peekFirst() == nums[l]) {
                   maxd.pollFirst();
                }
                if (mind.peekFirst() == nums[l]) {
                   mind.pollFirst();
                }
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}