class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> ans = new ArrayList<>();
        int[] lastIdx = new int[26];            // storing last index of each char
        for(int i = 0; i < n; i++) {
            lastIdx[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;
        int k = 0;

        while( k < n) {
            end = Math.max(end, lastIdx[s.charAt(k) - 'a']);
            if( k == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
            k++;
        }

        return ans;
    }
}
/**
TC = O(n)
SC = O(1) */