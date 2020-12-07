class Solution {
    public String removeDuplicates(String s, int k) {

        // lee215 two pointer
        // 用char array模拟stack, 统计char对应的数目
        // 如果连续的char等于k了，就pop出来
        // 最后返回stack里面char组成的string
        int n = s.length();
        int[] count = new int[n];
        char[] stack = s.toCharArray();
        int end = 0;

        for (int i = 0; i < n; i++) {

            stack[end] = stack[i];

            if (end > 0 && stack[end - 1] == stack[i]) {
                count[end] = count[end - 1] + 1;
            } else {
                count[end] = 1;
            }

            if (count[end] == k) {
                end -= k;
            }
            end++;
        }
        return new String(stack, 0, end);
    }
}