class Solution {
    public int punishmentNumber(int n) {
       int ans = 0;
       for(int i = 1; i <= n; i++) {
            String i2String = Integer.toString(i*i);
            int l = i2String.length();
            int dp[][] = new int[l][i+1];   // memo

            for(int k = 0; k < l; k++) {
                Arrays.fill(dp[k], -1);
            }

            if(isPartition(0, i2String, i, 0, dp)) {
                ans += (i*i);
            }
       }
       return ans; 
    }

    public boolean isPartition(int j, String i2String, int i, int currSum, int dp[][]) {
        int n = i2String.length();

        // base case
        if(j == n) {
            return currSum == i;
        }

        if(currSum > i) {
            return false;
        }

        if(dp[j][currSum] != -1) {
            return (dp[j][currSum] == 1);
        }

        for(int idx = j; idx < n; idx++) {
            int value = Integer.parseInt(i2String.substring(j, idx + 1));
            if(isPartition(idx + 1, i2String, i, currSum + value, dp)) {
                dp[j][currSum] = 1;
                return true;
            }
        }

        dp[j][currSum] = 0;
        return false;
    }
}