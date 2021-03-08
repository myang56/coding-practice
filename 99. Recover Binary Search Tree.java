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

	TreeNode first = null; // first element that need to swap
	TreeNode second = null;
	TreeNode previous = new TreeNode(Integer.MIN_VALUE);


    public void recoverTree(TreeNode root) {

    	// 其实不难，题意是两个数字调换了，现在需要把它们找到再调换回来
    	// 用inorder traverse 左根右
        // leetcod dis & jiuzhang sol
        // 6, 3, 4, 5, 2  --> 6 > 3, 6 is first, 5 > 2 , 2 is second, swap 6 and 2
    	inOrderTraverse(root);
    	// swap first and second
    	int temp = first.val;
    	first.val = second.val;
    	second.val = temp;
    }
    private void inOrderTraverse(TreeNode root) {

    	if (root == null) {
    		return;
    	}

    	// left 
    	inOrderTraverse(root.left);

        // do something
         // first not found
        if (first == null &&  root.val < previous.val) {
        	first = previous;
        }
         // first is found
        if (first != null && root.val < previous.val) {
        	second = root;
        }
        previous = root;
    	// right 
    	inOrderTraverse(root.right);
    }
}


// 04/23/19
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
    
    TreeNode first = null; // first start node that is not in order 
    TreeNode second = null; // second end 第二组里面的最后一个
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        
        inorderTraverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void inorderTraverse(TreeNode root) {
        
        if (root == null) {
            return;
        }
        inorderTraverse(root.left);
        if (first == null && root.val < prev.val) {
            first = prev;
        }
        if (first != null && root.val < prev.val) {
            second = root; // 注意这里second要设置成当前root
        }
        prev = root;
        inorderTraverse(root.right);
    }
}