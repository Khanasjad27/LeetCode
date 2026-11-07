class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Pehle array ko sort karte hain taaki duplicates paas-paas aa jayein
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currAns = new ArrayList<>();
        
        // Initial call se backtracking start karte hain
        backtrack(nums, 0, currAns, ans);
        return ans;
    }
    
    private void backtrack(int[] nums, int idx, List<Integer> currAns, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(currAns));
        
        for (int i = idx; i < nums.length; i++) {
            // Yeh condition duplicate subsets ko skip karne ke liye hai:
            // Agar current element apne se pehle wale element ke barabar hai, 
            // aur woh current recursion level ka pehla element nahi hai (i != idx),
            // toh use skip kar do taaki same subset dobara na bane.
            if (i != idx && nums[i] == nums[i - 1]) 
                continue;
                
            currAns.add(nums[i]);
            backtrack(nums, i + 1, currAns, ans);
            currAns.remove(currAns.size() - 1);
        }
    }
}