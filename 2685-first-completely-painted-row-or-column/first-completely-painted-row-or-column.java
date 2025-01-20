class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, int[]> mp = new HashMap<>();   // storing {cell value, {i,j}}

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int val = mat[i][j];
                mp.put(val, new int[]{i, j});
            }
        }

        for(int i = 0; i < arr.length; i++) {
            int value = arr[i];
            int[] coordinates = mp.get(value);
            int row = coordinates[0];
            int col = coordinates[1];
            mat[row][col] *= -1;    // painted

            if(checkRowPainted(mat, row) || checkColumnPainted(mat, col)) {
                return i;
            }
        }

        return -1;
    }

    private boolean checkRowPainted(int[][] mat, int row) {
        for(int col = 0; col < mat[0].length; col++) {
            if(mat[row][col] > 0) {         // some row's cell not painted
                return false;
            }
        }
        return true;
    }

    private boolean checkColumnPainted(int[][] mat, int col) {
        for(int row = 0; row < mat.length; row++) {
            if(mat[row][col] > 0) {       // some column's cell not painted
                return false;
            }
        }
        return true;
    }
}
/**
BRUTE FORCE
TC = O((m*n) * s(m*n))
SC = O(m*n) */