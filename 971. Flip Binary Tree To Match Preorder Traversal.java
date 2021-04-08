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
    
    int i = 0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        
        List<Integer> res = new ArrayList<>();
        if (dfs(root, voyage, res)) {
            return res;
        }
        return Arrays.asList(-1); 
    }
    
    private boolean dfs(TreeNode root, int[] voyage,  List<Integer> res) {
        
        if (root == null) {
            return true;
        }
        if (root.val != voyage[i++]) {
            return false;
        }
        
        if (root.left != null && root.left.val != voyage[i]) {
            res.add(root.val);
            return dfs(root.right, voyage, res) && dfs(root.left, voyage, res);
        }
         return dfs(root.left, voyage, res) && dfs(root.right, voyage, res);
    }
}