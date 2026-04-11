// User function Template for Java
class Solution {
    public int findCeil(int[] arr, int target) {
        // code here
        
        int start=0,end=arr.length-1;
        if(arr[end]<target)
        return -1;
        int k=0;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(arr[mid]==target)
            {
            if(mid==0)
            return mid;
            else if(arr[mid-1]!=target)
            return mid;
            else
            end=mid-1;
            }
     
            else if(arr[mid]>target)
             end=mid-1;
                
            
            else
            start=mid+1;
        }
        return start;
    }
}
