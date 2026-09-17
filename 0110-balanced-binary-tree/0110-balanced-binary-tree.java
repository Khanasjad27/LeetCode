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
    private int balanceCheck(TreeNode root){
        if(root == null){
            return 0;
        }

        int lh = balanceCheck(root.left);
        int rh = balanceCheck(root.right);

        if(lh == -1 || rh == -1 ){
            return -1;
        }

        if(Math.abs(lh - rh) > 1 ){
            return -1;
        }
        return Math.max(lh,rh) +1;

    }
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int ans = balanceCheck(root);
        
        if(ans == -1){
            return false;
        }
        return true;
    }
}