class Solution {
    private double[] probability;
    private List<List<double[]>> graph = new ArrayList<>();
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        probability = new double[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double w = succProb[i];
            graph.get(from).add(new double[]{to, w});
            graph.get(to).add(new double[]{from, w});
        }
        
        PriorityQueue<double[]> q = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        q.add(new double[]{start_node, 1});
        while (!q.isEmpty()) {
            double[] poll = q.poll();
            int pollNode = (int) poll[0];
            
            List<double[]> list = graph.get(pollNode);
            for (double[] l : list ) {
                int node = (int) l[0];
                double w = poll[1] * l[1];
                if (probability[node] >= w) {
                    continue;
                }

                probability[node] = w;
                q.add(new double[]{node, w});
            }
        }
        
        return probability[end_node];
    }
}