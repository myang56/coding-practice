class Solution {
    
    private int i; 
    public String countOfAtoms(String formula) {
       
        // O(N ^ 2)  O(N) HUAHUA SOL
        i = 0;
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> counts = helper(formula.toCharArray());
        
        for (String atom : counts.keySet()) {
            sb.append(atom);
        
            if (counts.get(atom) == 1) {
                sb.append("");
            } else {
                sb.append(counts.get(atom));
            }
        }
        return sb.toString();
    }
    
    private Map<String, Integer> helper(char[] ff) {
        
        Map<String, Integer> res = new TreeMap();
        
        while (i < ff.length) {
            
            if (ff[i] == '(') {
                i++;
                Map<String, Integer> temp = helper(ff); // 子问题的解，求出当前括号的解
                int count = getCount(ff);
                
                // 跟当前res和平 (SO3)2
                for (String atom : temp.keySet()) {
                    res.put(atom, res.getOrDefault(atom, 0) + temp.get(atom) * count);
                }
            } else if (ff[i] == ')') {
                i++;
                return res; // 找到匹配的括号了，返回当前结果
            } else {
                
                String atom = getName(ff);
                res.put(atom, res.getOrDefault(atom, 0) + getCount(ff));

            }
        }
        return res;   
    }
    
    private int getCount(char[] ff) {
        
        int val = 0;
        
        while (i < ff.length && Character.isDigit(ff[i])) {
            val = val * 10 + ff[i++] - '0';
        }
        return val == 0 ? 1 : val; 
    }
    
    private String getName(char[] ff) {
        
        StringBuilder sb = new StringBuilder();
        sb.append(ff[i++]); // 先加上第一个大写的
        
        // 再把可能的小写字母加上
        while (i < ff.length && Character.isLowerCase(ff[i])) {
            sb.append(ff[i++]);
        }
        return sb.toString();   
    }
}




public class Solution {
    /**
     * @param formula: a string
     * @return: return a string
     */
    public String countOfAtoms(String formula) {
        // write your code here
        // O(N ^ 2) space : O(n)
        // https://leetcode.com/problems/number-of-atoms/discuss/109345/Java-Solution-using-Stack-and-Map
       TreeMap<String, Integer> map = new TreeMap();
        Stack<TreeMap> stack = new Stack();
        char[] fc = formula.toCharArray();
        
        int i = 0, len = fc.length;
        
        while (i < len) {
            
            if (fc[i] == '(') {
                stack.push(map);
                map = new TreeMap();
                i++;
            } else if (fc[i] == ')') {
                int val = 0;
                i++;
                
                while (i < len && Character.isDigit(fc[i])) {
                    val = 10 * val + fc[i] - '0';
                    i++;
                }
                
                val = val == 0 ? 1 : val;
                
                if (!stack.isEmpty()) {
                    
                    TreeMap<String, Integer> temp = map;
                    map = stack.pop();
                    
                    for (String atom : temp.keySet()) {
                        map.put(atom, map.getOrDefault(atom, 0) + temp.get(atom) * val);
                    }
                    
                }
            } else {
                
                int j = i + 1;
                
                while (j < len && Character.isLowerCase(fc[j])) { // 判断Mg这种情况
                    j++;
                }
                
                String atom = formula.substring(i, j);
                
                int val = 0;
                
                while (j < len && Character.isDigit(fc[j])) {
                    val = val * 10 + fc[j] - '0';
                    j++;
                }
                
                val = val == 0 ? 1 : val;
                
                map.put(atom, map.getOrDefault(atom, 0) + val);
                i = j;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (String atom : map.keySet()) {
            sb.append(atom);
            sb.append(map.get(atom) == 1 ? "" : map.get(atom));
        }
        return sb.toString();
    }
}