class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            adjList[node1].add(node2);
            adjList[node2].add(node1);
        }
        int[] componentCount = new int[1];      // taken arr coz in java it's passes by value not ref
        dfs(0, -1, adjList, values, k, componentCount);     // 0 for starting, -1 as it is parent node
        return componentCount[0];
    }

    private long dfs(int currNode, int parentNode, List<Integer>[] adjList, int[] nodeValues, int k,
            int[] componentCount) {
        long sum = 0;
        for (int neighbourNode : adjList[currNode]) {
            if(parentNode != neighbourNode) {         // then it is leaf node
                sum += dfs(neighbourNode, currNode, adjList, nodeValues, k, componentCount);
            }
        }
        sum += nodeValues[currNode];
        if (sum % k == 0) {
            componentCount[0]++;
            sum = 0;
        }
        return sum;
    }
}