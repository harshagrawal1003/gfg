class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;

        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int L = queries[i][0];
            int R = queries[i][1];

            int sum = prefix[R] - (L > 0 ? prefix[L - 1] : 0);
            int mean = sum / (R - L + 1);

            ans.add(mean);
        }

        return ans;
    }
}