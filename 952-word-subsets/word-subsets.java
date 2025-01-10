class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();

        // calculating the max freq size for word2
        int[] freqforwords2 = new int[26];
        for(String word : words2) {
            int[] tempCount = new int[26];  // temp arr for curr word count of chars
            for(char ch : word.toCharArray()) {
                tempCount[ch-'a']++;
                freqforwords2[ch-'a'] = Math.max(tempCount[ch-'a'], freqforwords2[ch-'a']);
            }
        }

        // checking each word in words1 arr
        for(String word: words1) {
            int[] tempCount = new int[26];  // temp arr for curr word count of chars
            for(char ch : word.toCharArray()) {
                tempCount[ch - 'a']++;
            }

            // checking if the word satisfies the universal condition
            if(isWordSubset(freqforwords2, tempCount)) {
                res.add(word);
            }
        }
        return res;
    }

    // checking if freq is subset of temp
    private boolean isWordSubset(int[] freq, int[] temp) {
        for(int i = 0; i < 26; i++) {
            if(temp[i] < freq[i]) {
                return false;
            }
        }
        return true;
    }
}
/**
TC = O(nWords1*avgLenW1 + nWords2*avgLenW2)
SC = O(26) = O(1) */