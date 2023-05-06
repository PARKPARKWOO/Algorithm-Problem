import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int count = 0;
        long total = 0;
        long q1_sum = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            q1_sum += queue1[i];
            total += queue1[i] + queue2[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        if (total % 2 != 0) return -1;
        long target = (total / 2);

        while (true) {
            if (target == q1_sum) return count;
            if (count > (q1.size() + q2.size())*2 ) return -1;
            if (q1_sum > target) {
                q1_sum -= q1.peek();
                q2.offer(q1.poll());
                count++;
            } else {
                q1_sum += q2.peek();
                q1.offer(q2.poll());
                count++;
            }
        }
    }

}

