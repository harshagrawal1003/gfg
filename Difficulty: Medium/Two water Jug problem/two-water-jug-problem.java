class Solution {
    public int minSteps(int m, int n, int d) {
        // code here
     if (d > Math.max(m, n))
            return -1;

        if (d % gcd(m, n) != 0)
            return -1;

        return Math.min(pour(m, n, d), pour(n, m, d));   
    }
        // Function to calculate gcd
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    // Function to simulate pouring
    static int pour(int fromCap, int toCap, int d) {
        int from = fromCap; // fill from jug
        int to = 0;         // second jug empty
        int steps = 1;      // first step = fill

        while (from != d && to != d) {

            int temp = Math.min(from, toCap - to);

            to += temp;
            from -= temp;
            steps++;

            if (from == d || to == d)
                break;

            // refill if empty
            if (from == 0) {
                from = fromCap;
                steps++;
            }

            // empty if full
            if (to == toCap) {
                to = 0;
                steps++;
            }
        }
        return steps;
    }
}