class Solution {
    int longest = -1;

    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {

        if (mat[xs][ys] == 0 || mat[xd][yd] == 0) {
            return -1;
        }

        boolean[][] visited = new boolean[mat.length][mat[0].length];
        findPath(mat, visited, xs, ys, xd, yd, 0);

        return longest;
    }

    private void findPath(int[][] mat, boolean[][] visited,
                          int row, int col,
                          int targetRow, int targetCol,
                          int steps) {

        if (row == targetRow && col == targetCol) {
            longest = Math.max(longest, steps);
            return;
        }

        visited[row][col] = true;

        if (row > 0 && mat[row - 1][col] == 1 && !visited[row - 1][col]) {
            findPath(mat, visited, row - 1, col, targetRow, targetCol, steps + 1);
        }

        if (row + 1 < mat.length && mat[row + 1][col] == 1 && !visited[row + 1][col]) {
            findPath(mat, visited, row + 1, col, targetRow, targetCol, steps + 1);
        }

        if (col > 0 && mat[row][col - 1] == 1 && !visited[row][col - 1]) {
            findPath(mat, visited, row, col - 1, targetRow, targetCol, steps + 1);
        }

        if (col + 1 < mat[0].length && mat[row][col + 1] == 1 && !visited[row][col + 1]) {
            findPath(mat, visited, row, col + 1, targetRow, targetCol, steps + 1);
        }

        visited[row][col] = false;
    }
}