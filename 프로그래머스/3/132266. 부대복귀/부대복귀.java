import java.util.*;
class Solution {
    private ArrayList<ArrayList<Integer>> list;
    private int[] dis;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        list = new ArrayList<>();
        dis = new int[n];
        // list 생성 없는 곳은 empty
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        // init
        for (int i = 0; i < roads.length; i++) {
            int from = roads[i][0] - 1;
            int to = roads[i][1] - 1;
            list.get(from).add(to);
            list.get(to).add(from);
        }
        Arrays.fill(dis, Integer.MAX_VALUE);
        bfs(destination - 1);
        for (int i = 0; i < sources.length; i++) {
            int sourceIndex = sources[i] - 1; // sources 배열의 값들을 올바르게 인덱싱
            answer[i] = dis[sourceIndex] == Integer.MAX_VALUE ? -1 : dis[sourceIndex];
        }
        return answer;
    }
    private int bfs(int destination) {
        Queue<Integer> q = new LinkedList<>();
        dis[destination] = 0;
        q.add(destination);
        int result = -1;
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (int i = 0; i < list.get(poll).size(); i++) {
                int t = list.get(poll).get(i);
                if (dis[poll] + 1 < dis[t]) {
                    dis[t] = dis[poll] + 1;
                    q.add(t);
                }
            }
        }
        return result;
    }
}
