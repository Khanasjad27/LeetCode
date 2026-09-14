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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        RSV(root, result, 0);
        return result;
    }

    private void RSV(TreeNode root, List<Integer> ans, int currDepth) {
        // BaseCase
        if (root == null)
            return;
        // reverse preorder => Right -> Left -> root
        // Checking ki phele baar encounter hua hua => agar pheli baar hua hai then add karege
        if (currDepth == ans.size()) { // since har level par ek hi value store hogi therefore data struccture ka size bhi gradually increase hoga therefore agar depth aur list ki size same hai tho wo first time encounter hora hai and since hun phele right to dekh rahe hai therefore usko store
            ans.add(root.val);
        }
        RSV(root.right, ans, currDepth + 1);
        RSV(root.left, ans, currDepth + 1);
    }
}