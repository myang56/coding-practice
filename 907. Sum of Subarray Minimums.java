class Solution {
    public int sumSubarrayMins(int[] arr) {
        
        int res = 0, n = arr.length, mod = (int)1e9 + 7;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<int[]>s1 = new LinkedList<>(); // value - count
        Deque<int[]>s2 = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (!s1.isEmpty() && arr[i] < s1.peek()[0]) {
              count += s1.pop()[1];
            }
            left[i] = count;
            s1.push(new int[]{arr[i], count});
        }
     
              
        for (int i = n - 1; i >= 0; i--) {
            int count = 1;
            while (!s2.isEmpty() && arr[i] <= s2.peek()[0]) {
              count += s2.pop()[1];
            }
            right[i] = count;
            s2.push(new int[]{arr[i], count});
        }
        
        for (int i = 0; i < n; i++) {
            res = (int) ((res +  (long)arr[i] * left[i] * right[i]) % mod);
        }
        return res;
    }
}