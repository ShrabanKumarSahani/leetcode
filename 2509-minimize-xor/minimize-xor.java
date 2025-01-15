class Solution {
    public int minimizeXor(int num1, int num2) {
        int ans = num1;
        int reqdSetBitCount = Integer.bitCount(num2);
        int currSetBitCount = Integer.bitCount(ans);
        int bit = 0;

        if(currSetBitCount < reqdSetBitCount) {
            while(currSetBitCount < reqdSetBitCount) {
                if(!isSet(ans, bit)) {
                    ans = setBit(ans, bit);
                    currSetBitCount++;
                }
                bit++;
            }
        } else if(currSetBitCount > reqdSetBitCount) {
            while(currSetBitCount > reqdSetBitCount) {
                if(isSet(ans, bit)) {
                    ans = unsetBit(ans, bit);
                    currSetBitCount--;
                }
                bit++;
            }
        }

        return ans;
    }

    // helper functions
    public boolean isSet(int ans, int bit) {
        return (ans & (1<<bit)) != 0;
    }

    public int setBit(int ans, int bit) {
        return ans | (1 << bit);
    }

    public int unsetBit(int ans, int bit) {
        return ans & ~(1 << bit);
    }
}
/**
TC = O(nlogn)
SC = O(1) */