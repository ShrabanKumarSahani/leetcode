class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int currRun = 1;
        int prevRun = 0;

        for(int i = 1; i < n; i++) {
            if(nums.get(i) > nums.get(i-1)) {
                currRun++;
            } else {
                prevRun = currRun;
                currRun = 1;
            }


            // if curr run itself can fit 2 subarrays of length k
            if(currRun >= 2*k) {
                return true;
            }

            // if current and previous increasing runs can fit one subarray each
            if(Math.min(currRun, prevRun) >= k) {
                return true;
            }
        }

        return false;
    }
}
/**
TC = O(n)
SC = O(1) */