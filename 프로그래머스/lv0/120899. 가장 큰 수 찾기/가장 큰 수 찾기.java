import java.util.*;
class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        int max_num = Arrays.stream(array).max().getAsInt();
        int max_index = 0;
        for (int i = 0; i < array.length; i++) {
            if (max_num == array[i]){
                max_index = i;
            }
        }
        answer[0] = max_num;
        answer[1] = max_index;
        return answer;
    }
}