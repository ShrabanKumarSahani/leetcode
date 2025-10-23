class Solution {
    public boolean hasSameDigits(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);

        while(n > 2) {
            for(int i = 0; i < n-1; i++) {
                int n1 = sb.charAt(i) - '0';
                int n2 = sb.charAt(i+1) - '0';
                int sum = (n1 + n2) % 10;
                sb.setCharAt(i, (char)(sum + '0'));
            }
            n--;
        }

        return sb.charAt(0) == sb.charAt(1);
    }
}
/**
TC = O(n^2)
SC = O(1) */
