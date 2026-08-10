class Solution {
    public int maxTask(int[] h, int[] l) {
        int n = h.length;

        int noTask = 0;
        int task = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            int prevNoTask = noTask;
            int prevTask = task;

            noTask = Math.max(prevNoTask, prevTask);

            int low = Math.max(prevNoTask, prevTask) + l[i];

            int high = prevNoTask + h[i];

            task = Math.max(low, high);
        }

        return Math.max(noTask, task);
    }
}