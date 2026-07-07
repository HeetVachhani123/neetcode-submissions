/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // A null tree cannot contain a non-null subRoot
        if (root == null) {
            return false;
        }
        
        // Check if the current tree starting at 'root' is identical to 'subRoot'
        if (isSameTree(root, subRoot)) {
            return true;
        }
        
        // If not, look recursively into the left and right children
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    // Helper function to check if two trees are structurally identical
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}