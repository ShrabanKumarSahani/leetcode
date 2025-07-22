class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> st = new HashSet<>();
        int i = 0, j = 0, sum = 0, ans = 0;

        while(i < nums.length) {
            if(!st.contains(nums[i])) {
                sum += nums[i];
                ans = Math.max(sum, ans);
                st.add(nums[i++]);
            } else {
                sum -= nums[j];
                st.remove(nums[j++]);
            }
        }

        return ans;
    }
}
/**
TC = O(n)
SC = O(n)
*/