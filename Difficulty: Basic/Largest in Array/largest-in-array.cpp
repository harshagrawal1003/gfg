
       class Solution {
  public:
    int largest(vector<int> &arr) {
        // code here
       int a=arr[0];
       for(int i=1;i<arr.size();i++)
      
      { if(arr[i]>a)
       a=arr[i];
    }
    return a;
    }
};