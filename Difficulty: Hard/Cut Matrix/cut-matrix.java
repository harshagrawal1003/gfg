class Solution {
    private static final int MOD = 1_000_000_007;

    public int findWays(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] suffixOnes = new int[rows + 1][cols + 1];

        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                suffixOnes[row][col] = matrix[row][col]
                        + suffixOnes[row + 1][col]
                        + suffixOnes[row][col + 1]
                        - suffixOnes[row + 1][col + 1];
            }
        }

        int[][] nextRow = new int[rows][cols];
        int[][] nextCol = new int[rows][cols];

        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                nextRow[row][col] = rows;
                nextCol[row][col] = cols;

                if (row + 1 < rows) {
                    if (suffixOnes[row][col] > suffixOnes[row + 1][col]) {
                        nextRow[row][col] = row + 1;
                    } else {
                        nextRow[row][col] = nextRow[row + 1][col];
                    }
                }

                if (col + 1 < cols) {
                    if (suffixOnes[row][col] > suffixOnes[row][col + 1]) {
                        nextCol[row][col] = col + 1;
                    } else {
                        nextCol[row][col] = nextCol[row][col + 1];
                    }
                }
            }
        }

        int[][] dp = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (suffixOnes[row][col] > 0) {
                    dp[row][col] = 1;
                }
            }
        }

        for (int pieces = 2; pieces <= k; pieces++) {
            int[][] columnSum = new int[rows + 1][cols];
            int[][] rowSum = new int[rows][cols + 1];

            for (int row = rows - 1; row >= 0; row--) {
                for (int col = cols - 1; col >= 0; col--) {
                    columnSum[row][col] = (columnSum[row + 1][col] + dp[row][col]) % MOD;
                    rowSum[row][col] = (rowSum[row][col + 1] + dp[row][col]) % MOD;
                }
            }

            int[][] current = new int[rows][cols];

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (suffixOnes[row][col] == 0) {
                        continue;
                    }

                    long ways = 0;

                    if (nextRow[row][col] < rows) {
                        ways = (ways + columnSum[nextRow[row][col]][col]) % MOD;
                    }

                    if (nextCol[row][col] < cols) {
                        ways = (ways + rowSum[row][nextCol[row][col]]) % MOD;
                    }

                    current[row][col] = (int) ways;
                }
            }

            dp = current;
        }

        return dp[0][0];
    }
}