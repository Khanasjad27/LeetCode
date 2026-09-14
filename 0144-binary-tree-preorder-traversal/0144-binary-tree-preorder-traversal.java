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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preeOrder(root, result);
        return result;
    }

    private void preeOrder(TreeNode root, List<Integer> result) {
        // Base CAse
        if (root == null) return;

        result.add(root.val);
        preeOrder(root.left, result);
        preeOrder(root.right, result);
    }
}