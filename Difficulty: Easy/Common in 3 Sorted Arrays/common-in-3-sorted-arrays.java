class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
     
         int i = 0, j = 0, k = 0;
        ArrayList<Integer> result = new ArrayList<>();
        
        while (i < a.length && j < b.length && k < c.length) {
            if (a[i] == b[j] && b[j] == c[k]) {
            
                if (result.isEmpty() || result.get(result.size() - 1) != a[i]) {
                    result.add(a[i]);
                }
                i++; j++; k++;
            } else {
                int min = Math.min(a[i], Math.min(b[j], c[k]));
                if (a[i] == min) i++;
                else if (b[j] == min) j++;
                else k++;
            }
        }
        return result;
    }
}