class Solution {
     public List<String>  validParenthesis(String s) {
        ArrayList<String> ans = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        visited.add(s);
        boolean found = false;

        while (!q.isEmpty()) {

            String curr = q.poll();
            if (isValid(curr)) {
                ans.add(curr);
                found = true;
            }
            if (found) continue;
            for (int i = 0; i < curr.length(); i++) {
                char ch = curr.charAt(i);
                if (ch != '(' && ch != ')') continue;
                String next =
                        curr.substring(0, i) +
                        curr.substring(i + 1);
                if (!visited.contains(next)) {
                    visited.add(next);
                    q.offer(next);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
    private boolean isValid(String s) {
        int balance = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                balance++;
            }
            else if (ch == ')') {
                if (balance == 0)
                    return false;
                balance--;
            }
        }

        return balance == 0;
    }
}