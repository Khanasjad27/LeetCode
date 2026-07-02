class Solution {
    private void recursivePermutate(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] freq ){
        // Base Case
        if(ds.size()== nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(!freq[i]){
                freq[i] = true;
                ds.add(nums[i]);
                recursivePermutate(nums, ds, ans, freq);
                ds.remove(ds.size()-1);
                freq[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        recursivePermutate(nums, ds, ans, freq);
        return ans;
    }
}