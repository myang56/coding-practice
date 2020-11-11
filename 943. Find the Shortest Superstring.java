class Solution {
    public String shortestSuperstring(String[] A) {
        
        // https://happygirlzt.com/code/943.html
        List<String> list = new ArrayList(Arrays.asList(A));
        while (list.size() > 1) {
            
            int n = list.size();
            int max = -1;
            int index1 = 0, index2 = 0;
            String newStr = "";
            
            // 遍历所有的组合
            for (int i = 0; i < n - 1; i ++) {
                for (int j = i + 1; j < n; j++) {
                    
                    String s1 = list.get(i);
                    String s2 = list.get(j);
                    String merged = merge(s1, s2);
                    
                    int savedLen = s1.length() + s2.length() - merged.length();
                    
                    if (savedLen > max) {
                        max = savedLen;
                        index1 = i;
                        index2 = j;
                        newStr = merged;
                    }
                }
            }
            String str1 = list.get(index1);
            String str2 = list.get(index2);
            list.remove(str1);
            list.remove(str2);
            list.add(newStr);
        }
        return list.get(0);
    }
    
    private String merge(String s1, String s2) {
        
        int len1 = s1.length(), len2 = s2.length();
        int overlapped1 = 0, overlapped2 = 0;
        
        // 如果是s1的后面部分跟s2的前面部分重叠
        for (int len = 1; len1 - len >= 0 && len <= len2; len++) {
            if (s1.substring(len1- len).equals(s2.substring(0, len))) {
                overlapped1 = len;
            }
        }
        
           // 如果是s2的后面部分跟s1的前面部分重叠
        for (int len = 1; len2 - len >= 0 && len <= len1; len++) {
            if (s2.substring(len2- len).equals(s1.substring(0, len))) {
                overlapped2 = len;
            }
        }
        
        // 取merge后最短的字符串
        if (overlapped1 >= overlapped2) {
            return s1.substring(0, len1- overlapped1) + s2;
        } else {
            return s2.substring(0, len2 - overlapped2) + s1;
        }
    }
}