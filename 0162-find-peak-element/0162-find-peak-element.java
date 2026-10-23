class Solution {
    public int findPeakElement(int[] nums) {
        //code in O(LogN)

        int n = nums.length;
        if(n==1) return 0 ; // agar ek hi elememnt hai to usko hi return kadrde
        // edge case=> since bola hai dono end me -infinity hai therefore 1st n last elemt check karege age agar wo 2nd waale se ya 2nd last waale se bada aagaya to no need to check in binary Seaarch
        

        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        int l = 1; 
        int h = n-2;

        while(l<=h){
            int mid = (l+h)/2;

            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }else if(nums[mid] > nums[mid -1]){  // increasing slope
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
        return -1;
    }
}