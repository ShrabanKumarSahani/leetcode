class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        if(k == n) {
            return nums;
        }

        // pairing index and value
        int[][] vec = new int[n][2];
        for(int i = 0; i < n; i++) {
            vec[i][0] = i;
            vec[i][1] = nums[i];
        }

        // sorting by value desc
        Arrays.sort(vec, (a,b) -> Integer.compare(b[1], a[1]));
        // sort the top k by original idx to maintain order
        Arrays.sort(vec, 0, k, Comparator.comparingInt(a->a[0]));

        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = vec[i][1];
        }

        return ans;
    }
}
/**
TC = O(nlogn)
SC = O(1)
 */