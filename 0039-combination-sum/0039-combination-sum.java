class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currArr = new ArrayList<>();

        // Initial call
        recursive(candidates,0, target, currArr, ans);

        return ans;

    }
    private void recursive(
        int[] candidates,
        int idx,
        int target,
        List<Integer> currArr,
        List<List<Integer>> ans
    ){
        // BaseCase
        if(target == 0){
            ans.add(new ArrayList(currArr));
            return;
        }
        if(target < 0){  // if target become -ve
            return;
        }
        if(idx == candidates.length){
            return;
        }

        currArr.add(candidates[idx]);
        recursive(candidates,idx, target - candidates[idx], currArr, ans);  // yaha par idx+1 nhi kiya coz hum wo didgit ko firse ue karsakte hai

        currArr.remove(currArr.size() -1);
        recursive(candidates,idx+1, target, currArr, ans); // moving to next didgit
    }
}