class Solution {
    public String profession(int level, int pos) {
        int flips = Integer.bitCount(pos - 1);

        if (flips % 2 == 0)
            return "Engineer";
        else
            return "Doctor";
    }
}