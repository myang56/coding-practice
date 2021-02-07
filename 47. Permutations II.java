class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        // Time : O(n * n!) 这里 n 为数组的长度。当没有重复元素时，排列数组有n!个，
        // 即最深层有n!个叶子节点，而拷贝操作需要n
        // Space: O(n * n!) 最差情况下，返回的全排列数组有n!个，每个长度为n。
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, perm, res);
        return res;
    }
    
    private void dfs(int[] nums, boolean[] visited, List<Integer> perm,  List<List<Integer>> res ) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            
            perm.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, perm, res);
            perm.remove(perm.size() - 1);
            visited[i] = false;
        }
    }
}