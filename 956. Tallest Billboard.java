class Solution {
    public int tallestBillboard(int[] rods) {
        
        Map<Integer, Integer> dp = new HashMap<>();
        Map<Integer, Integer> curr = new HashMap<>();
        
        dp.put(0, 0);
        for (int x: rods) {
            curr = new HashMap<>(dp);
            for (int d: curr.keySet()) {
                dp.put(d + x, Math.max(curr.get(d), dp.getOrDefault(x + d, 0)));
                dp.put(Math.abs(d - x), Math.max(curr.get(d) + Math.min(d, x), dp.getOrDefault(Math.abs(d - x), 0)));
            }
        }
        return dp.get(0);
    }
}