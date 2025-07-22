class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        int i = 0, j = 0, curr_sum = 0, result = 0;
        int n = nums.length;
        while (j < n) {
            hm.put(nums[j], hm.getOrDefault(nums[j], 0) + 1);
            curr_sum += nums[j];
            while (hm.get(nums[j]) > 1) {
                hm.put(nums[i], hm.getOrDefault(nums[i], 0) - 1);
                curr_sum -= nums[i];
                i++;
            }
            result = Math.max(result, curr_sum);
            j++;
        }
        return result;
    }
    /**
    TC = O(n)
    SC = O(n) */
}