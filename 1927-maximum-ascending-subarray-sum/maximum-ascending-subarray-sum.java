class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int maxSum = 0;
        

        for(int i = 0; i < n ; i++) {
            int j = i+1;
            int sum = nums[i];
            while(j < n && nums[j] > nums[j-1]) {
                sum += nums[j];
                j++;
            }
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }
}
/**
 * TC = O(n^2)
 * SC = O(1)
 */