class Solution {
    void recursion(String digits,int idx,StringBuilder output,String[] mapping, List<String> ans){
        // Base Case: Saare digits khatam toh answer list me save karo
        if(idx >= digits.length()){
            ans.add(output.toString());
            return;
        }

        int currNum = digits.charAt(idx) - '0';
        String currNumMappingValue = mapping[currNum];

        for(int i=0; i<currNumMappingValue.length(); i++){
            // Choice: Character add karo
            output.append(currNumMappingValue.charAt(i));
            
            // Next digit ke liye explore karo
            recursion(digits, idx+1, output, mapping, ans);
            
            // Backtrack: Last added character remove karo
            output.deleteCharAt(output.length() - 1); 
        }
    }
    public List<String> letterCombinations(String digits) {
        String[] mapping = {" ", " ", "abc" , "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        int idx = 0;

        if(digits.length() == 0){
            return ans;
        }

        recursion(digits, idx, new StringBuilder(), mapping, ans);
        return ans;
    }
}
