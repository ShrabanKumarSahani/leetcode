class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        if(s1.equals(s2)) {
            return true;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        int diff = 0;

        for(int i = 0; i < n; i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }

            if(diff > 2) {
                return false;
            }

            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }
}
/**
TC = O(n)
SC = O(1) */