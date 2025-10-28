class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int currSum = 0;

        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        for(int i = 0; i < n; i++) {
            currSum += nums[i];
            
            int left = currSum;
            int right = sum - left;

            if(nums[i] != 0) {
                continue;
            }

            if(left == right) {
                ans += 2;
            } else if(Math.abs(left - right) == 1) {
                ans += 1;
            }
        }

        return ans;
    }
}
/**
TC = O(n)
SC = O(1) */