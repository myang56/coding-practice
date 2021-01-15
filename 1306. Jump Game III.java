class Solution {
    public boolean canReach(int[] arr, int start) {

        // method 1 dfs
        if (start < 0 || start >= arr.length || arr[start] < 0) {
            return false;
        }
        if (arr[start] == 0) {
            return true;
        }
        arr[start] = -arr[start];
        return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
    }
}

class Solution {
    public boolean canReach(int[] arr, int start) {

        // method 2 bfs
        Queue<Integer> queue = new LinkedList();
        Set<Integer> set = new HashSet();
        queue.offer(start);
        set.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (arr[curr] == 0) {
                return true;
            }
            // check next
            int[] nextChoices = new int[] { curr + arr[curr], curr - arr[curr] };

            for (int next : nextChoices) {
                if (next >= 0 && next < arr.length && !set.contains(next)) {
                    set.add(next);
                    queue.offer(next);
                }
            }
        }
        return false;

    }
}