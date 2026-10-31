class Solution {
    public int numSubarraysWithSumLessNEqual(int[] nums, int goal) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int count = 0;

        if (goal < 0)
            return 0; // ye tab keliye hai jab goal zero diya hoga n goal-1 = -1 hoga to hamare main fn me error aajaega

        while (j < nums.length) {
            sum += nums[j];

            while (sum > goal) {
                sum -= nums[i];
                i++;
            }
            count += (j - i + 1); // j-i+1 => total sub array in range of i n j
            j++;

        }

        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        // // Hashing technique  => T.C(0(N)) S.C(0(N))
        // // for details explanation refer (560. Subarray Sum Equals K)

        // HashMap<Integer, Integer> map = new HashMap<>();
        // map.put(0,1);
        // int prefixSum = 0;
        // int count = 0;

        // for(int i=0; i<nums.length; i++){
        //     prefixSum += nums[i];

        //     int remainingValue = prefixSum - goal;

        //     if(map.containsKey(remainingValue)){
        //         count += map.get(remainingValue);
        //     }

        //     map.put(prefixSum, map.getOrDefault(prefixSum, 0) +1);
        // }
        // return count;

        // now reducing the Space Complexity to 0(1)
        // Tc = 0(2N) ==> coz 2 while loop use hua hai
        return numSubarraysWithSumLessNEqual(nums, goal) - numSubarraysWithSumLessNEqual(nums, goal - 1);

    }
}