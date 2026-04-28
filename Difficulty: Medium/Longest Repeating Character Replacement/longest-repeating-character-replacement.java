class Solution {
    public int longestSubstr(String s, int k) {
        // code here
          int[] freq = new int[26];
        
        int left = 0, maxFreq = 0, result = 0;
        
        for (int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right) - 'A';
            freq[idx]++;
            
            maxFreq = Math.max(maxFreq, freq[idx]);
            
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            
            result = Math.max(result, right - left + 1);
        }
        
        return result;
    }
}
