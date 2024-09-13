import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            int from = edge[i][0] - 1;
            int to = edge[i][1] - 1;
            list.get(from).add(to);
            list.get(to).add(from);
        }
        q.add(0);
        boolean[] v = new boolean[n];
        int level = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            int tempAnswer = 0;
            for (int i =0; i < qSize; i++) {
                int poll = q.poll();
                v[poll] = true;
                List<Integer> get = list.get(poll);

                for (int j =0; j < get.size(); j++) {
                    int m = get.get(j);
                    if (!v[m]) {
                        v[m] = true;
                        q.add(m);
                    }
                }
            }
            if (q.isEmpty()) {
                answer = qSize;
            }
            level++;
        }
        return answer;
    }
}

class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}