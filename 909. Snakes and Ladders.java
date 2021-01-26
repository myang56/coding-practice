class Solution {
    public int snakesAndLadders(int[][] board) {
        // https://leetcode.com/problems/snakes-and-ladders/discuss/173682/Java-concise-solution-easy-to-understand
        // 01/25/21
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean[] visited = new boolean[n * n + 1];
        visited[1] = true;
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == n * n) {
                    return steps;
                }
                for (int j = 1; j <= 6 && curr + j <= n * n; j++) {
                    int next = curr + j;
                    int nextValue = getBoardValue(board, next);
                    if (nextValue > 0) { // != -1 , then has a "snake or ladder"
                    // If S has a snake or ladder, you move to the destination of that snake or ladder.  Otherwise, you move to S.
                        next = nextValue;
                    }
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
            steps++;
        }
        return -1;  
    }