class Solution {
    static final long MOD = 1000000007L;

    long modPow(long a, long b) {
        long res = 1;
        a %= MOD;

        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }

    public int computeValue(int n) {
        long[] fact = new long[2 * n + 1];
        long[] invFact = new long[2 * n + 1];

        fact[0] = 1;
        for (int i = 1; i <= 2 * n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        invFact[2 * n] = modPow(fact[2 * n], MOD - 2);

        for (int i = 2 * n; i >= 1; i--) {
            invFact[i - 1] = (invFact[i] * i) % MOD;
        }

        long ans = fact[2 * n];
        ans = (ans * invFact[n]) % MOD;
        ans = (ans * invFact[n]) % MOD;

        return (int) ans; 
    }
}