class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int previousCount = 0;
        int ans = 0;

        for(int i = 0; i < n; i++) {
            int currDeviceCount = 0;
            for(char ch : bank[i].toCharArray()) {
                if(ch == '1') {
                    currDeviceCount++;
                }
            }
            ans += (previousCount * currDeviceCount);
            previousCount = (currDeviceCount == 0) ? previousCount : currDeviceCount;
        }

        return ans;
    }
}
/**
TC = O(m*n)
SC = O(1) */