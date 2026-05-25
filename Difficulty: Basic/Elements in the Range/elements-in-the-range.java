class Solution {
    public boolean checkElements(int start, int end, int[] arr) {
        // code here
        for(int i=start;i<=end;i++)
        {boolean a=true;
            for(int j:arr)
            {
                if(j==i)
                a=false;
            }
            if(a)
            return false;
        }return true;
    }
}