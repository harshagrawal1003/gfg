class Solution {
    public ArrayList<Boolean> processQueries(int[] arr, int[][] queries) {
        int n = arr.length;

        int[] endInc = new int[n];
        endInc[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1])
                endInc[i] = endInc[i + 1];
            else
                endInc[i] = i;
        }

        int[] endDec = new int[n];
        endDec[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[i + 1])
                endDec[i] = endDec[i + 1];
            else
                endDec[i] = i;
        }

        ArrayList<Boolean> ans = new ArrayList<>();

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];

            int peak = endInc[l];

            if (peak >= r || endDec[peak] >= r)
                ans.add(true);
            else
                ans.add(false);
        }

        return ans;
    }
}