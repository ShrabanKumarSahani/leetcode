class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j <= i; j++) {
                for(int k = 0; k <= i; k++) {
                    if(B[k] == A[j]) {
                        count++;
                        break;
                    }
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}
/**
BRUTE FORCE
TC = O(n^3)
SC = O(n) */