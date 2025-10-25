class Solution {
    public int totalMoney(int n) {
        int ans = 0;
        int monday_money = 1;

        while(n > 0) {
            int money = monday_money;
            for(int i = 1; i <= Math.min(n, 7); i++) {
                ans += money;
                money++;
            }
            monday_money++;
            n -= 7;
        }

        return ans;
    }
}
/**
TC = O(1)
SC = O(1) */