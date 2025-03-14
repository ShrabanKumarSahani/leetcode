class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        int maxCandy = 0;
        long totalCandies = 0;

        for(int i = 0; i < n; i++) {
            totalCandies += candies[i];
            maxCandy = Math.max(maxCandy, candies[i]);
        }

        if(totalCandies < k) {
            return 0;
        }

        int l = 1;
        int r = maxCandy;
        int ans = 0;

        while(l <= r) {
            int mid = l + (r-l)/2;
            if(canDistribute(candies, mid, k)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    private boolean canDistribute(int[] candies, int mid, long k) {
        int n = candies.length;
        for(int i = 0; i < n; i++) {
            k -= candies[i]/mid;
            if(k<=0) {
                return true;
            }
        }
        return k <= 0;
    }
}
/**
TC = O(n * log(maxCandy))
SC = O(1) */