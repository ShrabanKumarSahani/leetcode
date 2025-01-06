class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
        int cummValue = 0, cummSum = 0;

        // finding moves for all left balls to index i
        for (int i = 0; i < n; i++) {
            ans[i] = cummSum;
            cummValue += boxes.charAt(i) == '1' ? 1 : 0;
            cummSum += cummValue;
        }

        cummValue = 0;
        cummSum = 0;

        // for right balls moves to index i
        for (int i = n - 1; i >= 0; i--) {
            ans[i] += cummSum;
            cummValue += boxes.charAt(i) == '0' ? 0 : 1;
            cummSum += cummValue;
        }

        return ans;
    }
}
/**
 * Prefix/Suffix Sum
 * TC = O(n)
 * SC = O(1)
 */