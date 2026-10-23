class Solution {
    public int findPeakElement(int[] nums) {
        int maxEle = Integer.MIN_VALUE;
        int maxIdx = 0;
        for (int i=0; i<nums.length; i++){
            if(maxEle < nums[i]){
                maxEle = nums[i];
                maxIdx = i;
            }
        }

        return maxIdx;
    }
}