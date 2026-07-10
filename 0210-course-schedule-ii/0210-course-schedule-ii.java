class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] answer = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] state = new int[numCourses];
        boolean[] v = new boolean[numCourses];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            int[] p = prerequisites[i];
            int course = p[0];
            int pre = p[1];
            
            graph[pre].add(course);
            state[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && !v[i]) {
                q.add(i);
                v[i] = true;
            }
        }
        int depth = 0;
        while (!q.isEmpty()) {
            int poll = q.poll();
            answer[depth++] = poll;
            List<Integer> list = graph[poll];

            for (int n : list) {
                state[n]--;
                if (state[n] == 0) {
                    q.add(n);
                    v[n] = true;
                }
            }
        }
        if (depth != numCourses) return new int[0];
        return answer;
    }
}