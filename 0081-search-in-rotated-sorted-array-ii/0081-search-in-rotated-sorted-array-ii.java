class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = (low+high)/2;

            if(nums[mid] == target){
                return true;
            }
            
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
            }else if(nums[low] <= nums[mid]){
                if(target <= nums[mid] && target >= nums[low]){
                    high = mid -1;
                }else{
                    low = mid+1;
                }
            }else {
                if(target <= nums[high] && target >= nums[mid+1]){
                    low = mid+1;
                }else{
                    high = mid;
                }
            }
        }
        return false;
    }
}