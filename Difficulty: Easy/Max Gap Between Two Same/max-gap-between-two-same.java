class Solution {
    public int maxCharGap(String s) {
        // code here
         int[] first = new int[26];
        Arrays.fill(first, -1);

        int maxGap = -1;

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';

            if (first[index] == -1) {
                first[index] = i;
            } else {
                maxGap = Math.max(maxGap, i - first[index] - 1);
            }
        }

        return maxGap;
    }
};