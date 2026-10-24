class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0; int high = n-1;
        int mn = Integer.MAX_VALUE;

        while(low<= high){
            int mid = (low + high)/2;

            if(nums[low] <= nums[mid]){
                mn = Math.min(mn, nums[low]);
                low = mid+1;
            }else{
                mn = Math.min(mn, nums[mid]);
                high = mid-1;
            }
        }
        return mn;
    }
}