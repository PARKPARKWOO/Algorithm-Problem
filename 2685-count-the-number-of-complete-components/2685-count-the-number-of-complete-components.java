class Solution {
    List<List<Integer>> graph = new ArrayList<>();

    public int countCompleteComponents(int n, int[][] edges) {
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] v = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (v[i]) continue;

            Queue<Integer> q = new LinkedList<>();
            List<Integer> comp = new ArrayList<>();

            v[i] = true;
            q.add(i);

            while (!q.isEmpty()) {
                int cur = q.poll();
                comp.add(cur);
                for (int nx : graph.get(cur)) {
                    if (!v[nx]) {
                        v[nx] = true;
                        q.add(nx);
                    }
                }
            }

            int k = comp.size();
            boolean ok = true;
            for (int node : comp) {
                if (graph.get(node).size() != k - 1) {
                    ok = false;
                    break;
                }
            }
            if (ok) answer++;
        }

        return answer;
    }
}
