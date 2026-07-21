class Solution {
    public String[] createGrid(int m, int n) {

        // Initially we created an 2D char Array
        char[][] grid = new char[m][n];

        // filled that with '#'
        for(int i=0; i<m; i++){
            Arrays.fill(grid[i], '#');
        }

        // initiialize the varible n make strating pt as '.'
        int c = 0;
        int r = 0;
        grid[r][c] = '.';

        // now we r moving in 2D array an creating a path for us
        // right move
        while(r < m-1){
            r++;
            grid[r][c] = '.';
        }
        //down move
        while(c < n-1){
            c++;
            grid[r][c] = '.';
        }
        // converting 2D array to String 1D array
        String[] ans = new String[m];

        for(int i=0; i<m; i++){
            ans[i] = new String(grid[i]);
        }

        return ans;
    }
}