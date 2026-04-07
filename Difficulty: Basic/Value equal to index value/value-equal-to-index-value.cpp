class Solution {
  public:
    vector<int> valueEqualToIndex(vector<int>& arr) {
        // code here
        vector<int> arr1;
        for(int i=0;i<arr.size();i++)
        {
            if(i+1==arr[i])
            arr1.push_back(i+1);
            
        }
        return arr1;
    }
};