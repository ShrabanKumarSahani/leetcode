class Solution {
    public int findClosest(int x, int y, int z) {
        int ans = 0;
        ans = Math.abs(z - x);
        int disty = Math.abs(z - y);
        if (ans == disty) {
            return 0;
        }
        if (ans > disty) {
            return 2;
        }
        return 1;
    }
}