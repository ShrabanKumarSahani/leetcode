class Solution {
    public long countSubarrays(int[] nums, long k) {
        long sum = 0;
        long ans = 0;
        int i = 0, j = 0, n = nums.length;
        
        while(j < n) {
            sum += nums[j];
            while(i <= j && sum*(j-i+1) >= k) {
                sum -= nums[i];
                i++;
            }
            ans += (j-i+1);
            j++;
        }

        return ans; 
    }
}
/**
TC = O(n)
SC = O(1) */