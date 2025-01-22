class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] height = new int[m][n];
        Queue<int[]> q = new LinkedList<>();

        // initializing the queue with all water cells and setting their height to 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    q.offer(new int[] { i, j });
                    height[i][j] = 0;
                } else {
                    height[i][j] = -1; // mark unvisited land cells
                }
            }
        }

        // multi source BFS
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!q.isEmpty()) {
            int ns = q.size();
            while(ns-- > 0) {
                int[] curr = q.poll();
                int i = curr[0];
                int j = curr[1];

                for(int[] d : directions) {
                    int new_i = i + d[0];
                    int new_j = j + d[1];

                    if(new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && height[new_i][new_j] == -1) {
                        height[new_i][new_j] = height[i][j] + 1;
                        q.offer(new int[]{new_i, new_j});
                    }
                }
            }
        }
        return height;
    }
}
/**
TC = O(m*n)
SC = O(m*n)
 */