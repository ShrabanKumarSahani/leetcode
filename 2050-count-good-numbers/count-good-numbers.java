class Solution {
    static final int M = (int)1e9 + 7;

    public int countGoodNumbers(long n) {
       long oddPositions = (n+1)/2;
       long evenPositions = n/2;

       long ans = (findPower(5,oddPositions) * findPower(4,evenPositions)) % M;
       return (int) ans; 
    }

    private long findPower(long a, long b) {
        if(b == 0) {
            return 1;
        }

        long half = findPower(a, b/2);
        long ans = (half * half) % M;

        if(b%2 == 1) {
            ans = (ans*a)%M;
        }

        return ans;
    }
}
/**
TC = O(logn)
SC = O(1)
*/