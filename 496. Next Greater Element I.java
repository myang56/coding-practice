class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        // O(m + n) space: O(n)
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();  // curr - next greater
        int n = nums1.length;
        int[] res = new int[n];
        
        // 遍历nums2, 将值加入stack，while循环判断当前值是否大于栈顶的值，如果是的话，建立对应关系
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        // 不在map里的，next greater就是-1
        for (int i = 0; i < n; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}