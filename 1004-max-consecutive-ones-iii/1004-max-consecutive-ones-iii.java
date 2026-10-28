class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxL = -1;
       int l = 0; // left
       int r = 0; // right
       int zeros = 0;

       while(r< nums.length){
            int len = 0;
            if(nums[r] == 0) zeros++;
            while(zeros > k){
                if(nums[l] == 0) zeros--;
                l++;

            }
            if(zeros<=k){
                int currL = r-l+1;
                maxL = Math.max(currL, maxL);
            }
            r++;
       }

       return maxL;
    }
}