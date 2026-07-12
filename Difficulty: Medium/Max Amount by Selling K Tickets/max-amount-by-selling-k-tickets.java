
class Solution {
    public int maxAmount(int[] arr, int k) {
        long mod = 1000000007L;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int x : arr) {
            pq.offer(x);
        }

        long ans = 0;

        while (k > 0 && !pq.isEmpty()) {
            int cur = pq.poll();
            ans = (ans + cur) % mod;

            if (cur > 1) {
                pq.offer(cur - 1);
            }

            k--;
        }

        return (int) ans;
    }
}