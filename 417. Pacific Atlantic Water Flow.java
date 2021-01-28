class Solution {
    
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        
        // dfs 2d array 分别记录能到Pacific和Atlantic的点 
        // 最后返回同时visited了Pacific和Atlantic的点 
        
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[][] p = new boolean[m][n];
        boolean[][] a = new boolean[m][n];
        
        // for each row, 从边界往里扫，里面的值要比边界的值大，才能流出来
        // 边界外面的高度初始化为0，边界的水肯定能流入到海里
        for (int i = 0; i < m; i++) {
            dfs(matrix, p, 0, i, 0);
            dfs(matrix, a, 0, i, n - 1);
        }
        
        // for each rol
        for (int i = 0; i < n; i++) {
            dfs(matrix, p, 0, 0, i);
            dfs(matrix, a, 0, m - 1, i);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p[i][j] && a[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
    
    private void dfs(int[][] matrix, boolean[][] visited, int height, int row, int col) {
        
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] < height || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        
        for (int[] dir : dirs) {
            dfs(matrix, visited, matrix[row][col], row + dir[0], col + dir[1]);
        }
    }
}