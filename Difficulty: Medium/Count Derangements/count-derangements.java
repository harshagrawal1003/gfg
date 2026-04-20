class Solution {
    public int derangeCount(int n) {
        // code here
        return dear(n);
    }
    static int dear(int n){
        if(n<=2)
        return n-1;
        return (n - 1) * (dear(n-1) + dear(n-2));
    }
};