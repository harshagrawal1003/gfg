class Solution {
    public int minTime(int[] arr, int k) {
        // code here
          int low = 0, high = 0, mid, result = -1;
        for (int i = 0; i < arr.length; i++) {
            low = Math.max(low, arr[i]); 
            high += arr[i];    
        }
        while (low <= high) {
            mid = low + (high - low) / 2;
            int currentSum = 0, paintersRequired = 1;

            for (int i = 0; i < arr.length; i++) {
                currentSum += arr[i];
                if (currentSum > mid) {
                    paintersRequired++;
                    currentSum = arr[i];
                }
            }

            if (paintersRequired <= k) {
                result = mid;   
                high = mid - 1; 
            } else {
                low = mid + 1;  
            }
        }

        return result;
    }
}
