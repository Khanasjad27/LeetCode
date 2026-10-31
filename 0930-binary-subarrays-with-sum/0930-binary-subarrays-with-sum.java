class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // Hashing technique  => T.C(0(N)) S.C(0(N))

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int prefixSum = 0;
        int count = 0;

        for(int i=0; i<nums.length; i++){
            prefixSum += nums[i];

            int remainingValue = prefixSum - goal;

            if(map.containsKey(remainingValue)){
                count += map.get(remainingValue);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) +1);
        }
        return count;
        
    }
}