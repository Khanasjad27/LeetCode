class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numToIdx = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int remaingValue = target - nums[i];

            if(numToIdx.containsKey(remaingValue)){
                return new int[] { numToIdx.get(remaingValue),i };
            }

            numToIdx.put(nums[i], i);
        }
        return new int[] {};
    }
}