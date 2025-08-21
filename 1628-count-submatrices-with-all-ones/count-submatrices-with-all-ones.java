class Solution {
    public int numSubmat(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int totalCount = 0;

        for(int topRow = 0; topRow < rows; topRow++) {
            int[] rowMask = new int[cols];
            for(int i = 0; i < cols; i++) 
                rowMask[i] = 1;

            // expanding bottom row
            for(int bottomRow = topRow; bottomRow < rows; bottomRow++) {
                // Update rowMask using AND
                for(int col = 0; col < cols; col++) {
                    rowMask[col] = rowMask[col] & mat[bottomRow][col];
                }
                // Count submatrices from this row span
                totalCount += countSubarraysOfOnes(rowMask);
            }
        }
        return totalCount;
    }

    private int countSubarraysOfOnes(int[] rowMask) {
        int consecutiveOnes = 0;
        int subarrayCount = 0;

        for(int val : rowMask) {
            if(val == 0) {
                consecutiveOnes = 0;
            } else {
                consecutiveOnes++;
            }
            subarrayCount += consecutiveOnes;
        }
        return subarrayCount;
    }
}
/**
TC = O(m*m*n)
SC = O(n) */