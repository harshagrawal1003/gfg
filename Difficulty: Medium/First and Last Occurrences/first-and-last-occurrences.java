class Solution {
    ArrayList<Integer> find(int arr[], int k) {
     
     int first= BinarySearch(arr,k,true);
        int last= BinarySearch(arr,k,false);
         ArrayList<Integer> list = new ArrayList<>();
list.add(first);
list.add(last);
        return list;
        
    }
        static int BinarySearch(int[] app,int target,boolean first){
        int start=0,ans=-1;
        int end=app.length-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(app[mid]==target)
            {
               ans=mid;
               if(first)
                   end=mid-1;
               else
                   start=mid+1;
            }
            else if(app[mid]>target)
            {
                end=mid-1;
            }
            else
                start=mid+1;
        }
        return ans;
    }
    
}
