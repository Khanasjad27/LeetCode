class Solution {
    private int maxIdx(int[][] mat, int n, int m, int col){
        int maxVal = -1;
        int idx = -1;

        for(int i=0; i<n; i++){
            if(mat[i][col] >maxVal){
                maxVal = mat[i][col];
                idx = i;
            }
        }
        return idx;
    }
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0;
        int high = m-1;

        while(low <= high){
            int mid = (low+high)/2;

            int maxRowIdx = maxIdx(mat, n, m, mid);

            int left =( mid-1 >= 0) ? mat[maxRowIdx][mid-1] : -1;  // max waale ele ke left wala ele
            int right =( mid+1 < m )? mat[maxRowIdx][mid+1] : -1;  // max waale ele ke right wala ele

            // checking ki if the condition is satified or not
            if(mat[maxRowIdx][mid] > left && mat[maxRowIdx][mid] > right){
                return new int[] {maxRowIdx, mid};
            }else if(mat[maxRowIdx][mid] < left){ // if less then left then serach in right wala part
                high = mid-1;
            }else{ 
                low = mid+1;
            }
        }

         return new int[] {-1, -1};
    }
}