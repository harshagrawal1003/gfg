import java.util.*;

class Solution {

    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int x = q[2];

            ArrayList<Integer> pos = map.get(x);

            if (pos == null) {
                ans.add(0);
                continue;
            }

            int left = lowerBound(pos, l);
            int right = upperBound(pos, r);

            ans.add(right - left);
        }

        return ans;
    }

    private int lowerBound(ArrayList<Integer> list, int target) {
        int l = 0, r = list.size();

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (list.get(mid) >= target)
                r = mid;
            else
                l = mid + 1;
        }

        return l;
    }

    private int upperBound(ArrayList<Integer> list, int target) {
        int l = 0, r = list.size();

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (list.get(mid) > target)
                r = mid;
            else
                l = mid + 1;
        }

        return l;
    }
}