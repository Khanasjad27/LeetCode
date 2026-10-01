class Solution {
    public void swap(int a, int b){
        a = a + b;
        b = a-b; 
        a = a-b;
    }
    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < 0){
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }
            maxSoFar = Math.max(nums[i], maxSoFar * nums[i]);
            minSoFar = Math.min(nums[i], minSoFar * nums[i]);
            
            result = Math.max(result, maxSoFar);
        }
        return result;
    }
}