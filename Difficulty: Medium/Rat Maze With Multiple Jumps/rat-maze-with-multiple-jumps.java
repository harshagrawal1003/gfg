class Solution {

    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        int n = mat.length;
        int[][] path = new int[n][n];
        boolean[][] failed = new boolean[n][n];

        if (!dfs(mat, path, failed, 0, 0, n)) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>(Arrays.asList(-1)));
            return ans;
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(path[i][j]);
            }
            ans.add(row);
        }

        return ans;
    }

    private boolean dfs(int[][] mat, int[][] path, boolean[][] failed,
                        int r, int c, int n) {

        if (r >= n || c >= n || mat[r][c] == 0) {
            return false;
        }

        if (failed[r][c]) {
            return false;
        }

        path[r][c] = 1;

        if (r == n - 1 && c == n - 1) {
            return true;
        }

        int jump = mat[r][c];

        for (int k = 1; k <= jump; k++) {

            if (dfs(mat, path, failed, r, c + k, n)) {
                return true;
            }

            if (dfs(mat, path, failed, r + k, c, n)) {
                return true;
            }
        }

        path[r][c] = 0;
        failed[r][c] = true;

        return false;
    }
}