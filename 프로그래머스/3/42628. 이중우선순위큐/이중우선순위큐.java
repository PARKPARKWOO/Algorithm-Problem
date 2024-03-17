import java.util.*;
class Solution {
    private PriorityQueue<Integer> maxQ;
    private PriorityQueue<Integer> minQ;
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        maxQ = new PriorityQueue<Integer>(Collections.reverseOrder());
        minQ = new PriorityQueue<Integer>();
        for (String str: operations) {
            if (str.startsWith("I")) {
                insert(str);
            } else {
                if (!minQ.isEmpty()) {
                    delete(str);
                }
            }
        }
        if (!minQ.isEmpty()) {
            answer[0] = maxQ.poll();
            answer[1] = minQ.poll();
        }
    
        return answer;
    }
    private void insert(String str) {
        int value = Integer.parseInt(str.substring(2));
        minQ.add(value);
        maxQ.add(value);
    }

    private void delete(String str) {
        // 최소 값 삭제
        if (str.endsWith("-1")) {
            int value = minQ.poll();
            maxQ.remove(value);
        } else {
            // 최대 값 삭제
            int value = maxQ.poll();
            minQ.remove(value);
        }
    }
}