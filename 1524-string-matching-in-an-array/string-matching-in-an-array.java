class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || words[i].length() > words[j].length())
                    continue;

                if (isSubString(words[i], words[j])) {
                    res.add(words[i]);
                    break;
                }
            }
        }

        return res;
    }

    public boolean isSubString(String sub, String word) {
        int n = word.length();
        int m = sub.length();

        for (int j = 0; j < n; j++) {
            boolean isMatch = true;
            int k = j, i = 0;

            while (i < m) {
                if (k >= word.length() || word.charAt(k) != sub.charAt(i)) {
                    isMatch = false;
                    break;
                }
                k++;
                i++;
            }
            if (isMatch)
                return true;
        }
        return false;
    }
}

/*
 * custom compare method
 */
