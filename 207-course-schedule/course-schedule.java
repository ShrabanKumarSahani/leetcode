class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        Arrays.setAll(graph, index -> new ArrayList<>());

        // tracking indegree of each course
        int[] indegree = new int[numCourses];

        // building graph and calculating indegrees
        // [a,b] : course a depends on course b, b -> a
        for(int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph[prerequisiteCourse].add(course);
            indegree[course]++;
        }

        // queue for storing courses with no prerequisites(indegree = 0)
        Deque<Integer> q = new ArrayDeque<>();

        // adding all courses with no prerequisites into queue
        for(int c = 0; c < numCourses; c++) {
            if(indegree[c] == 0) {
                q.offer(c);
            }
        }

        // processing courses with kahn's algo(topological sort)
        while(!q.isEmpty()) {
            int currCourse = q.poll();  // course with no remaning prereq.
            numCourses--;               // decrement count of remain. courses to process

            // for each course that depend on curr course
            for(int dependCourse : graph[currCourse]) {
                indegree[dependCourse]--;       // reducing it's indegree since we completed one indegree
                if(indegree[dependCourse] == 0) {   // if all prerequisites are met, adding to queue
                    q.offer(dependCourse);
                }
            }
        }

        return numCourses == 0; //all courses processed, no cycle exists
    }
}
/**
TC = O(m+n) -> O(n) = queue, O(m) = prequisites iterate
SC = O(n+m) -> graph = O(n+n), indegree arr = O(n), queue = O(n) */