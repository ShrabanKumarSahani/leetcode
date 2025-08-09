class Solution {
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && (((n - 1) & n) == 0);
    }
}
/**
TC = O(1)
SC = O(1) */