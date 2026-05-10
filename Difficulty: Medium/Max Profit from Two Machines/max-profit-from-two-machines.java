class Solution {
     static class Task {
        int a, b, diff;
        
        Task(int a, int b) {
            this.a = a;
            this.b = b;
            this.diff = Math.abs(a - b);
        }
    }

    public int maxProfit(int x, int y, int[] a, int[] b) {
        int n = a.length;

        Task[] tasks = new Task[n];

        for (int i = 0; i < n; i++) {
            tasks[i] = new Task(a[i], b[i]);
        }

        Arrays.sort(tasks, (t1, t2) -> t2.diff - t1.diff);

        int profit = 0;

        for (Task t : tasks) {

            if ((t.a >= t.b && x > 0) || y == 0) {
                profit += t.a;
                x--;
            } else {
                profit += t.b;
                y--;
            }
        }

        return profit;
    }
}