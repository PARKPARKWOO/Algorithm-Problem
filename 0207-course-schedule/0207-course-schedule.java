class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre: prerequisites) {
            int pr = pre[1];
            int course = pre[0];
            
            graph.get(pr).add(course);
            indegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int poll = q.poll();
            
            List<Integer> list = graph.get(poll);
            
            for (int i : list) {
                indegree[i]--;
                if (indegree[i] <= 0) q.add(i);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] > 0) return false;
        }
        return true;
    }
}