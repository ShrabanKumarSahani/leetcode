class Solution {
    public long coloredCells(int n) {
        return 1 + (long) 2 * (n-1) * n;
    }
}
/**
TC = O(1)
SC = O(1) */