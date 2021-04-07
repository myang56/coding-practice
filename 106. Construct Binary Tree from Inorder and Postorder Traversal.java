
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

    	// 跟preorder 那题写法基本一样，这里的root要从右边开始选择
    	Map<Integer, Integer> inMap = new HashMap<>();
    	for (int i = 0; i < inorder.length; i++) {
           inMap.put(inorder[i], i);
    	}
    	return helper(inMap, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode helper(Map<Integer, Integer> inMap, int[] postorder, int in_l, int in_r, int post_l, int post_r) {

    	if (in_l > in_r) {
    		return null;
    	}
    	TreeNode root = new TreeNode(postorder[post_r]);
    	int left_size = inMap.get(root.val) - in_l;
    	root.left = helper(inMap, postorder, in_l, in_l + left_size - 1, post_l, post_l + left_size - 1);
    	root.right = helper(inMap, postorder, in_l + left_size + 1, in_r, post_l + left_size, post_r - 1);
    	return root;
    }
}
