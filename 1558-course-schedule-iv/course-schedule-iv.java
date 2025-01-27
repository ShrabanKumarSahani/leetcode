class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);   // u -> v
        }

        int Q = queries.length;
        List<Boolean> res = new ArrayList<>(Q);

        for(int i = 0; i < Q; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            boolean[] visited = new boolean[numCourses];
            res.add(dfs(adj, u, v, visited));
        }

        return res;
    }

    private boolean dfs(Map<Integer, List<Integer>> adj, int src, int dest, boolean[] visited) {
        visited[src] = true;
        if(src == dest) {
            return true;
        }

        boolean isReachable = false;
        for(int adjNode : adj.getOrDefault(src, new ArrayList<>())) {
            if(!visited[adjNode]) {
                isReachable = isReachable || dfs(adj, adjNode, dest, visited);
            }
        }
        return isReachable;
    }
}