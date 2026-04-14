// User function Template for Java

class Solution {
    // Function to find starting and end index
    static int[] findIndex(int arr[], int key) {
        // code here.
        int f=-1,c=-1;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==key)
            {
                f=i;
                break;
            }
            
        }
         for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==key)
            {
                c=i;
                
            }}
            return new int[]{f,c};
    }
}