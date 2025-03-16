class Solution {
    public long repairCars(int[] ranks, int cars) {
        long l = 1;
        long r = 1L * cars * cars * Arrays.stream(ranks).max().orElse(Integer.MIN_VALUE);

        while(l < r) {      //O(log(maxRank*cars^2))
            long mid = l + (r-l)/2;
            if(isPossible(ranks, mid, cars)) {  //O(n)
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    public boolean isPossible(int[] ranks, long mid, int cars) {
        long carsRepair = 0;
        for(int rank : ranks) {
            carsRepair += Math.sqrt(1.0 * mid/rank); 
        }
        return carsRepair >= cars;
    }
}
/**
TC = O(n) *O(log(maxRank*cars^2))
SC = O(1) */