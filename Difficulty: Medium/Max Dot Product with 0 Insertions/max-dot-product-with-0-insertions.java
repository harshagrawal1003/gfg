class Solution {
    public int maxDotProduct(int[] a, int[] b) {
           int n = a.length;
        int m = b.length;
        long NEG = Long.MIN_VALUE / 2;
        long[][] dp = new long[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) 
                dp[i][j] = NEG;
        }
        for (int i = 0; i <= n; i++) 
            dp[i][m] = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (n - i < m - j)
                    continue;
                long take = 1L * a[i] * b[j] + dp[i + 1][j + 1];
                long skip = dp[i + 1][j];
                dp[i][j] = Math.max(take, skip);
            }
        }
        return (int) dp[0][0];
    }
}