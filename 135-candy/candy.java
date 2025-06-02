class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] count = new int[n];
        Arrays.fill(count, 1);

        // comparing with left neighbour
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                count[i] = Math.max(count[i], count[i - 1] + 1);
            }
        }

        // comparing with right neighbour
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                count[i] = Math.max(count[i], count[i + 1] + 1);
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans += count[i];
        }

        return ans;
    }
}
/**
TC = O(n)
SC = O(n) */