class Solution {
    public String chooseSwap(String s) {
        // code here
         boolean[] present = new boolean[26];

        for (char ch : s.toCharArray()) {
            present[ch - 'a'] = true;
        }

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            present[arr[i] - 'a'] = false;

            for (int j = 0; j < arr[i] - 'a'; j++) {
                if (present[j]) {
                    char ch1 = arr[i];
                    char ch2 = (char) (j + 'a');

                    for (int k = 0; k < arr.length; k++) {
                        if (arr[k] == ch1)
                            arr[k] = ch2;
                        else if (arr[k] == ch2)
                            arr[k] = ch1;
                    }

                    return new String(arr);
                }
            }
        }

        return s;
    }
}