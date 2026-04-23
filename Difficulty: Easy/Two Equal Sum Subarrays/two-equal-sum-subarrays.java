class Solution {
    public boolean canSplit(int arr[]) {
        // code here
        int sum=0;
     for(int i:arr)
     {
         sum+=i;
         
     }
     if(sum%2!=0)
     return false;
     else
     sum/=2;
     int a=0;
     for(int i=0;i<arr.length;i++)
     {
         a+=arr[i];
         if(a==sum)
         return true;
     }
     return false;
    }
}