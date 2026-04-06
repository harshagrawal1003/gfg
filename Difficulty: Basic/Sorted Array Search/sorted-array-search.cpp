class Solution {
  public:
    bool searchInSorted(vector<int>& arr, int k) {
        // code here
        bool a=false;
        for(int i=0;i<arr.size();i++)
        {
            if(arr[i]==k)
            a=true;
        }
        return a;
    }
};