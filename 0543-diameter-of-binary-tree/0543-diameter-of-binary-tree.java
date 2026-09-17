class Solution {
    private int maxDiameter = 0; // Global variable to store the longest path found so far

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);          // Kicks off the recursive traversal from the root
        return maxDiameter;    // Returns the final maximum diameter found
    }

    private int height(TreeNode node) {
        // Base case: If the node is null, its height is 0 edges.
        if (node == null) {
            return 0; 
        }
        
        // 1. Recursively get the height of the left and right subtrees (number of edges)
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        
        // 2. Calculate the longest path passing *through* the current node.
        // It's the sum of the edges going down the left side plus the edges going down the right side.
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);
        
        // 3. Return the height of the current node to its parent.
        // The height is the maximum height of its children + 1 (accounting for the edge connecting to this node).
        return Math.max(leftHeight, rightHeight) + 1;
    }
}