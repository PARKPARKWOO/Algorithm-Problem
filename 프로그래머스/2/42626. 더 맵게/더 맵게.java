import java.util.*;
class Solution {
    private int cnt;
    private List<Integer> list;
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int answer = 0;
        for (int s: scoville) {
            queue.add(s);
        }
        while (queue.peek() < K) {
            if (queue.size() == 1) {
                answer = -1;
                break;
            }
            queue.add(queue.poll() + (queue.poll() * 2));
            answer++;
        }
        return answer;
    }
}