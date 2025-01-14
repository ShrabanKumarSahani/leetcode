class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        HashMap<Integer, Integer> hs = new HashMap<>();
        int count = 0;
        for(int i = 0; i < n; i++) {
            hs.put(A[i], hs.getOrDefault(A[i], 0) + 1);
            if(hs.get(A[i]) == 2) {
                count++;
            }

            hs.put(B[i], hs.getOrDefault(B[i], 0) + 1);
            if(hs.get(B[i]) == 2) {
                count++;
            }
            ans[i] = count;  
        }
        return ans;
    }
}
/**
BRUTE FORCE
TC = O(n)
SC = O(n) */