class Solution {
    public boolean isValidSerialization(String preorder) {

    	// degree = outdegree - indegree
    	// all non null node except root --> outdegree 2, indegree 1
    	// null node --> outdegree 0, indegree 1
    	// init degree = 1, finally, degree = 0
    	// 或者另外一种思路，# 的个数比当前的数字数多1， 初始话为1， 处理完之后应该为0
        // leetcode dis

    	int degree = 1;
        String [] s = preorder.split(",");

    	for (String p : s) {
           degree--;

           if (degree < 0) {
           	return false;
           }

           if (!p.equals("#")) {
           	  degree += 2;
           }

    	}
          return degree == 0;
        
    }
}