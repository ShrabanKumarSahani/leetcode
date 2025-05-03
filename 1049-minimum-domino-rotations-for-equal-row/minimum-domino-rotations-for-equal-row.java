class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= 6; i++) {
            int swaps = findSwap(tops, bottoms, i);
            if(swaps != -1) {
                ans = Math.min(ans, swaps);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int findSwap(int[] tops, int[] bottoms, int value) {
        int swapTop = 0;
        int swapBottom = 0;
        int n = tops.length;

        for(int i = 0; i < n; i++) {
            if(tops[i] != value && bottoms[i] != value) {
                return -1;
            } else if(tops[i] != value) {
                swapTop++;
            } else if(bottoms[i] != value) {
                swapBottom++;
            }
        }

        return Math.min(swapTop, swapBottom);
    }
}
/**
TC = O(n)
SC = O(1) */