import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for (int i = 0; i < discount.length - 9; i++) {
            if (check(i, want, number, discount)) answer++;
        }
        return answer;
    }

    private boolean check(int start, String[] want, int[] number, String[] discount){
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i< want.length; i++) {
            map.put(want[i], number[i]);
        }
        for (int i = start; i < start + 10; i++) {
            int value = map.getOrDefault(discount[i], -1);
            if (value != -1) {
                map.put(discount[i], value-1);
            }
        }
        for (int i= 0; i < want.length; i++) {
            int value = map.get(want[i]);
            if (value > 0) return false;
        }
    
        return true;
    }
}