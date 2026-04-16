class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int a1=arr[0];
        int a2=-1;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>a1)
            {
                a2=a1;
                a1=arr[i];
            }
            else if(arr[i]>a2&&arr[i]!=a1)
            a2=arr[i];
        }
        return a2;
    }
}