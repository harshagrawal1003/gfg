class Solution {
     public int countSpanTree(int n, int[][] edges) {

        if (n == 1) return 1;

        int[][] lap = new int[n][n];

        for (int[] e : edges) {

            int u = e[0];
            int v = e[1];

            lap[u][u]++;
            lap[v][v]++;

            lap[u][v]--;
            lap[v][u]--;
        }

        double[][] mat = new double[n - 1][n - 1];

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                mat[i][j] = lap[i][j];
            }
        }

        return (int)Math.round(det(mat));
    }

    double det(double[][] mat) {

        int n = mat.length;
        double ans = 1;

        for (int i = 0; i < n; i++) {

            int pivot = i;

            for (int j = i; j < n; j++) {
                if (Math.abs(mat[j][i]) > Math.abs(mat[pivot][i])) {
                    pivot = j;
                }
            }

            if (Math.abs(mat[pivot][i]) < 1e-9) {
                return 0;
            }

            if (pivot != i) {

                double[] temp = mat[i];
                mat[i] = mat[pivot];
                mat[pivot] = temp;

                ans *= -1;
            }

            ans *= mat[i][i];

            for (int j = i + 1; j < n; j++) {

                double factor = mat[j][i] / mat[i][i];

                for (int k = i; k < n; k++) {
                    mat[j][k] -= factor * mat[i][k];
                }
            }
        }

        return ans;
    }
}