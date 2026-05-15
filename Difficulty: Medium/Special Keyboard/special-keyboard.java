class Solution {
    public long optimalKeys(int n) {
        // code here
        
        long[] dp = new long[n + 1];

        for(int i = 1; i <= n; i++) {

            // Press A directly
            dp[i] = i;

            // Try all break points
            for(int j = 1; j <= i - 3; j++) {

                long curr = dp[j] * (i - j - 1);

                dp[i] = Math.max(dp[i], curr);
            }
        }

        return dp[n];

    }
}