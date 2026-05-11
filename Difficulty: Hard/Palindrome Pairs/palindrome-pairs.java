class Solution {
    static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }

    public static boolean palindromePair(String[] arr) {

        HashMap<String, Integer> map = new HashMap<>();

        for (String s : arr)
            map.put(s, map.getOrDefault(s, 0) + 1);

        for (String s : arr) {
            int n = s.length();
            for (int i = 0; i <= n; i++) {
                String left = s.substring(0, i);
                String right = s.substring(i);
                if (isPalindrome(left)) {

                    String revRight =
                            new StringBuilder(right).reverse().toString();

                    if (map.containsKey(revRight)) {

                        if (!revRight.equals(s) || map.get(s) > 1)
                            return true;
                    }
                }
                if (i != n && isPalindrome(right)) {

                    String revLeft =
                            new StringBuilder(left).reverse().toString();

                    if (map.containsKey(revLeft)) {

                        if (!revLeft.equals(s) || map.get(s) > 1)
                            return true;
                    }
                }
            }
        }
        return false;
    }
}