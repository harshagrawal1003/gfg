class Solution {
    int cntOnes(int[][] grid) {
        // code here
          int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) {
                q.offer(new int[]{0, j});
                grid[0][j] = 0;
            }
            if (grid[n - 1][j] == 1) {
                q.offer(new int[]{n - 1, j});
                grid[n - 1][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                q.offer(new int[]{i, 0});
                grid[i][0] = 0;
            }

            if (grid[i][m - 1] == 1) {
                q.offer(new int[]{i, m - 1});
                grid[i][m - 1] = 0;
            }
        }
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    grid[nr][nc] == 1) {

                    grid[nr][nc] = 0;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) ans++;
            }
        }

        return ans;
    }
};