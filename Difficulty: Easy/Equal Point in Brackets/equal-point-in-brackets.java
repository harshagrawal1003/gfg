class Solution {
    public int findIndex(String s) {
          int n = s.length();
        
        int[] prefixOpen = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixOpen[i + 1] = prefixOpen[i] + (s.charAt(i) == '(' ? 1 : 0);
        }
        
        
        int[] suffixClose = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffixClose[i] = suffixClose[i + 1] + (s.charAt(i) == ')' ? 1 : 0);
        }
        
        for (int k = 0; k <= n; k++) {
            if (prefixOpen[k] == suffixClose[k]) {
                return k;
            }
        }
        
        return -1; 
    }
}