class Solution {
    public int minSwaps(int[] arr) {
        // code here
     
        int n = arr.length;
        int count = 0;
        for (int num : arr) {
            if (num == 1) count++;
        }
        if (count == 0) return -1;

        int currentOnes = 0;
        for (int i = 0; i < count; i++) {
            if (arr[i] == 1) currentOnes++;
        }
        int maxOnes = currentOnes;

        for (int i = count; i < n; i++) {
            if (arr[i] == 1) currentOnes++;
            if (arr[i - count] == 1) currentOnes--;
            maxOnes = Math.max(maxOnes, currentOnes);
        }
        return count - maxOnes;
    }
}
