class Solution {
    
    class Node {
        int i;
        int j;
        int val;
        
        public Node(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }
    public int swimInWater(int[][] grid) {
        
        // Dijkstra, 找最小路径，返回路径中最大值
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        pq.offer(new Node(0, 0, grid[0][0]));
        visited[0][0] = true;
        int res = 0;
        
        while (!pq.isEmpty()) {
           Node curr = pq.poll();
           res = Math.max(res, curr.val);
           if (curr.i == n - 1 && curr.j == n - 1) {
               return res;
           }
        
            for (int[] dir : dirs) {
                int row = curr.i + dir[0];
                int col = curr.j + dir[1];
                
                if (row < 0 || row >= n || col < 0 || col >= n) {
                    continue;
                }
                if (!visited[row][col]) {
                   visited[row][col] = true;
                    pq.offer(new Node(row, col, grid[row][col]));
                }
            }
        }
        return -1;
    }
    
}