class Solution {
    public boolean makesquare(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return false;
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }
        
        int width = sum / 4;
        // if any num > width, return false
        for (int num : nums) {
           if (num > width) {
               return false;
           }
        }
        
        boolean[] visited = new boolean[nums.length];
        return dfs(nums, visited, 0, 0, width, 0);
    }
    
    private boolean dfs(int[] nums, boolean[] visited, int start, int sum, int target, int count) {
        
        if (count == 4) {
            // if any num not used, return false
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    return false;
                }
            }
            return true;
        } else if (sum > target) {
            return false;
        } else if (sum == target) {
            return dfs(nums, visited, 0, 0, target, count + 1);
        } else {
            
            for (int i = start; i < nums.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    if (dfs(nums, visited, i + 1, sum + nums[i], target, count)) {
                        return true;
                    }
                    visited[i] = false;
                }
            }
            return false;
        }
    }
}