class Solution {
    private void backtracking(int openPar,int closePar, List<String> result, StringBuilder curr, int n){
        // BaseCase 
        if (openPar == n && closePar == n) {
            result.add(curr.toString());
            return;
        }

        if(openPar < n){
            curr.append("(");
            backtracking(openPar+1,closePar,result,curr, n);
            curr.deleteCharAt(curr.length() - 1);
        }

        if(closePar < openPar){
           curr.append(")");
            backtracking(openPar,closePar+1,result,curr, n);
             curr.deleteCharAt(curr.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int openPar = 0;
        int closePar = 0;
        backtracking(openPar,closePar,result,new StringBuilder(), n);

        return result;
    }
}