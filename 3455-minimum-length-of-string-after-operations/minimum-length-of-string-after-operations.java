class Solution {
    public int minimumLength(String s) {       
       int[] freq = new int[26];
       for(char ch : s.toCharArray()) {
            freq[ch - 'a'] += 1;
       }

       int ans = 0;
       for(int i = 0; i < 26; i++) {
            if(freq[i] == 0)
                continue;
            // if no of chars is odd then after deletion only 1 will be left and incase of even it will be 2
            if(freq[i] % 2 == 0) {
                ans += 2;           
            } else {
                ans += 1;
            }
       }

       return ans;
    }
}
/**
TC = O(n)
SC = O(26) = O(1) */