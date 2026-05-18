class Solution {
 HashMap<Integer, Integer> dp = new HashMap<>();
    
    public int solve(int n) {
        
        // Base case
        if(n == 0)
            return 0;
        
        // If already calculated
        if(dp.containsKey(n))
            return dp.get(n);
        
        // Recursive break
        int breakValue = solve(n/2) + solve(n/3) + solve(n/4);
        
        // Store maximum value
        int ans = Math.max(n, breakValue);
        
        dp.put(n, ans);
        
        return ans;
    }
    
    public int maxSum(int n) {
        return solve(n);    }
}
