import java.util.Arrays;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        
        // Sort by start time
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(0, jobs, memo);
    }
    
    private int dfs(int idx, int[][] jobs, int[] memo) {
        if (idx >= jobs.length) return 0;
        if (memo[idx] != -1) return memo[idx];
        
        // Option 1: Skip
        int skip = dfs(idx + 1, jobs, memo);
        
        // Option 2: Take -> Binary search for next valid job index
        int low = idx + 1, high = jobs.length - 1, next = jobs.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (jobs[mid][0] >= jobs[idx][1]) {
                next = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        int take = jobs[idx][2] + dfs(next, jobs, memo);
        
        return memo[idx] = Math.max(skip, take);
    }
}
