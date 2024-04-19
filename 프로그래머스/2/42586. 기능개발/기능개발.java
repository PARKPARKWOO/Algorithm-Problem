import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q= new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            q.add((int) Math.ceil((double) (100 - progresses[i]) / speeds[i]));
        }
        while (!q.isEmpty()) {
            int cnt = 1;
            int now = q.poll();
            while (!q.isEmpty() && now >= q.peek()) {
                cnt++;
                q.poll();
            }
            list.add(cnt);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}