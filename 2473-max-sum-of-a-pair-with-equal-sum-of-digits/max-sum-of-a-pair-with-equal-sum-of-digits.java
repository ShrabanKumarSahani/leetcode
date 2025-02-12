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

        Map<Integer, Integer> mp = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int digitSum = getDigitSum(nums[i]);
            if(mp.containsKey(digitSum)) {
                ans = Math.max(ans, mp.get(digitSum) + nums[i]);
            }
            mp.put(digitSum, Math.max(nums[i], mp.getOrDefault(digitSum, 0))); 
        }

        return ans;
    }
}
/**
 TC = O(n*m)
 SC = O(n)
 */