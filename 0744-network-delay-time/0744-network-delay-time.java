class Solution {

    private int[] memo;
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Nodes>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        memo = new int[n + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[k] = 0;
        for (int[] t : times) {
            int from = t[0];
            int to = t[1];
            int w = t[2];
            graph.get(from).add(new Nodes(to, w));
        }
        PriorityQueue<Nodes> q = new PriorityQueue<>();
        q.add(new Nodes(k, 0));
        while (!q.isEmpty()) {
            Nodes poll = q.poll();
            if (poll.depth > memo[poll.node]) {
                continue;
            }
            List<Nodes> list = graph.get(poll.node);
            for (int i =0; i< list.size(); i++) {
                Nodes get = list.get(i);
                int depth = get.depth + poll.depth;
                if (memo[get.node] > depth) {
                    memo[get.node] = depth;
                    q.add(new Nodes(get.node, depth));
                }
            }
        }
        boolean isPossible = true;
        int answer = 0;
        for (int i = 1; i <=n; i++) {
            if (memo[i] == Integer.MAX_VALUE) {
                isPossible = false;
                break;
            }
            answer = Math.max(answer, memo[i]);
        }
        if (isPossible) {
            return answer;
        }
        return -1;
    }
}

class Nodes implements Comparable<Nodes>{
    int node;
    int depth;
    public Nodes(int node, int depth) {
        this.node = node;
        this.depth = depth;
    }

    public int compareTo(Nodes o) {
        return this.depth - o.depth;
    }
}