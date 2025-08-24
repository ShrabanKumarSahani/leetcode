class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int i = 0;
        int maxLength = 0;
        int zeroCount = 0;

        for(int j = 0; j < n; j++) {
            
            if(nums[j] == 0) {
                zeroCount++;
            }

            while(zeroCount > 1) {
                if(nums[i] == 0)
                    zeroCount--;
                i++;
            }

            maxLength = Math.max(maxLength, j-i);
        }
        return maxLength;
    }
}