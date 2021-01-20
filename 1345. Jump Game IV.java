class Solution {
    public int minJumps(int[] arr) {
        
        int n = arr.length;
        if (n <= 1) {
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>(); // value -> list of index
        for (int i = 0; i < n; i++) { // 因为相同的值，可以直接跳到
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited.add(0);
        int steps = 0;
        
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll(); 
                if (curr == n - 1) {
                    return steps;
                }
                // i - 1
                if (curr > 0 && !visited.contains(curr - 1)) {
                    visited.add(curr - 1);
                    queue.offer(curr - 1);
                }
                // i + 1
                if (curr + 1 < n && !visited.contains(curr + 1)) {
                    visited.add(curr + 1);
                    queue.offer(curr + 1);
                }
                
                // arr[i] == arr[j];
                if (map.containsKey(arr[curr])) {
                    for (int index : map.get(arr[curr])) {
                        if (!visited.contains(index)) {
                            visited.add(index);
                            queue.offer(index);
                        }
                    }
                    map.remove(arr[curr]); // do not need traverse again [1, 1, 1, 1, 1, 2]
                }
            }
            steps++;
        }
        return -1;
    }
}