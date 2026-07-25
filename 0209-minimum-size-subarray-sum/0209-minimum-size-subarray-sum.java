class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sum = 0;

        int i=0, j=0,l=0, minl=Integer.MAX_VALUE; // i = windowStart, j = windowEnd

        while(j < n){
            //Expansion Phase
            sum += nums[j];
            if(sum >= target){
                l = (j-i+1); // yaja hame target jaise hi milgaya humne uski length store karli
                minl = Math.min(minl, l);
                //Shrinking Phase
                while(i < j && sum >= target){
                    sum = sum - nums[i];
                    i++;
                    // agar sum abhi bhi target se bada aara hia or equal aara hia then ya bhi ek possible answer ho sakta hia
                    if(sum >= target){
                        l = (j-i+1); 
                        minl = Math.min(minl, l);
                    }
                }
            }
            j++;
        }
        return  (minl==Integer.MAX_VALUE) ? 0: minl;
    }
}