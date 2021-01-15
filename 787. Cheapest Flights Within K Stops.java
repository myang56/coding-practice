class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();// curr --  <next, price>
        for (int[] f : flights) {
            if (!graph.containsKey(f[0])) {
               graph.put(f[0], new HashMap<>()); 
            }
            graph.get(f[0]).put(f[1], f[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); 
        pq.offer(new int[]{0, src, K + 1}); // price - scr - steps
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int price = curr[0];
            int city = curr[1];
            int steps = curr[2];
            
            if (city == dst) {
                return price;
            }
            
            if (steps > 0) {
                
                Map<Integer, Integer> neighbors = graph.get(city);
                if (neighbors != null) {
                    for (int next : neighbors.keySet()) {
                        pq.offer(new int[]{price + neighbors.get(next), next, steps - 1});
                    }
                }
            }
        }
        return -1;
    }
}