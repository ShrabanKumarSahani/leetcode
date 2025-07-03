class Solution {
    public char kthCharacter(int k) {
        int shift = Integer.bitCount(k-1);
        return(char)('a' + shift);
    }
}
/**
TC = O(log(k-1))
SC = O(1) */