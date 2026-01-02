class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> seenNumbers = new HashSet<>(nums.length / 2 + 1);
      
        for (int i = 0; ; ++i) {
            if (!seenNumbers.add(nums[i])) {
                return nums[i];
            }
        }
    }
}