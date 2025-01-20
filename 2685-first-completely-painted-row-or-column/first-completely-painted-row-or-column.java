class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;     // columns
        int n = mat[0].length;  // rows
        Map<Integer, Integer> mp = new HashMap<>();   // storing {cell value, {i,j}}
        int minIndex = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++) {
            mp.put(arr[i], i);
        }

        // checking each row one by one
        for(int row = 0; row < m; row++) {
            int lastIndex = Integer.MIN_VALUE;  // last index when row will be completely painted
            for(int col = 0; col < n; col++) {
                int value = mat[row][col];
                int index = mp.get(value);
                lastIndex = Math.max(lastIndex, index);
            }
            minIndex = Math.min(minIndex, lastIndex);
        }

        // checking each column one by one
        for(int col = 0; col < n; col++) {
            int lastIndex = Integer.MIN_VALUE;  // last index when row will be completely painted
            for(int row = 0; row < m; row++) {
                int value = mat[row][col];
                int index = mp.get(value);
                lastIndex = Math.max(lastIndex, index);
            }
            minIndex = Math.min(minIndex, lastIndex);
        }

        return minIndex;
    }
}
/**
BRUTE FORCE
TC = O(m*n)
SC = O(m*n)*/