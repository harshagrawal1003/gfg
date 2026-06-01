class Solution {
    int findMaxProduct(int[] arr) {
        long MOD = 1000000007L;

        int n = arr.length;
        if (n == 1) return arr[0];

        int negCount = 0, zeroCount = 0, posCount = 0;
        int maxNegative = Integer.MIN_VALUE;

        for (int x : arr) {
            if (x == 0) {
                zeroCount++;
            } else if (x < 0) {
                negCount++;
                maxNegative = Math.max(maxNegative, x);
            } else {
                posCount++;
            }
        }

        if (zeroCount == n) return 0;

        if (negCount == 1 && posCount == 0 && zeroCount + negCount == n)
            return 0;

        long ans = 1;
        boolean removed = false;

        for (int x : arr) {
            if (x == 0) continue;

            if ((negCount & 1) == 1 && x == maxNegative && !removed) {
                removed = true;
                continue;
            }

            ans = (ans * ((x % MOD + MOD) % MOD)) % MOD;
        }

        return (int) ans;
    }
}