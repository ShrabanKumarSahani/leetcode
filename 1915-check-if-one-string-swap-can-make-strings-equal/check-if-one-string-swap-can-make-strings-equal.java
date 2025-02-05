class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        if (s1.equals(s2)) {
            return true;
        }

        int diff = 0;
        int firstIndex = 0, secondIndex = 0;

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;

                if (diff > 2) {
                    return false;
                } else if (diff == 1) {
                    firstIndex = i;
                } else {
                    secondIndex = i;
                }
            }
        }

        return s1.charAt(firstIndex) == s2.charAt(secondIndex) && s1.charAt(secondIndex) == s2.charAt(firstIndex);
    }
}
/**
 * TC = O(n)
 * SC = O(1)
 */