class Solution {
    public int minimizeXor(int num1, int num2) {
        int ans = 0;
        int reqdSetBitCount = Integer.bitCount(num2);   // log(n)

        // Setting bits
        for(int bit = 31; bit >= 0 && reqdSetBitCount > 0; bit--) {
            if(isSet(num1, bit)) {
                ans |= (1 << bit);
                reqdSetBitCount--;
            }
        }

        // Unsetting bits
        for(int bit = 0; bit < 32 && reqdSetBitCount > 0; bit++) {
            if(isUnSet(num1, bit)) {
                ans |= (1 << bit);
                reqdSetBitCount--;
            }
        }

        return ans;
    }

    // helper functions
    public boolean isSet(int ans, int bit) {
        return (ans & (1<<bit)) != 0;
    }

    public boolean isUnSet(int ans, int bit) {
        return (ans & (1 << bit)) == 0;
    }
}
/**
TC = O(logn)
SC = O(1) */