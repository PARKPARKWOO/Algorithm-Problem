import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int size = new HashSet<>(Arrays.asList(gems)).size();
        Map<String, Integer> map = new HashMap<>();
        int start = 0;
        int length = Integer.MAX_VALUE;
        int[] answer = new int[2];
        for (int i =0; i < gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            while (map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }
            if (size == map.size() && length > (i - start)) {
                length = i - start;
                answer[0] = start + 1;
                answer[1] = i + 1;
            }
        }
        return answer;
    }
}