class Solution {
    boolean isPalindrome(String s) {
        // code here
        StringBuilder s1=new StringBuilder(s);
        s1.reverse();
        String a=s1+"";
        if(a.equals(s))
        return true;
        else 
        return false;
    }
}