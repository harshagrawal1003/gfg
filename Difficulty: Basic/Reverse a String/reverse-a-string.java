// User function Template for Java

class Solution {
    public static String reverseString(String s) {
        // code here
        StringBuilder s1=new StringBuilder(s);
        s1.reverse();
        s=s1+"";
        return s;
    }
}