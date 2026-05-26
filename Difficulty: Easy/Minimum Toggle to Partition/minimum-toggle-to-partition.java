class Solution {
    int minToggle(int[] arr) {
        // code here
         int n = arr.length;

        int zeros = 0;
        for (int x : arr) {
            if (x == 0) zeros++;
        }

        int cost = zeros; 
        int ans = cost;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1)
                cost++; 
            else
                cost--; 

            ans = Math.min(ans, cost);
        }

        return ans;
    }
}