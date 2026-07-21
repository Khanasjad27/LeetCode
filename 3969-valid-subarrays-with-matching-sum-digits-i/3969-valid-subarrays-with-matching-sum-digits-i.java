class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        long count = 0;
        
        for(int i=0; i<nums.length; i++){
            long sum = 0;
            for(int j=i;j<nums.length; j++){
                sum += nums[j];

                long last = sum % 10;
                long first = sum;
                while(first >= 10){
                    first/=10;
                } 

                if(first == x && last == x){
                    count++;
                }
            }

        }

        return (int)count;
    }
}