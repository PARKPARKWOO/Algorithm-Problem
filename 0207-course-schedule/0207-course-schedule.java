import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] p : prerequisites) {
            int course = p[0];
            int pre = p[1];

            graph[course].add(pre);
        }

        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, state)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int cur, List<Integer>[] graph, int[] state) {
        if (state[cur] == 1) {
            return false;
        }

        if (state[cur] == 2) {
            return true;
        }

        state[cur] = 1;

        for (int next : graph[cur]) {
            if (!dfs(next, graph, state)) {
                return false;
            }
        }

        state[cur] = 2;

        return true;
    }
}