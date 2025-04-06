class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int[] t = new int[n];
        Arrays.fill(t,1);

        int[] prevIdx = new int[n];
        Arrays.fill(prevIdx, -1);

        int lastChosenIdx = 0;
        int maxL = 1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0) {
                    if(t[i] < t[j]+1) {
                        t[i] = t[j] + 1;
                        prevIdx[i] = j;
                    }

                    if(t[i] > maxL) {
                        maxL = t[i];
                        lastChosenIdx = i;
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(lastChosenIdx >= 0) {
            ans.add(nums[lastChosenIdx]);
            lastChosenIdx = prevIdx[lastChosenIdx];
        }

        return ans;
    }
}
/**
TC = O(n^2)
SC = O(n) */