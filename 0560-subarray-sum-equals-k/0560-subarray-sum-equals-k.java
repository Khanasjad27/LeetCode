class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Long, Integer> map = new HashMap<>(); // here we will be storing prefixSum and count

        // Initially map pe (0,1) store karra hu coz we have see ki jab hum calucutae karege to ek aisa pt aaega jaha hame 3-3 = 0 lagega and at that pt ye kaam aega tat this is already store
        map.put(0L,1);
        long prefixSum = 0;
        int count = 0;

        for(int i=0; i<nums.length; i++){
            prefixSum+= nums[i];

            long remamingSum = prefixSum - k;
            // Agar remaining sum pehle mil chuka hai, toh uski saari frequencies add kar do
            if(map.containsKey(remamingSum)){
                count += map.get(remamingSum); // jab hum map.get karte hai tab hum ko uski value milti hai jo ki hum count++ karne me use karege since we are adding count in value(key, value) me
            }

            // Current prefix sum ki frequency map mein update karo
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) +1);
        }
        return count;
    }
}