class Solution {
    public int findPosition(int n) {
        // code here
         if (n <= 0 || (n & (n - 1)) != 0) {
            return -1;
        }

        int pos = 1; // positions start from 1 (LSB)
        while ((n & 1) == 0) {
            n >>= 1;
            pos++;
        }
        return pos;
    }
}