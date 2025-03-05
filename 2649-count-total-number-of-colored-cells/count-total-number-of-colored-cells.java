class Solution {
    public long coloredCells(int n) {
        long ans = 1;
        long x = 4;
        n--;
        while(n > 0) {
            ans += x;
            x += 4;
            n--;
        }
        return ans;
    }
}
/**
TC = O(n)
SC = O(1) */