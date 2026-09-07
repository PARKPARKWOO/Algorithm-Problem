class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    int[] indegree;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        indegree = new int[numCourses];
        
        for (int[] pre : prerequisites) {
            int require = pre[1];
            int course = pre[0];
            graph.get(course).add(require);
            indegree[require]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.add(i);
        }        
        
        while (!q.isEmpty()) {
            int poll = q.poll();
            List<Integer> list = graph.get(poll);
            for (int i: list) {
                indegree[i]--;
                if (indegree[i] == 0) q.add(i);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] != 0) return false;
        }
        return true;
    }
}