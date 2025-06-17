class Solution {
    static final int MOD = (int)1e9 + 7;

    // binary exponentiation: a^b % MOD
    public long power(long a, long b) {
        long ans = 1;
        a %= MOD;
        while(b > 0) {
            if((b & 1) == 1) 
                ans = (ans*a) % MOD;
            a = (a*a) % MOD;
            b >>= 1;
        }
        return ans;
    }

    public long nCr(int n, int r, long[] fact, long[] invFact) {
        return fact[n] * invFact[n-r] % MOD * invFact[r] % MOD;
    }

    public int countGoodArrays(int n, int m, int k) {
        long[] fact = new long[n+1];
        long[] invFact = new long[n+1];
        
        fact[0] = 1;
        for(int i = 1; i <= n; i++) {
            fact[i] = (fact[i-1]*i) % MOD;
        }

        // finding inverse factorials via Fermat's Theorem
        for(int i = 0; i <= n; i++) {
            invFact[i] = power(fact[i], MOD - 2);
        }

        long ans = nCr(n-1, k, fact, invFact);
        ans = ans * m % MOD;
        ans = ans * power(m-1, n-k-1) % MOD;

        return (int) ans;
    }
}
/**
TC = O(log(n-k-1))
SC = O(n) */