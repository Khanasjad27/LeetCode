class Solution {
    public int[] findDegrees(int[][] matrix) {
        int[] ans = new int[matrix.length];
        int count = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                if(matrix[i][j] != 0){
                    count++;
                }
            }
            ans[i] = count;
            count = 0;
        }
        return ans;
    }
}