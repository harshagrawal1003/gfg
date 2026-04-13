class Solution {
    public int findMin(int[] arr) {
        // code here
        int start=0,end=arr.length-1;
        while (start <end) {
                // already sorted → no rotation
                if (arr[start] <= arr[end]) {
                    return arr[start];
                }

                int mid = start + (end - start) / 2;

                // mid is in left sorted part → go right
                if (arr[mid] >= arr[start]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }

            }
            return arr[start];
    }
}
