class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int emptybottles = numBottles;
        int consumed = numBottles;

        while(emptybottles >= numExchange) {
            int extraBottles = emptybottles/numExchange;
            int remain = emptybottles%numExchange;
            consumed += extraBottles;
            emptybottles = extraBottles + remain;
        }

        return consumed;
    }
}
/**
TC = O(log(numExchange))
SC = O(1) */