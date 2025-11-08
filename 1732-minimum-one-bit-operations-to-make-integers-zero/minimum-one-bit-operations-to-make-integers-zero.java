class Solution {
    public int minimumOneBitOperations(int n) {
        if(n == 0)
            return 0;
        
        long[] function = new long[32];
        // funtion[i] = x -> means it will take x operations to make ith bit 1
        function[0] = 1;
        for(int i = 1; i <= 31; i++) {
            function[i] = 2*function[i-1] + 1;
        }

        int ans = 0;
        int sign = 1;

        for(int i = 30; i >= 0; i--) {
            int ithBit = ((1 << i) & n);
            if(ithBit == 0) {
                continue;
            }
            if(sign > 0) {
                ans += function[i];
            } else {
                ans -= function[i];
            }

            sign *= -1;
        }

        return ans;
    }
}
/**
TC = O(1)
SC = O(32) */