class Solution {
    List<List<int[]>> graph = new ArrayList<>();
    int[] dp;
    int minCnt = Integer.MAX_VALUE;
    int answer;
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int[] edge: edges) {
            int f = edge[0];
            int t = edge[1];
            int w = edge[2];
            graph.get(f).add(new int[]{t, w});
            graph.get(t).add(new int[]{f, w});
        }
        for (int i = 0; i < n; i++) {
            ds(i, distanceThreshold);
        }
        return answer;
    }

    private void ds(int start, int dt) {
        PriorityQueue<int[]> q = new PriorityQueue<>(
            Comparator.comparingInt(arr -> arr[1])
        );
        // node depth cnt
        q.add(new int[]{start, 0, 0});
        Map<Integer, Integer> map = new HashMap<>();
        map.put(start, 0);
        int mc = 0;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int depth = map.getOrDefault(poll[0], Integer.MAX_VALUE);
            if (depth < poll[1] || poll[1] > dt) continue;
            map.put(poll[0], poll[1]);
            List<int[]> list = graph.get(poll[0]);
            
            for (int[] l : list) {
                int sDis = l[1] + poll[1];
                if (dt < sDis) continue;
                q.add(new int[]{l[0], sDis, poll[2] + 1});
            }
        }
        mc = map.size() - 1;
        if (mc < minCnt) {
            answer = start;
            minCnt = mc;
        } else if (mc == minCnt && answer < start) {
            answer = start;
        }
    }
}