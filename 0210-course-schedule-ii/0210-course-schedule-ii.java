class Solution {
    int[] answer;
    List<Integer>[] graph;
    int[] state;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        answer = new int[numCourses];
        graph = new ArrayList[numCourses];
        state = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int idx = 0;
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] p: prerequisites) {
            int course = p[0];
            int pre = p[1];
            graph[pre].add(course);
            state[course]++;
        }

        for (int i = 0; i < state.length; i++) {
            if (state[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int poll =q.poll();
            answer[idx++] = poll;
            List<Integer> list = graph[poll];
            
            for (int i = 0; i < list.size(); i++) {
                int value = list.get(i);
                state[value]--;
                if (state[value] == 0) q.add(value);
            }
        }

        for (int i : state) {
            if (i != 0) return new int[0];
        }

        return answer; 
    }
}