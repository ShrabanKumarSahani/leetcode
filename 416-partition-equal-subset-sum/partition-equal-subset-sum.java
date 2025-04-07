class Solution {
    int[][] t = new int[201][20001];

    boolean solve(List<Integer> nums, int i, int x) {
        if(x == 0) {
            return true;
        }

        if(i >= nums.size()) {
            return false;
        }

        if(t[i][x] != -1) {
            return t[i][x] == 1;
        }

        boolean take = false;
        if(nums.get(i) <= x) {
            take = solve(nums, i+1, x - nums.get(i));
        }

        boolean not_take = solve(nums, i+1, x);

        t[i][x] = (take || not_take) ? 1 : 0;
        return take || not_take;
    }

    public boolean canPartition(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        int s = 0;
        for(int num : nums) {
            numsList.add(num);
        }

        for(int num : numsList) {
            s += num;
        }

        if(s%2 != 0) {
            return false;
        }

        for(int[] row : t) {
            Arrays.fill(row, -1);
        }

        int x = s/2;

        return solve(numsList, 0, x);
    }
}
/**
x = totalSum/2
TC = O(n*x)
SC = O(n*x) 
*/