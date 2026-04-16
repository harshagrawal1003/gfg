class Solution {
    public int findFloor(int[] arr, int x) {
        // code here
        int a=floor(arr,x);
        return a;
    }
     static int floor(int[] app, int target) {
        int start = 0;
        int end = app.length - 1;

        if (target < app[0]) {
            return -1; // no floor exists
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (app[mid] <= target) {
                start = mid + 1;   // move right
            } else {
                end = mid - 1;     // move left
            }
        }

        return end;   // ✅ floor index
    }
}
