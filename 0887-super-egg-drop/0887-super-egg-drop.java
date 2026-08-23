import java.util.Arrays;

class Solution {
    // Memoization table to store precomputed results
    private int[][] memo;

    private int solve(int egg, int floor) {
        // Base Case 1: If 0 or 1 floor, we need 0 or 1 drops
        if (floor == 0 || floor == 1) {
            return floor;
        }
        // Base Case 2: If only 1 egg, we must test every floor from bottom to top
        if (egg == 1) {
            return floor;
        }

        // Return cached result if already calculated
        if (memo[egg][floor] != -1) {
            return memo[egg][floor];
        }

        int minDrops = Integer.MAX_VALUE;
        int low = 1, high = floor;

        // Use Binary Search instead of a linear loop to find the optimal floor
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Egg breaks: search lower floors with 1 less egg
            int breakCase = solve(egg - 1, mid - 1);
            
            // Egg survives: search higher floors with same number of eggs
            int surviveCase = solve(egg, floor - mid);

            // We take the worst-case scenario between breaking and surviving
            int worstCase = 1 + Math.max(breakCase, surviveCase);
            
            // We want to minimize this worst-case outcome
            minDrops = Math.min(minDrops, worstCase);

            // Move pointers based on which scenario is more expensive
            if (breakCase > surviveCase) {
                high = mid - 1; // Try lower floors to decrease breakCase cost
            } else {
                low = mid + 1;  // Try higher floors to decrease surviveCase cost
            }
        }

        return memo[egg][floor] = minDrops;
    }

    public int superEggDrop(int k, int n) {
        // Initialize memoization table with -1
        memo = new int[k + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return solve(k, n);
    }
}
