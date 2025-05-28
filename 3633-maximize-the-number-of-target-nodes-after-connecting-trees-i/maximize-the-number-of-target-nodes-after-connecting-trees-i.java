class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int[] ans1 = findCount(edges1, k);
        int[] ans2 = findCount(edges2, k - 1);

        int maxTargetNodesCount = Arrays.stream(ans2).max().getAsInt();

        for (int i = 0; i < n; i++) {
            ans1[i] += maxTargetNodesCount;
        }

        return ans1;
    }

    private int bfs(int curr, Map<Integer, List<Integer>> adj, int d, int N) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { curr, 0 });
        boolean[] visited = new boolean[N];
        visited[curr] = true;

        int count = 0;
        while (!q.isEmpty()) {
            int[] pair = q.poll();
            int currNode = pair[0];
            int dist = pair[1];

            if (dist > d) {
                continue;
            }

            count++;

            for (int neighbour : adj.getOrDefault(currNode, new ArrayList<>())) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.offer(new int[] { neighbour, dist + 1 });
                }
            }
        }
        return count;
    }

    private int[] findCount(int[][] edges, int d) {
        int N = edges.length + 1;
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            ans[i] = bfs(i, adj, d, N);
        }

        return ans;
    }
}