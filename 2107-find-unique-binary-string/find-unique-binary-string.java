class Solution {
    StringBuilder ans;
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        HashSet<String> set = new HashSet<>();
        for(String num : nums) {
            set.add(num);
        }
        ans = new StringBuilder("");
        backtrack(nums, n, set, ans);
        return ans.toString();
    }

    public boolean backtrack(String nums[], int n, HashSet<String> set, StringBuilder ans) {
        if(ans.length() == n) {
            if(!set.contains(ans.toString())) {
                return true;
            }
            return false;
        }

        for(char ch = '0'; ch <= '1'; ch++) {
            ans.append(ch);
            if(backtrack(nums, n, set, ans)) {
                return true;
            }
            ans.deleteCharAt(ans.length() - 1);
        }

        return false;
    }
}
/**
TC = O(2^n)
SC = O(n)
*/