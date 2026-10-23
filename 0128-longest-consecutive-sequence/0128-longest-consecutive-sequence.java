class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);

        int longest = 1;
        int currCount = 0;
        int lastSmallest = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            if(nums[i]-1 == lastSmallest){
                currCount++;
                lastSmallest = nums[i];
            }else if(nums[i] != lastSmallest){
                currCount = 1;
                lastSmallest = nums[i];
            }

            longest = Math.max(longest, currCount);
        }

        return longest;
    }
}