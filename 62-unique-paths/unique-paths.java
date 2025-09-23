class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++) 
            dp[i][0] = 1;   // 1st row

        for(int j = 0; j < n; j++) 
            dp[0][j] = 1;   // 1st col

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];     // either come from up or left
            }
        }

        return dp[m-1][n-1];
    }
}
/**
TC = O(mn)
SC = O(mn) */