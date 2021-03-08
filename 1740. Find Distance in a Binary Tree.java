/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int findDistance(TreeNode root, int p, int q) {
        
        TreeNode lca = getLCA(root, p, q);
        return getDist(lca, p, 0) + getDist(lca, q, 0);
    }
    
    private TreeNode getLCA(TreeNode root, int p, int q) {
        
       if (root == null || root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = getLCA(root.left, p, q);
        TreeNode right = getLCA(root.right, p, q);
        
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
    
    private int getDist(TreeNode root, int target, int dist) {
        
        if (root == null) {
            return -1;
        }
        
        if (root.val == target) {
            return dist;
        }
        
        int left = getDist(root.left, target, dist + 1);
        int right = getDist(root.right, target, dist + 1);
        return left != -1 ? left : right;   
    }
}