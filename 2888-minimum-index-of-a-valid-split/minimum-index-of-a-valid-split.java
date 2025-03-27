class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        HashMap<Integer, Integer> mp1 = new HashMap<>();
        HashMap<Integer, Integer> mp2 = new HashMap<>();

        for (int num : nums)
            mp2.put(num, mp2.getOrDefault(num, 0) + 1);

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            mp1.put(num, mp1.getOrDefault(num, 0) + 1);
            mp2.put(num, mp2.get(num) - 1);

            int n1 = i + 1;
            int n2 = n - 1 - i;

            if (mp1.get(num) * 2 > n1 && mp2.get(num) * 2 > n2) {
                return i;
            }
        }
        return -1;
    }
}
/**
 * TC = O(n)
 * SC = O(n)
 */