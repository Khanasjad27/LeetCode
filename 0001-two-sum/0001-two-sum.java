class Solution {
    public int[] twoSum(int[] nums, int target) {

        // HashMap banaya hai jisme
        // Key = Array ka element
        // Value = Us element ka index
        HashMap<Integer, Integer> numToIdx = new HashMap<>();

        // Pure array ko ek baar traverse karenge
        for (int i = 0; i < nums.length; i++) {

            // Current element ke liye required complement nikala
            // jisse add karke target ban sake
            int remainingValue = target - nums[i];

            // Agar complement pehle se HashMap me present hai
            // matlab pair mil gaya
            if (numToIdx.containsKey(remainingValue)) {

                // Complement ka index aur current index return kar do
                return new int[] { numToIdx.get(remainingValue), i };
            }

            // Agar pair nahi mila
            // to current element aur uska index HashMap me store kar do
            numToIdx.put(nums[i], i);
        }

        // Agar koi pair nahi mila to empty array return kar do
        return new int[] {};
    }
}