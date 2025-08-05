class Solution {
    private List<List<Integer>> graph;
    private boolean[] v;
    private long answer;
    public long minimumFuelCost(int[][] roads, int seats) {
        graph = new ArrayList<>();
        v = new boolean[roads.length + 1];
        for (int i = 0; i < roads.length + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road: roads) {
            int a = road[0];
            int b = road[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        v[0] = true;
        dfs(0, seats);
        return answer;
    }

    private int dfs(int idx, int seats) {
        List<Integer> list = graph.get(idx);
        int people = 1;
        for (int i : list) {
            if (!v[i]) {
                v[i] = true;
                people += dfs(i, seats);
                v[i] = false;
            }
        }
        if (idx != 0 ) {
            answer += (people + seats - 1) / seats;
        }
        return people;
    }
}