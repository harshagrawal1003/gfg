class Solution {
    ArrayList<Integer> sortBySetBitCount(int[] arr) {
         ArrayList<Integer> list = new ArrayList<>();
        
        for(int num : arr) {
            list.add(num);
        }
        
        Collections.sort(list, (a, b) -> Integer.bitCount(b) - Integer.bitCount(a));
        
        return list;
        
    }
}