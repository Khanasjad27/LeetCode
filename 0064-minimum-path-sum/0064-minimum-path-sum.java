class Solution {
    // GOT TLE
    // private int recursiveSol(int[][] grid, int i, int j) {
    //     // Base Case 1: Out of bounds (Return a huge number so this path isn't chosen)
    //     if (i >= grid.length || j >= grid[i].length) {
    //         return Integer.MAX_VALUE;
    //     }

    //     // Base Case 2: Reached the absolute end position (bottom-right corner)
    //     if (i == grid.length - 1 && j == grid[0].length - 1) {
    //         return grid[i][j];
    //     }

    //     // Move right
    //     int right = recursiveSol(grid, i, j + 1);

    //     // Move down
    //     int down = recursiveSol(grid, i + 1, j);
    //     // Add current cell value to the cheaper choice between right and down
    //     return grid[i][j] + Math.min(right, down);
    // }

    // Memoization
    private int recursiveSol(int[][] grid, int[][] dp, int i, int j) {
        // Base Case 1: Out of bounds (Return a huge number so this path isn't chosen)
        if (i >= grid.length || j >= grid[i].length) {
            return 1000000000;
        }

        // Base Case 2: Reached the absolute end position (bottom-right corner)
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        // BaseCase 3
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Move right
        int right = recursiveSol(grid, dp, i, j + 1);

        // Move down
        int down = recursiveSol(grid, dp, i + 1, j);
        // Add current cell value to the cheaper choice between right and down
        return dp[i][j] = (grid[i][j] + Math.min(right, down));
    }

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        // Fill each row of the memoization grid with -1 to mark them as unvisited
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return recursiveSol(grid, dp, 0, 0);
    }
}