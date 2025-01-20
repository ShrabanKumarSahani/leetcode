class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;     // columns
        int n = mat[0].length;  // rows
        Map<Integer, int[]> mp = new HashMap<>();   // storing {cell value, {i,j}}

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int val = mat[i][j];
                mp.put(val, new int[]{i, j});
            }
        }

        int[] countRowsPaint = new int[m];
        int[] countColumnsPaint = new int[n];

        for(int i = 0; i < arr.length; i++) {
            int value = arr[i];
            int[] coordinates = mp.get(value);
            int row = coordinates[0];
            int col = coordinates[1];

            countRowsPaint[row]++;
            countColumnsPaint[col]++;

            if(countRowsPaint[row] == n || countColumnsPaint[col] == m) {
                return i;
            }
        }

        return -1;
    }
}
/**
BRUTE FORCE
TC = O(m*n)
SC = O(m*n)[map] + O(m+n) [count arr]*/