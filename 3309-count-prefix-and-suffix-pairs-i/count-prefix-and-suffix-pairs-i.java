class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].length() <= words[j].length() && isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean isPrefixAndSuffix(String check, String s) {
        int checkLength = check.length();
        String str1 = s.substring(0, checkLength);
        String str2 = s.substring(s.length() - checkLength, s.length());
        return str1.equals(check) && str2.equals(check);
    }
}
/**
 * BRUTE FORCE
 * TC = O(n^2)
 * SC = O(n^2)
 */