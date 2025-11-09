class Solution {
    public int countOperations(int num1, int num2) {
        int count = 0;
        while(num1 > 0 && num2 > 0) {
            count += num1/num2;
            num1 %= num2;

            // swapping
            int s = num1;
            num1 = num2;
            num2 = s;
        }

        return count;
    }
}
/**
TC = O(log(min(a,b)))
SC = O(1) */