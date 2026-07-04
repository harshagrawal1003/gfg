class Solution {
    public int countSubstring(String s) {
        int n = s.length();
        int offset = n + 1;
        int size = 2 * n + 3;

        int[] bit = new int[size];
        int sum = 0;
        long count = 0;

        update(bit, offset, 1);

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1')
                sum++;
            else
                sum--;

            int index = sum + offset;

            count += query(bit, index - 1);
            update(bit, index, 1);
        }

        return (int) count;
    }

    private void update(int[] bit, int index, int value) {
        while (index < bit.length) {
            bit[index] += value;
            index += index & -index;
        }
    }

    private int query(int[] bit, int index) {
        int sum = 0;

        while (index > 0) {
            sum += bit[index];
            index -= index & -index;
        }

        return sum;
    }
}