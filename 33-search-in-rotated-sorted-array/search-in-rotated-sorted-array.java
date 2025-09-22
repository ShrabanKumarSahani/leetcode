class Solution {
    public int search(int[] nums, int target) {
        int l = nums.length;
        int left = 0, right = l-1;

        while(left < right) {
            int mid = (left + right)/2;
            if(nums[0] <= nums[mid]) {
                if(nums[0] <= target && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[l - 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return nums[left] == target ? left : -1;  
    }
}