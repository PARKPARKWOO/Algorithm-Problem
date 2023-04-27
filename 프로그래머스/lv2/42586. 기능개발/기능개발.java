import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int temp = 100 - progresses[i];
            int rt = (int) Math.ceil( (double) temp / speeds[i]);
            queue.add(rt);
        }

        int so = 0;
        int before = 0;
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int after = queue.poll();
            System.out.println(after);
            if (before >= after) {
                so++;
            } else {
                before = after;
                if (so != 0) {
                    list.add(so);
                }
                so = 1;
            }
            if (queue.isEmpty()) {
                list.add(so);
                break;
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}