class Solution {
    public int waysToIncreaseLCSBy1(String s1, String s2) {
        // code here
         int n = s1.length();
        int m = s2.length();
        int[][] prefix = new int[n + 1][m + 1];
        int[][] suffix = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    prefix[i][j] = 1 + prefix[i - 1][j - 1];
                } else {
                    prefix[i][j] = Math.max(prefix[i - 1][j],
                                            prefix[i][j - 1]);
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    suffix[i][j] = 1 + suffix[i + 1][j + 1];
                } else {
                    suffix[i][j] = Math.max(suffix[i + 1][j],
                                            suffix[i][j + 1]);
                }
            }
        }
        int lcs = prefix[n][m];
        int count = 0;
        for (int i = 0; i <= n; i++) {
            boolean[] valid = new boolean[26];
            for (int j = 0; j < m; j++) {
                int left = prefix[i][j];
                int right = suffix[i][j + 1];
                if (left + 1 + right == lcs + 1) {
                    valid[s2.charAt(j) - 'a'] = true;
                }
            }
            for (boolean value : valid) {
                if (value) {
                    count++;
                }
            }
        }
        return count;
    }
}