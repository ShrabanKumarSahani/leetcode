class Solution {
    private int n ;

    private void bfs(int[] edges, int startNode, int[] dist_node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(startNode);
        dist_node[startNode] = 0;
        boolean[] visited = new boolean[n];
        visited[startNode] = true;

        while(!q.isEmpty()) {
            int u = q.poll();
            int v = edges[u];

            if(v != -1 && !visited[v]) {
                visited[v] = true;
                dist_node[v] = 1 + dist_node[u];
                q.offer(v);
            }
        }
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];

        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        bfs(edges, node1, dist1);
        bfs(edges, node2, dist2);

        int minDistNode = -1;
        int minDistTillNow = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            int maxDist = Math.max(dist1[i], dist2[i]);
            if(dist1[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE) {
                if(maxDist < minDistTillNow) {
                    minDistTillNow = maxDist;
                    minDistNode = i;
                }
            }
        }

        return minDistNode;
    }
}