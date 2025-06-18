class Solution {
    public int[][] divideArray(int[] nums, int k) {
        // sorting the array to get increasing array to ease the diff of k check
        Arrays.sort(nums);
        int m = nums.length;
        // a list to store the valid triplets 
        List<int[]> ansList = new ArrayList<>();

        for (int i = 2; i < m; i += 3) {
            // if diff of nums[i] & nums[i-2] is <= k then only we will add;
            if (nums[i] - nums[i - 2] > k) {
                return new int[0][];
            }
            ansList.add(new int[] { nums[i - 2], nums[i-1], nums[i] });
        }

        int[][] ans = new int[ansList.size()][3];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}

/**
TC = O(m-2)*(no of triplets)
SC = O(no.of.triplets)
 */