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


// apna yahi aproch hai ki phele level oder traversal karte hia then 
// hum ek check lagaege ki leftToRight hai ki nhi usse pata chalega konsa position currently print hora hai then jub wo set hojaaega then flip
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Boolean LeftToRight = true;
        if(root == null){
            return result;
        }

        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> currAns = new ArrayList<>();
            int size = q.size();

            for (int i = 0; i <size; i++) {
                TreeNode currNode = q.remove();

                if (LeftToRight) {
                    currAns.add(currNode.val);
                } else {
                    currAns.add(0, currNode.val);  // ye kya karega ki jo bhi new aaega element usko 0th iindex pe daalega so gernally agar element 12, 13, 16 aate to wo ye hi order me jaate lakin ye karne se 16, 13, 12 ise jaaege jisse automitiaclly reverse hojaaega
                }

                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
            result.add(currAns);
            // / Flip the direction for the next level
            LeftToRight = !LeftToRight;
        }
        return result;
    }
}