import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int work: works) {
            q.add(work);
        }
        while (n > 0) {
            int work = q.poll();
            if (work > 0) {
                q.add(work - 1);
            } else {
                q.add(0);
            }
            n--;
        }
        for (int i = 0; i < works.length; i++) {
            answer += (long) Math.pow(q.poll(), 2);
        }
        return answer;
    }
}