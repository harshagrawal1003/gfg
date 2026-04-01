class Solution {
  public:
    int missingNum(vector<int>& arr) {
        // code here
        long long  sum =0;
     for(int i : arr)
     {
         sum=sum+i;
     }
     long long  n=arr.size()+1;
      long long  total = n * (n + 1) / 2;
        
        return total - sum;
    }
};