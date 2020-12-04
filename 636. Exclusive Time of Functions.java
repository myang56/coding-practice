
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
      // 用stack保存当前还在调用栈内的func的id，pre记录前序时间。遇到start要push进入stack，遇到end要pop
    	Deque<Integer> stack = new ArrayDeque<>();
    	int [] res = new int[n];
		int pre = 0;
		
    	for (String log : logs) {
    		String[] attr = log.split(":");
    		if (attr[1].equals("start")) {
    			if (!stack.isEmpty()) {
                   res[stack.peek()] += Integer.parseInt(attr[2]) - pre; // 新的点的开始时间减去上一个点的开始时间
    			}
    			   pre = Integer.parseInt(attr[2]); // 这个点的开始时间
    			   stack.push(Integer.parseInt(attr[0])); // 加入当前ID
    		} else {
                res[stack.pop()] += Integer.parseInt(attr[2]) - pre + 1; // 当前点的执行时间 = 当前点的结束时间-开始时间 + 1
    			pre = Integer.parseInt(attr[2]) + 1; // 
    		}
    	}
    	return res;
    }
}