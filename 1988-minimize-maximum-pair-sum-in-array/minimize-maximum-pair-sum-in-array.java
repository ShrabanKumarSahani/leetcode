class Solution {
    public int minPairSum(int[] nums) {
       // lets break the question - 
       // sorting
        int n = nums.length;
        Arrays.sort(nums);
       // minimize pair sum = smallest + largest (nums)
       // then we maximum of sum of pairs
       int ans = Integer.MIN_VALUE;
       for(int i = 0, j = n-1; i < n && j >= 0; i++, j--) {
            ans = Math.max(ans, nums[i] + nums[j]);
       }
        return ans;
    }
}
/**
 * [3,5,2,3] -> [2,3,3,5]
 * [2,5], [3,3]
 * 
 * [2,5] -> 7 , [3,3] -> 6 -> ans = 7(min)
 * [2,3] -> 5 , [3,5] -> 8 -> ans = 8
 */