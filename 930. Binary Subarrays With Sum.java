class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        
        // 求prefix sum
        // 加到sum， 然后看前面有多少个sum - S [i .....j ] --> S
        // subarry == S 的数目，跟前面sum -S 的数目是一样的
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0, 1);
        
        for (int num : A) {
            sum += num;
            
            if (map.containsKey(sum - S)) {
                count += map.get(sum - S);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}