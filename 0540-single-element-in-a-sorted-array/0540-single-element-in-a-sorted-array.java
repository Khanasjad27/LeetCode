class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int low = 1;
        int high = n-2;

        if(n == 1) return nums[0]; // agar ek hi element hai to wahi answer hoga
        //edge case
        if(nums[0] != nums[1]) return nums[0];  // agar oth idx elem not equal to 1st idx ele then wahi single ele hai
        if(nums[n-1] != nums[n-2]) return nums[n-1]; // same logic as above

        while(low<= high){

            int mid = (low + high) /2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }else if( 
                (mid%2 == 0 && nums[mid] == nums[mid+1]) // agar mid even hai and uske right wala same hia then ye waale part ko elemenate karge
             ||
                (mid%2 == 1 && nums[mid] == nums[mid-1]) // agar mid odd hai and uske left wala same hia then ye waale part ko elemenate karge
            ){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}