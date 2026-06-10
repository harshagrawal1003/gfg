class Solution {
     public int binarySearchable(int[] arr) {
        return dfs(0, arr.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE, arr);
    }

    private int dfs(int l, int r, int minVal, int maxVal, int[] arr) {
        if (l > r) {
            return 0;
        }

        int mid = l + (r - l) / 2;
        int count = 0;

        if (arr[mid] > minVal && arr[mid] < maxVal) {
            count = 1;
        }

        count += dfs(
                l,
                mid - 1,
                minVal,
                Math.min(maxVal, arr[mid]),
                arr
        );

        count += dfs(
                mid + 1,
                r,
                Math.max(minVal, arr[mid]),
                maxVal,
                arr
        );

        return count;
    }
};