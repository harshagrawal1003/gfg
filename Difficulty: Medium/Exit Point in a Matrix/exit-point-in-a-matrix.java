class Solution {
    public List<Integer> exitPoint(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int row = 0, col = 0;
        int dir = 0; 

        while (row >= 0 && row < n && col >= 0 && col < m) {
            if (mat[row][col] == 1) {
                dir = (dir + 1) % 4;
                mat[row][col] = 0;
            }

            if (dir == 0) col++;
            else if (dir == 1) row++;
            else if (dir == 2) col--;
            else row--;
        }

        if (dir == 0) col--;
        else if (dir == 1) row--;
        else if (dir == 2) col++;
        else row++;

        return Arrays.asList(row, col);
    }
}