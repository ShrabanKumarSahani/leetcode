class Solution {
    public int minimumLength(String s) {       
       int[] freq = new int[26];
       int deletedChars = 0;

       for(char ch : s.toCharArray()) {
            freq[ch - 'a'] += 1;

            if(freq[ch - 'a'] == 3) {
                freq[ch - 'a'] -= 2;
                deletedChars += 2;
            }
       }

       return s.length() - deletedChars;
    }
}
/**
TC = O(n)
SC = O(26) = O(1) */