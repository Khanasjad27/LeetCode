class Solution {
    void recursion(String s,int idx, List<String> path, List<List<String>> ans){
        // jaise hi hamara idx string ke end pe cala jaae waise hi add kardo
        if(idx == s.length() ){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = idx; i<s.length(); i++){
            if(isPalendrom(s, idx, i)){  // agar stinrg palndrom hai to hi resursion hoga
                path.add(s.substring(idx, i+1));
                recursion(s, i+1, path, ans);   // moving to nxt iteration fro idx to i+1
                path.remove(path.size()-1);
            }
        }
    } 

    boolean isPalendrom(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<String> path = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();

        recursion(s, 0, path, ans);

        return ans;
    }
}