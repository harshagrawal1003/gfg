// User function Template for Java

class Solution {
    static long isPallindrome(long N) {
        // code here
        int left = 63;
        while (left >= 0 && ((N >> left) & 1) == 0) {
            left--;
        }
        int right = 0;
        while (left > right) {
            if (((N >> left) & 1) != ((N >> right) & 1)) {
                return 0; 
            }
            left--;
            right++;
        }
        return 1; 
    }
}