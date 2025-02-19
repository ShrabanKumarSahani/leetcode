class Solution {
    String ans;
    int count;

    public String getHappyString(int n, int k) {
        count = 0;
        ans = "";
        backtrack(n, k, new StringBuilder(""));
        return ans;
    }

    public boolean backtrack(int n, int k, StringBuilder curr) {
        if(curr.length() == n) {
            count++;
            if(count == k) {
                ans = curr.toString();
                return true;
            }
            return false;
        }
        for(char ch = 'a'; ch <= 'c'; ch++) {
            int l = curr.length();
            if(l > 0 && curr.charAt(l-1) == ch) {
                continue;
            }
            curr.append(ch);
            if(backtrack(n, k, curr)) {
                return true;
            }
            curr.deleteCharAt(curr.length() - 1);
        }
        return false;
    }
}
/**
TC = O(2^n)
SC = O(n) */