class Solution {
    int answer;
    List<List<Integer>> graph = new ArrayList<>();
    public int countCompleteComponents(int n, int[][] edges) {
        boolean[] v = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i =0; i < n; i++) {
            if (v[i]) continue;
            q.add(i);
            v[i] = true;
            int cnt = graph.size();
            if (cnt == 0) {
                answer++;
                continue;
            }
            boolean isCount = true;
            List<Integer> comp = new ArrayList<>();
            
            while (!q.isEmpty()) {
                int poll = q.poll();
                List<Integer> list = graph.get(poll);
                comp.add(poll);
                for (int j : list) {
                    if (v[j]) continue;
                    v[j] = true;
                    q.add(j);
                }
            }
            int k = comp.size() - 1;
            for (int j: comp) {
                if (graph.get(j).size() != k) {
                    isCount = false;
                    break;
                }
            }
            if (isCount) answer++;
        }
        return answer;
    }
}