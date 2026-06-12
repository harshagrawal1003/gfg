class Solution {
    public boolean kSubstr(String s, int k) {
        // code here
          int n = s.length();

        if (n % k != 0) return false;

        int blocks = n / k;

        HashMap<String, Integer> freq = new HashMap<>();
        int maxFreq = 0;

        for (int i = 0; i < n; i += k) {
            String part = s.substring(i, i + k);

            int cnt = freq.getOrDefault(part, 0) + 1;
            freq.put(part, cnt);

            maxFreq = Math.max(maxFreq, cnt);
        }

        return maxFreq == blocks || maxFreq == blocks - 1;
    }
}