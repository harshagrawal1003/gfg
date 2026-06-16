class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        // code here
          ArrayList<Integer> arr = new ArrayList<>();
      int  q=queries.length;
        int xor = 0;
        arr.add(0); 
        
        for (int i = 0; i < q; i++) {
            int type = queries[i][0];
            int x = queries[i][1];
            
            if (type == 0) {
                
                arr.add(x ^ xor);
            } else {
                xor ^= x;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for (int val : arr) {
            ans.add(val ^ xor);
        }
        
        Collections.sort(ans);
        return ans;
    }
}