class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // hum array ko sort karre hia coz hame answer soretd order me chiye n for checking ki pichli value is equal or not
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currAns = new ArrayList<>();

        // Initial call
        recursive(candidates, 0, target, currAns, ans);

        return ans;

    }

    private void recursive(
            int[] candidates,
            int idx,
            int target,
            List<Integer> currAns,
            List<List<Integer>> ans) {
        // BaseCase  => agar target == 0 hojaae matlab humko humko hamara answer milgaya
        if (target == 0) {
            ans.add(new ArrayList<>(currAns));
            return;
        }
        
        for(int i=idx; i<candidates.length;i++){
            // jab in array 2 value same hai then aage baro to nxt iteration
            if(i > idx && candidates[i] == candidates[i - 1]) continue;
            // agar curr number bara hai to target then no need to aage check direct break
            if(candidates[i] > target) break;

            currAns.add(candidates[i]);
            recursive(candidates, i+1, target-candidates[i], currAns, ans);
            currAns.remove(currAns.size()-1);

        }
    }
}
