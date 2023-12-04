import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for (int i: arr) {
            if (i % divisor == 0) {
                list.add(i);

            }
        }
        int cnt = list.size();
        int[] answer;
        if (cnt == 0) {
            answer = new int[]{-1};
        }else {
            answer = new int[cnt];
            Collections.sort(list);
            int idx = 0;
            for (int i:
                 list) {
                answer[idx++] = i;
            }
        }
        return answer;
    }
}