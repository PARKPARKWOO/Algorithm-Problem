import java.util.*;
class Solution {
    private List<List<Integer>> graph;
    private boolean[] v;
    private int answer;
    public int solution(int n, int[][] edge) {
        answer = 0;
        graph = new ArrayList<>();
        v = new boolean[n + 1];
        for (int i = 0; i<n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] node: edge) {
            int from = node[0];
            int to = node[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        bfs();
        return answer;
    }
    private void bfs() {
        Queue<Nodes> q = new LinkedList<>();
        q.add(new Nodes(1, 0));
        v[1] = true;
        int maxDepth = 0;
        while (!q.isEmpty()) {
            Nodes poll = q.poll();
            int depth = poll.depth;
            int num = poll.num;
            if (maxDepth == depth){
                answer++;
            }
            else if (maxDepth < depth){
                answer = 1;
                maxDepth = depth;
            }

            for (int i = 0; i < graph.get(num).size(); i++) {
                int eg = graph.get(num).get(i);
                if (!v[eg]) {
                    v[eg] = true;
                    q.add(new Nodes(eg, depth + 1));
                }
            }

        }
    }
}

class Nodes{
    int depth;
    int num;
    public Nodes(int num, int depth) {
        this.depth = depth;
        this.num = num;
    }
}