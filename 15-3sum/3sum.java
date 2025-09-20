class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int l = nums.length;

        // triplets -> l-2, sum == 0 -> num <= 0
        for (int i = 0; i < l - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { //first element no duplicate
                continue;
            }

            int left = i + 1;
            int right = l - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) { // as arr is sorted, we need +ve num to make sum 0 so moving left
                    left++;
                } else if (sum > 0) {
                    right--; // vice versa
                } else {
                    ans.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // skip duplicate elements for 2nd element
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // similar for 3rd element
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
/**
TC = O(n^2)
SC = (logn) */