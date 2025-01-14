class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];

        boolean[] isPresentA = new boolean[n+1];
        boolean[] isPresentB = new boolean[n+1];

        for(int i = 0; i < n; i++) {
            isPresentA[A[i]] = true;
            isPresentB[B[i]] = true;
            int count = 0;
            for(int x = 1; x <= n; x++) {
                if(isPresentA[x] == true && isPresentB[x] == true) {
                    count++;
                }
            }

            ans[i] = count;  
        }
        return ans;
    }
}
/**
BRUTE FORCE
TC = O(n^2)
SC = O(n) */