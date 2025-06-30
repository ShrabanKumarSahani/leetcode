class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int ans = 0;

        // counting frequencies
        for(int num : nums) {
            mp.put(num, mp.getOrDefault(num,0)+1);
        }

        // check for harmonious subsequences
        for(int num : nums) {
            int minNum = num;
            int maxNum = num+1;

            if(mp.containsKey(maxNum)) {
                ans = Math.max(ans, mp.get(minNum) + mp.get(maxNum));
            }
        }

        return ans;
    }
}
/**
TC = O(n)
SC = O(n) */