class Solution {
    public boolean isPower(int x, int y) {
        // code here
        int count=0;
         if (x == 1) return y == 1;

        while (y % x == 0) {
            y = y / x;
        }

        return y == 1;
    }
}