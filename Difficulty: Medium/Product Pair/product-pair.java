class Solution {
    public boolean isProduct(int[] arr, long target) {
        // code here
         HashSet<Long> set = new HashSet<>();
        for(int num : arr) {
            long x = num;
            if(x == 0) {
                if(target == 0)
                    return true;
            }
            else {
                if(target % x == 0) {
                    
                    long need = target / x;
                    
                    if(set.contains(need))
                        return true;
                }
            }
            
            set.add(x);
        }
        
        return false;
    }
};