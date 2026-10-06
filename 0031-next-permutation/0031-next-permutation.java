class Solution {
    private void reverse(int[] nums, int start, int end){
        
        if (nums == null || nums.length <= 1) {
            return;
        }

        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
           
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;
        // Longest prefix match
        for(int i=(n-2); i>=0; i--){
            if(nums[i] < nums[i+1]){
                idx = i;
                break;
            }
        }
        // if at last permutation then we will reverse it
        if(idx == -1){
            reverse(nums,0, n-1);
            return;
        }

        for(int i=n-1; i>=0; i--){
            if(nums[i] > nums[idx]){
                swap(nums, i, idx);
                break;
            }
        }

        reverse(nums, idx+1, n-1);

    }
}