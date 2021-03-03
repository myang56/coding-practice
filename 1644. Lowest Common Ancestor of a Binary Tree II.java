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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null) {
            return null;
        }
        if (!isInTree(root, p) || !isInTree(root, q)) {
             return null;
        }
         return helper(root, p, q);
     
    }
    
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null || root == p || root == q) {
           return root;
        }
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);
        
        if (left != null && right != null) {
            return root;
        }
        
        return left == null ? right : left;
    }
    
    private boolean isInTree(TreeNode root, TreeNode node) {
        
        if (root == null) {
            return false;
        }
        
        if (root == node) {
            return true;
        }
        boolean left = isInTree(root.left, node);
        boolean right = isInTree(root.right, node);
        return left || right;
    }
}