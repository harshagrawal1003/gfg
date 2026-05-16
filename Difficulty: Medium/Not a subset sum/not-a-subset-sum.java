class Solution {
    public int findSmallest(int[] arr) {
        // code here
Arrays.sort(arr);
        int res = 1;
    
        for (int x : arr) {
            if (x > res) 
                break;
            res += x;
        }
        
        return res;
    }
}