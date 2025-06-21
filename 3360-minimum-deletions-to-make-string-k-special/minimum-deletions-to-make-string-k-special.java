class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for(char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }
        Arrays.sort(freq);

        int ans = word.length();
        int cummDeletedElements = 0;

        for(int i = 0; i < 26; i++) {
            int del = cummDeletedElements;
            for(int j = 25; j >= 0; j--) {
                if(freq[j] - freq[i] <= k) 
                    break;
                del += freq[j] - freq[i] - k;
            }

            ans = Math.min(ans, del);
            cummDeletedElements += freq[i];
        }

        return ans;
    }
}
/**
TC = O(n)
SC = O(1) */