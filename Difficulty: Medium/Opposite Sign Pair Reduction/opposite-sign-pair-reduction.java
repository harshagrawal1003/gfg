class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        // code here
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int num : arr) {
            boolean reduced = false;
            
            while (!stack.isEmpty() && (stack.peekLast() * num < 0)) { 
                int top = stack.peekLast();
                if (Math.abs(top) == Math.abs(num)) {
                    stack.pollLast(); 
                    reduced = true;
                    break;
                } else if (Math.abs(top) > Math.abs(num)) {
                    
                reduced = true;
                    break;
        } else {
                   
                    stack.pollLast();
                
        }
            }
            
            if (!reduced) {
                stack.addLast(num);
            }
    }
      return new ArrayList<>(stack);
}
}