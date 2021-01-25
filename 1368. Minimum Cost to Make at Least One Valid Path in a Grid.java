class Solution {
    
    // https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/discuss/524886/JavaC%2B%2BPython-BFS-and-DFS
    // 还没理解
    int INF = (int) 1e9;
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int minCost(int[][] grid) {
        
        int m = grid.length, n = grid[0].length, cost = 0;
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], INF);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        dfs(grid, 0, 0, dp, 0, queue); // find all reachable nodes 
        
        while (!queue.isEmpty()) {
            cost++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0], c = curr[1];
                
                for (int[] dir : dirs) {
                    dfs(grid, r + dir[0], c + dir[1], dp, cost, queue);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
    
    private void dfs(int[][] grid, int r, int c, int[][] dp, int cost, Queue<int[]> queue) {
        
        int m = grid.length, n = grid[0].length;
        if (r < 0 || r >= m || c < 0 || c >= n || dp[r][c] != INF) {
            return;
        }
        dp[r][c] = cost;
        queue.offer(new int[]{r, c});
        int nextDir = grid[r][c] - 1;
        dfs(grid, r + dirs[nextDir][0], c + dirs[nextDir][1], dp, cost, queue);
    }
}