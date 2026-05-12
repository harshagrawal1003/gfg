class Solution {

    long[] seg;

    long gcd(long a, long b)
    {
        while(b != 0)
        {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    long findLCM(long a, long b)
    {
        return (a / gcd(a, b)) * b;
    }    
    void buildTree(int idx, int low, int high, int[] arr)
    {
            if(low == high)
        {
            seg[idx] = arr[low];
            return;
        }
        int mid = low + (high - low) / 2;
        buildTree(2 * idx + 1, low, mid, arr);
        buildTree(2 * idx + 2, mid + 1, high, arr);
        seg[idx] = findLCM(seg[2 * idx + 1], seg[2 * idx + 2]);
    }
    void updateValue(int idx, int low, int high, int pos, int val)
    {
        if(low == high)
        {
            seg[idx] = val;
            return;
        }
        int mid = low + (high - low) / 2;
        if(pos <= mid)
        {
            updateValue(2 * idx + 1, low, mid, pos, val);
        }
        else
        {
            updateValue(2 * idx + 2, mid + 1, high, pos, val);
        }
        seg[idx] = findLCM(seg[2 * idx + 1], seg[2 * idx + 2]);
    }
    long getLCM(int idx, int low, int high, int l, int r)
    {
                if(r < low || high < l)
        {
            return 1;
        }
        if(l <= low && high <= r)
        {
            return seg[idx];
        }
        int mid = low + (high - low) / 2;
        long leftPart = getLCM(2 * idx + 1, low, mid, l, r);
        long rightPart = getLCM(2 * idx + 2, mid + 1, high, l, r);
        return findLCM(leftPart, rightPart);
    }
    public ArrayList<Long> RangeLCMQuery(int[] arr, int[][] queries) {
        int n = arr.length;
        seg = new long[4 * n];
        buildTree(0, 0, n - 1, arr);
        ArrayList<Long> ans = new ArrayList<>();
        for(int[] q : queries)
        {
            int type = q[0];
            if(type == 1)
            {
                int index = q[1];
                int value = q[2];
                updateValue(0, 0, n - 1, index, value);
            }
            else
            {
                int left = q[1];
                int right = q[2];
                long lcmValue = getLCM(0, 0, n - 1, left, right);
                ans.add(lcmValue);
            }
        }
        return ans;
    }
}