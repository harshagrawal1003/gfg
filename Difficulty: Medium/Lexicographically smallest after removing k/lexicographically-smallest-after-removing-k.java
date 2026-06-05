class Solution {
    public String lexicographicallySmallest(String s, int k) {
        int n = s.length();

        if ((n & (n - 1)) == 0)
            k /= 2;
        else
            k *= 2;

        if (k > n || n - k <= 0)
            return "-1";

        int remove = k;
        StringBuilder st = new StringBuilder();

        for (char ch : s.toCharArray()) {
            while (st.length() > 0 &&
                   remove > 0 &&
                   st.charAt(st.length() - 1) > ch) {
                st.deleteCharAt(st.length() - 1);
                remove--;
            }
            st.append(ch);
        }

        while (remove > 0 && st.length() > 0) {
            st.deleteCharAt(st.length() - 1);
            remove--;
        }

        int keep = n - k;
        String ans = st.substring(0, keep);

        return ans.length() == 0 ? "-1" : ans;
    }
}