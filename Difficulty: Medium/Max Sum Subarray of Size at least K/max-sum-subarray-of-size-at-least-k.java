class Solution {
    public int maxSumWithK(int[] arr, int k) {
        int n = arr.length;

        int[] maxEndingHere = new int[n];
        maxEndingHere[0] = arr[0];

        for (int i = 1; i < n; i++) {
            maxEndingHere[i] = Math.max(arr[i], maxEndingHere[i - 1] + arr[i]);
        }

        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int ans = windowSum;

        for (int i = k; i < n; i++) {
            windowSum += arr[i];
            windowSum -= arr[i - k];

            ans = Math.max(ans, windowSum);
            ans = Math.max(ans, windowSum + maxEndingHere[i - k]);
        }

        return ans;
    }
}