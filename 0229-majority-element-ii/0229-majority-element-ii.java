class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        Integer ele1 = null, ele2 = null;

        // Step 1: Find potential candidates
        for (int num : nums) {
            if (ele1 != null && ele1 == num) {
                count1++;
            } else if (ele2 != null && ele2 == num) {
                count2++;
            } else if (count1 == 0) {
                ele1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                ele2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify actual counts
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (ele1 != null && num == ele1) count1++;
            else if (ele2 != null && num == ele2) count2++;
        }

        List<Integer> ans = new ArrayList<>();
        int threshold = nums.length / 3;
        
        if (ele1 != null && count1 > threshold) {
            ans.add(ele1);
        }
        if (ele2 != null && count2 > threshold && !ele1.equals(ele2)) {
            ans.add(ele2);
        }
        return ans;
    }
}