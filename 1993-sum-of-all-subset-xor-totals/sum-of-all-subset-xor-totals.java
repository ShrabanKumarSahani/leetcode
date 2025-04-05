class Solution {
    public int subsetXORSum(int[] nums) {
        int ans = 0; 
        for(int num : nums) {
            ans |= num;
        }
        return ans << (nums.length -1);
    }
}
/**
TC = O(n)
SC = O(1) */