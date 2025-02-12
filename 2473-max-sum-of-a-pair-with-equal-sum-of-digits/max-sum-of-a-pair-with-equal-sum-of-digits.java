class Solution {
    private int getDigitSum(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num%10;
            num /= 10;
        }
        return sum;
    }

    public int maximumSum(int[] nums) {
        int n = nums.length;
        int ans = -1;

        int[] mp = new int[82];

        for(int i = 0; i < n; i++) {
            int digitSum = getDigitSum(nums[i]);
            if(mp[digitSum] > 0) {
                ans = Math.max(ans, mp[digitSum] + nums[i]);
            }
            mp[digitSum] =  Math.max(nums[i], mp[digitSum]); 
        }

        return ans;
    }
}
/**
 TC = O(n*m)
 SC = O(n)

 nums[i] <= 10^9 -> max sum = 9...9times = 81 + 1(10^9) = 82
 */