class Solution {
    private int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // minheap
        int[][] ans = new int[m][n];    // O(m*n) -> SC
        for (int[] row : ans) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        pq.offer(new int[] { 0, 0, 0 });
        ans[0][0] = 0;

        while (!pq.isEmpty()) {     //O(N) * log(N) -> TC
            int[] curr = pq.poll(); //log(N)
            int currCost = curr[0];
            int i = curr[1], j = curr[2];

            if (ans[i][j] < currCost) {
                continue;
            }

            for (int direction = 0; direction <= 3; direction++) {
                int newi = i + directions[direction][0];
                int newj = j + directions[direction][1];

                if (newi >= 0 && newj >= 0 && newi < m && newj < n) {
                    int gridDirection = grid[i][j];
                    int costWDirection = (gridDirection - 1 != direction) ? 1 : 0;
                    int newCost = currCost + costWDirection;
                    if (newCost < ans[newi][newj]) {
                        ans[newi][newj] = newCost;
                        pq.offer(new int[] { newCost, newi, newj });
                    }
                }
            }
        }
        return ans[m - 1][n - 1];
    }
}
/**
 * TC = O(m*n * log(m*n))
   SC = O(m*n)
 */