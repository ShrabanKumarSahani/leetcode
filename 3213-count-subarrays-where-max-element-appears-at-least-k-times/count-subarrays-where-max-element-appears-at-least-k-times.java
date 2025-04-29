class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxE = Arrays.stream(nums).max().getAsInt();
        int n = nums.length;
        int i = 0, j = 0;

        long ans = 0;
        int countMax = 0;

        while(j < n) {
            if(nums[j] == maxE) {
                countMax++;
            }

            while(countMax >= k) {
                ans += n - j;
                if(nums[i] == maxE) {
                    countMax--;
                }
                i++;
            }

            j++;
        }

        return ans;
    }
}
/**
TC = O(n)
SC = O(1) */