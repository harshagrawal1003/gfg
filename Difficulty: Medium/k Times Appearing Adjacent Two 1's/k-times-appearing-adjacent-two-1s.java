class Solution {
     static final int MOD = 1000000007;

    public int countStrings(int n, int k) {
        // code here
           long[][] dp0 = new long[n + 1][k + 1];
        long[][] dp1 = new long[n + 1][k + 1];

        dp0[1][0] = 1;
        dp1[1][0] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j++) {

                dp0[i][j] = (dp0[i - 1][j] + dp1[i - 1][j]) % MOD;

                dp1[i][j] = dp0[i - 1][j];

                if (j > 0) {
                    dp1[i][j] = (dp1[i][j] + dp1[i - 1][j - 1]) % MOD;
                }
            }
        }

        return (int) ((dp0[n][k] + dp1[n][k]) % MOD);
    }
}