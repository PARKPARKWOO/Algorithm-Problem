import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        map.put(0, 1);
        int flag = truck_weights[0];
        int idx = 1;
        int second = 1;
        while (!queue.isEmpty()) {
            second++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (map.get(poll) < bridge_length) {
                    map.put(poll, map.getOrDefault(poll, 0) + 1);
                    queue.add(poll);
                } else {
                    flag -= truck_weights[poll];
                }
            }
            if (idx < truck_weights.length && weight >= flag + truck_weights[idx]) {
                flag += truck_weights[idx];
                queue.add(idx);
                map.put(idx, map.getOrDefault(idx, 0) + 1);
                idx++;
            }
        }
        
        return answer = second;
    }
}