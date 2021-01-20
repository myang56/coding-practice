class Solution {
    public int trapRainWater(int[][] heightMap) {
        
        // time : O(m * n * log(m + n)  space : O(m * n)
        if (heightMap == null || heightMap.length == 0) {
            return 0;
        }
        
        int m = heightMap.length;
        int n = heightMap[0].length;
        
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    visited[i][j] = true;
                    pq.offer(new int[]{i, j, heightMap[i][j]});
                }
            }
        }
        
        int res = 0;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!pq.isEmpty()) {
            
            int[] curr = pq.poll();
            
            for (int[] dir : dirs) {
                
                int row = curr[0] + dir[0];
                int col = curr[1] + dir[1];
                
                if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col]) {
                    continue;
                }
                
                visited[row][col] = true;
                res += Math.max(0, curr[2] - heightMap[row][col]); // 注意是前面的 - 当前的
                
                pq.offer(new int[]{row, col, Math.max(curr[2], heightMap[row][col])});
            }
        }
        return res;
        
    }
}
