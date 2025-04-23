class Solution {
    private int digitsum(int num) {
        int sum = 0;
        while(num > 0) {    //logn
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        int count = 0;
        int maxSize = 0;
        for(int num = 1; num <= n; num++) {     //n
            int sum = digitsum(num);
            hs.put(sum, hs.getOrDefault(sum, 0) + 1);

            if(maxSize < hs.get(sum)) {
                maxSize = hs.get(sum);
                count = 1;
            } else if(hs.get(sum) == maxSize) {
                count++;
            }
        }

        return count;
    }
}
/**
TC = O(n*logn)
SC = O(n) */