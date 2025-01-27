class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : prerequisites) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }

        boolean[][] isPrerequisite = new boolean[numCourses][numCourses];
        preprocess(numCourses, adjList, isPrerequisite);

        List<Boolean> res = new ArrayList<>();
        for (int[] q : queries) {
            res.add(isPrerequisite[q[0]][q[1]]);
        }

        return res;
    }

    private void preprocess(int numCourses, Map<Integer, List<Integer>> adjList, 
    boolean[][] isPrerequisite) {
        for(int i = 0; i < numCourses; i++) {
            for(int j = 0; j < numCourses; j++) {
                if(i != j ){
                    boolean[] visited = new boolean[numCourses];
                    if(dfs(adjList, visited, i, j)) {
                        isPrerequisite[i][j] = true;
                    }
                }
            }
        }
    }

    private boolean dfs(Map<Integer, List<Integer>> adjList, boolean[] visited, int src, int target) {
        visited[src] = true;
        if (src == target) {
            return true;
        }
        for (int adjNode : adjList.getOrDefault(src, new ArrayList<>())) {
            if (!visited[adjNode] && dfs(adjList, visited, adjNode, target)) {
                return true;
            }
        }
        return false;
    }
}
/**
TC = O(V^2 + (V+E))
SC = O(V+E) */