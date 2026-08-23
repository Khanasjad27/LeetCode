import java.util.*;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        // Using Boolean instead of boolean allows null to represent unvisited states
        Boolean[] memo = new Boolean[s.length()];
        return dfs(s, 0, wordSet, memo);
    }
    
    private boolean dfs(String s, int start, Set<String> wordSet, Boolean[] memo) {
        // Base case: successfully reached the end of the string
        if (start == s.length()) {
            return true;
        }
        
        // Return cached result if already calculated
        if (memo[start] != null) {
            return memo[start];
        }
        
        // Partition the string from the current start index to the end
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordSet.contains(s.substring(start, end)) && dfs(s, end, wordSet, memo)) {
                return memo[start] = true;
            }
        }
        
        return memo[start] = false;
    }
}
