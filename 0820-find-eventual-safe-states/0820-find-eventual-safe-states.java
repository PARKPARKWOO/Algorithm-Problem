class Solution {
    private Map<Integer, Boolean> terminals;
    private List<Integer> t;
    private boolean[] v;
    private List<Integer> answer;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        terminals = new HashMap<>();
        t = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            int[] g = graph[i];
            if (g.length == 0) {
                terminals.put(i, true);
                t.add(i);
            }
        }
        answer = new ArrayList<>();
        v = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (dfs(i, graph)) {
                answer.add(i);
            }
        }
        return answer;
    }
    private boolean dfs(int node, int[][] graph) {
        if (v[node]) {
            return terminals.getOrDefault(node, false);
        }
        v[node] = true;
        if (terminals.getOrDefault(node, false)) {
            return true;
        }
        
        int[] g = graph[node];
        boolean isSafeNode = false;
        for (int i = 0; i < g.length; i++) {
            int n = g[i];
            if (!dfs(n, graph)) {
                return false;
            }
            
        }
        terminals.put(node, true);
        return true;
    }
}