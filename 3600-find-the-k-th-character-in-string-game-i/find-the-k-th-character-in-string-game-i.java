class Solution {
    public char kthCharacter(int k) {
        int idx = k-1;
        StringBuilder ans = new StringBuilder();
        ans.append('a');

        while(ans.length() < k) {
            int n = ans.length();
            for(int i = 0; i < n; i++) {
                char ch = ans.charAt(i) == 'z' ? 'a' : (char)(ans.charAt(i) + 1);
                ans.append(ch);
            }
        }

        return ans.charAt(idx);
    }
}
/**
TC = O(k)
SC = O(k) */