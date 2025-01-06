class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
        HashSet<Integer> hs = new HashSet<>();

        for(int i = 0; i < n; i++) {
            if(boxes.charAt(i) == '1') {
                hs.add(i);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int index: hs) {
                ans[i] += Math.abs(i-index);
            }
        }

        return ans;
    }
}
/**
BRUTE APP - 2 - HASHMAP
TC = O(n)
SC = O(n)
 */