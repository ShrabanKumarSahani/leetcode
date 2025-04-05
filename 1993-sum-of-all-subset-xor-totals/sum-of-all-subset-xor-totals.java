class Solution {
    public int subsetXORSum(int[] nums) {
        return solve(nums, 0, 0);
    }

    private int solve(int[] nums, int i, int XOR) {
        if(i == nums.length) {
            return XOR;
        }

        int include = solve(nums, i+1, XOR^nums[i]);
        int exclude = solve(nums, i+1, XOR);

        return include + exclude;
    }
}
/**
TC = O(2^n)
SC = O(n) */