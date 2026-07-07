class Solution {
    public int largestArea(int n, int m, int[][] arr) {
        // code here
         int k = arr.length;

        int[] rows = new int[k];
        int[] cols = new int[k];

        for (int i = 0; i < k; i++) {
            rows[i] = arr[i][0];
            cols[i] = arr[i][1];
        }

        Arrays.sort(rows);
        Arrays.sort(cols);

        int maxRow = maxGap(rows, n);
        int maxCol = maxGap(cols, m);

        return maxRow * maxCol;
    }

    private int maxGap(int[] arr, int size) {
        int max = 0;
        int prev = 0;

        for (int blocked : arr) {
            max = Math.max(max, blocked - prev - 1);
            prev = blocked;
        }

        max = Math.max(max, size - prev);

        return max;
    }
}