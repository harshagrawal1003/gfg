class Solution {
    public int numOfWays(int n, int m) {
        long total = 1L * n * m;
        
        long attack = 0;
        
        if (n >= 2 && m >= 3)
            attack += 4L * (n - 1) * (m - 2);
            
        if (n >= 3 && m >= 2)
            attack += 4L * (n - 2) * (m - 1);
        
        long ans = total * (total - 1) - attack;
        
        return (int) ans;
    }
}