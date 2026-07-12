class Solution {
    int[] state;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        state = new int[numCourses];
        boolean answer = true;
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            int[] p = prerequisites[i];
            graph[p[1]].add(p[0]);
            state[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < state.length; i++) {
            if (state[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int poll = q.poll();
            List<Integer> list = graph[poll];
            
            for (int i = 0; i < list.size(); i++) {
                int idx = list.get(i);
                state[idx]--;
                if (state[idx] == 0) q.add(idx);
            }
        }

        for (int i : state) {
            if (i != 0 ) return false;
        }
        return answer;
    }
}