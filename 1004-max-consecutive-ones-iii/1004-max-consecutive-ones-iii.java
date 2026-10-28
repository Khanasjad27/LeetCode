class Solution {
    public int longestOnes(int[] nums, int k) {

        //T.C => 0(2N)
        //     int maxL = -1;
        //    int l = 0; // left
        //    int r = 0; // right
        //    int zeros = 0;

        //    while(r< nums.length){
        //         int len = 0;
        //         if(nums[r] == 0) zeros++;
        //         while(zeros > k){
        //             if(nums[l] == 0) zeros--;
        //             l++;

        //         }
        //         if(zeros<=k){
        //             int currL = r-l+1;
        //             maxL = Math.max(currL, maxL);
        //         }
        //         r++;
        //    }

        //    return maxL;

        // Optimize version => T.C => 0(N)
        int maxL = -1;
        int l = 0; // left
        int r = 0; // right
        int zeros = 0;

        while (r < nums.length) {
            if (nums[r] == 0)
                zeros++;

            if (zeros > k) {
                if(nums[l] == 0) zeros--;
                l++;
            } 
            if(zeros<=k){
                int currL = r-l+1;
                maxL= Math.max(maxL, currL);
            }
            r++;
        }
        return maxL;
    }
}