class Solution {
    boolean canFormPalindrome(String s) {
        // code here
       int[] freq = new int[26]; 
       for(char a:s.toCharArray())
       {
           freq[a-'a']++;
       }
       int od=0;
       for(int i=0;i<26;i++)
       {
           if(freq[i]%2!=0)
           od++;
           
       }
       if(od<=1)
       return true;
       else
      return false;
    }
}