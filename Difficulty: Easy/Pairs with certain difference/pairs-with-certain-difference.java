class Solution {
    public int sumDiffPairs(int[] arr, int k) {
        // code here
     int n = arr.length;

        if (n < 2) return 0;

        java.util.Arrays.sort(arr);

        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1];

            if (arr[i] - arr[i - 1] < k) {
                int pairSum = arr[i] + arr[i - 1];

                if (i >= 2) {
                    pairSum += dp[i - 2];
                }

                dp[i] = Math.max(dp[i], pairSum);
            }
        }

        return dp[n - 1];    
    }
}