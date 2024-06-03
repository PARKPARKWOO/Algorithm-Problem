import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < speeds.length; i++) {
            int temp = 100 - progresses[i];
            int n = (int) Math.ceil((double) temp / speeds[i]);
            q.add(n);
        }
        int before = 0;
        int cnt = 0;
        while (!q.isEmpty()) {
            int after = q.poll();
            if (before >= after) {
                cnt++;
            } else {
                before = after;
                if (cnt != 0) {
                    list.add(cnt);
                }
                cnt = 1;
            }
            if (q.isEmpty()) {
                list.add(cnt);
                break;
            }
        }
        int[] answer = new int[list.size()];
        int size = list.size();
        for (int i = 0; i < size; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}