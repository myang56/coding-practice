
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // 找规律，preorder里面的数字把数一分为二，比如，第一个3作为root，然后再对应的inorder里面，3 左边是左子树，右边是右子树
        // 建立inorder 里面数字与index的mapping, 以后通过值就能找到对应的index
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return helper(preorder, inMap, 0, preorder.length - 1, 0, inorder.length - 1);
  
    }

    private TreeNode helper(int[] preorder,  Map<Integer, Integer> inMap, int pre_l, int pre_r, int in_l, int in_r) {

        if (in_l > in_r) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pre_l]);
        int left_size = inMap.get(root.val) - in_l;
          // 注意preorder 和 inorder 左右子树的起始位置是不一样的
        root.left = helper(preorder, inMap, pre_l + 1, pre_l + left_size, in_l , in_l + left_size - 1);
        root.right = helper(preorder, inMap, pre_l + left_size + 1, pre_r, in_l + left_size + 1, in_r);
        return root;
    }
}
