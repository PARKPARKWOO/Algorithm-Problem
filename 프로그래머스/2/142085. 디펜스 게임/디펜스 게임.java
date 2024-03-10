import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        int my = n;
        int card = k;
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < enemy.length; i++) {
            q.add(enemy[i]);
            my -= enemy[i];
            
            if (my < 0) {
                if (card > 0 && !q.isEmpty()) {
                    my += q.poll();
                    card--;
                } else {
                    answer = i;
                    break;
                }
            }
        }
        return answer;
    }
}