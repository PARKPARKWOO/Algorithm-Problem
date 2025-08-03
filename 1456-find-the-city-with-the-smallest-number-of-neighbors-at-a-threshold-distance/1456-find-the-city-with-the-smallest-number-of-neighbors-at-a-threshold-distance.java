class Solution {
    private List<List<int[]>> graph;
    private int[] dp;
    private int answer;
    private int minDepth = Integer.MAX_VALUE;
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        graph = new ArrayList<>();
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph.get(from).add(new int[]{to, weight});
            graph.get(to).add(new int[]{from, weight});
        }
        for (int i = 0; i < n; i++) {
            int cnt = dikjestra(i, distanceThreshold);
            if (cnt <= minDepth) {
                answer = i;
                minDepth = cnt;
            }
        }
        return answer;
    }

    private int dikjestra(int start, int distanceThreshold) {
        PriorityQueue<Nodes> q = new PriorityQueue<>();
        int[] dp = new int[graph.size()];
        Arrays.fill(dp, Integer.MAX_VALUE);
        q.add(new Nodes(start, 0, 0));
        dp[start] = 0;
        int depth = 0;
        int cnt = 0;
        while (!q.isEmpty()) {
            Nodes poll = q.poll();
            if (poll.weight > dp[poll.idx]) continue;
            List<int[]> edges = graph.get(poll.idx);
            for (int[] edge: edges) {
                int idx = edge[0];
                int w = edge[1];
                if (poll.weight + w < dp[idx] && distanceThreshold >= poll.weight + w) {
                    q.add(new Nodes(idx, w + poll.weight, poll.depth + 1));
                    dp[idx] =  w + poll.weight;
                }
            }
        }
        for (int d: dp) {
            if (d != Integer.MAX_VALUE) {
                cnt++;
            }
        }
        return cnt - 1;
    }
}

class Nodes implements Comparable<Nodes>{
    int idx;
    int weight;
    int depth;
    public Nodes(int idx, int weight, int depth) {
        this.idx = idx;
        this.weight = weight;
        this.depth = depth;
    }

    public int compareTo(Nodes o) {
        return o.weight - this.weight;
    }
}