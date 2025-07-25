class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> st = new HashSet<>();
        int sum = 0;
        int maxNegative = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0) {
                maxNegative = Math.max(maxNegative, nums[i]);
            } else if(!st.contains(nums[i])) {
                sum += nums[i];
                st.add(nums[i]);
            }
        }

        return sum == 0 ? maxNegative : sum;
    }
}
/**
TC = O(n)
SC = O(n) */