class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int[] chFreq = new int[128];      // ASCII

        int i = 0;
        int n = s.length();
        
        if(n == 0) {
            return 0;
        }

        for(int j = 0; j < n; j++) {
            char currChar = s.charAt(j);
            chFreq[currChar]++;

            while(chFreq[currChar] > 1) {     // looping till duplicates are removed
                chFreq[s.charAt(i)]--;
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;
    }
}
/**
TC = O(n)
SC = O(128) = O(1)*/