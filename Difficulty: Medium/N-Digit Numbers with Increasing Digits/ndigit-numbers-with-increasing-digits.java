class Solution {
    ArrayList<Integer> ans = new ArrayList<>();

    void solve(int n, int len, int num, int start) {
        if (len == n) {
            ans.add(num);
            return;
        }

        for (int d = start; d <= 9; d++) {
            solve(n, len + 1, num * 10 + d, d + 1);
        }
    }

    ArrayList<Integer> increasingNumbers(int n) {
        if (n == 1) {
            ArrayList<Integer> res = new ArrayList<>();
            for (int i = 0; i <= 9; i++)
                res.add(i);
            return res;
        }

        if (n > 9)
            return new ArrayList<>();

        solve(n, 0, 0, 1);
        return ans;
    }
}