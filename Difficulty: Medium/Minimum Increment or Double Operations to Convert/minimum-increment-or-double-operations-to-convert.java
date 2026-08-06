class Solution {
    static int countMinOperations(int[] arr) {
        int increments = 0;
        int maxBits = 0;

        for (int num : arr) {
            increments += Integer.bitCount(num);

            if (num > 0) {
                maxBits = Math.max(maxBits,
                        32 - Integer.numberOfLeadingZeros(num));
            }
        }

        int doubles = (maxBits == 0) ? 0 : maxBits - 1;

        return increments + doubles;
    }
}