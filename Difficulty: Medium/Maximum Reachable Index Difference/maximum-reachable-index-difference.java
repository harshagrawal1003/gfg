class Solution {
    public int maxIndexDifference(String s) {
        // code here
          int n = s.length();
        int[] bestReach = new int[26];
        Arrays.fill(bestReach, -1);

        int ans = -1;

        for (int i = n - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'a';
            int far;

            if (c == 25) {
                far = i;
            } else {
                if (bestReach[c + 1] != -1) {
                    far = bestReach[c + 1];
                } else {
                    far = i;
                }
            }

            bestReach[c] = Math.max(bestReach[c], far);

            if (c == 0) {
                ans = Math.max(ans, far - i);
            }
        }

        return bestReach[0] == -1 ? -1 : ans;
    }
}