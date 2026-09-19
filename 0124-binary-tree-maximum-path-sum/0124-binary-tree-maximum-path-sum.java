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
    public int maxPathSum(TreeNode root) {
        int maxi[] = new int[1];
        maxi[0] = Integer.MIN_VALUE; // since directly we can't pass - infinity value therefore hum array pass karre hai n usme hum 0th index pe max store karre hai
        maxSum(root, maxi);

        return maxi[0];
    }

    private int maxSum(TreeNode root, int maxi[]) {
        if (root == null)
            return 0;

        int maxLeft = Math.max(0, maxSum(root.left, maxi));
        int maxRight = Math.max(0, maxSum(root.right, maxi));

        maxi[0] = Math.max(maxi[0], maxLeft + maxRight + root.val);

        return ((root.val) + Math.max(maxLeft, maxRight));
    }
}