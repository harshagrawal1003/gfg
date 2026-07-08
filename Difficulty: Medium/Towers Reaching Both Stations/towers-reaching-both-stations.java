class Solution {
    public int countCoordinates(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] p = new boolean[n][m];
        boolean[][] q = new boolean[n][m];

        ArrayDeque<int[]> qp = new ArrayDeque<>();
        ArrayDeque<int[]> qq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            add(i, 0, p, qp);
            add(i, m - 1, q, qq);
        }

        for (int j = 0; j < m; j++) {
            add(0, j, p, qp);
            add(n - 1, j, q, qq);
        }

        bfs(mat, p, qp);
        bfs(mat, q, qq);

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (p[i][j] && q[i][j]) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private void add(int i, int j, boolean[][] vis,
                     ArrayDeque<int[]> q) {
        if (!vis[i][j]) {
            vis[i][j] = true;
            q.offer(new int[]{i, j});
        }
    }

    private void bfs(int[][] mat, boolean[][] vis,
                     ArrayDeque<int[]> q) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int x = curr[0];
            int y = curr[1];

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && nx < n &&
                    ny >= 0 && ny < m &&
                    !vis[nx][ny] &&
                    mat[nx][ny] >= mat[x][y]) {

                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}