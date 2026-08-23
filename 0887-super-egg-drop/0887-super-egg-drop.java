class Solution {

    // TLE
    // private int recursiveSol(int k, int n){
    //     // BaseCase => agar 0 ya 1 floor hi hia to wahi return kardo
    //     if(n == 0 || n == 1){
    //         return n;
    //     }
    //     // BaseCase => agar ek hi egg hai to usko we will drop from 1st to k floor and itna walue hai wo return hoga
    //     if(k == 1){ 
    //         return n;
    //     }

    //     // travelling from 1st floor to nth floor
    //     int minEgg = Integer.MAX_VALUE;

    //     for(int i = 1; i <= n; i++){
    //         int temp = 1 + Math.max(recursiveSol(k - 1, i - 1), recursiveSol(k, n - i));
    //         minEgg = Math.min(minEgg, temp);
    //     }
    //     return minEgg;
    // }

    // Optimization
    private int[][] dp;

    private int recursiveSol(int egg, int floor) {
        // BaseCase1
        if (floor == 0 || floor == 1) {
            return floor;
        }
        // BaseCase 2
        if (egg == 1) {
            return floor;
        }
        // BaseCase 3 => if number is not -1 then there must be exists some value, return that value
        if (dp[egg][floor] != -1) {
            return dp[egg][floor];
        }

        int start = 1;
        int end = floor;
        int minDrop = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Broken egg
            int broke = recursiveSol(egg - 1, mid - 1);
            // Egg not broken
            int notBroke = recursiveSol(egg, floor - mid);

            //finding worst case egg drop value
            int worstCase = 1 + Math.max(broke, notBroke);

            // Finding min egg drop 
            minDrop = Math.min(minDrop, worstCase);

            if (broke > notBroke) {
                end = mid - 1;// if broke is more thr niche find karna hai
            } else {
                start = mid + 1;
            }
        }
        return dp[egg][floor] = minDrop;
    }

    public int superEggDrop(int k, int n) {
        dp = new int[k + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return recursiveSol(k, n);
    }
}
