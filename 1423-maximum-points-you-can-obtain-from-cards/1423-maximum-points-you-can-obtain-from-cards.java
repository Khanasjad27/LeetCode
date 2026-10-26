class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lSum = 0;
        int rSum = 0;
        int maxSum = Integer.MIN_VALUE;

        // finding first k value
        for(int i=0; i<=k-1; i++){
            lSum+= cardPoints[i];
        }
        maxSum = lSum;  // initially wahi hoga max sum

        // now we r going to add from right n sub from left
        int rIndex = cardPoints.length-1;
        for(int i=k-1; i>=0; i--){
            lSum -= cardPoints[i];
            rSum += cardPoints[rIndex];
            rIndex--;

            maxSum = Math.max(maxSum, (lSum + rSum));
        }
        return maxSum;
    }
}