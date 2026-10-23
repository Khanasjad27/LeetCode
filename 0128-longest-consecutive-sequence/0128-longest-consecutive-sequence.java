class Solution {
    public int longestConsecutive(int[] nums) {
        // // base case if Array is empty then return zero
        // if(nums.length == 0){
        //     return 0;
        // }
        // Arrays.sort(nums);

        // int longest = 1;
        // int currCount = 0;
        // int lastSmallest = Integer.MIN_VALUE;

        // for(int i=0; i<nums.length; i++){
        //     if(nums[i]-1 == lastSmallest){
        //         currCount++;
        //         lastSmallest = nums[i];
        //     }else if(nums[i] != lastSmallest){
        //         currCount = 1;
        //         lastSmallest = nums[i];
        //     }

        //     longest = Math.max(longest, currCount);
        // }

        // return longest;

        // 2 -> Optimal Solution

        // BaseCase
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        for (int num : set) {
            // Check if this number is the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}