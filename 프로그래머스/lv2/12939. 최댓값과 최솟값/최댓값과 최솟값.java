import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] list = s.split(" ");
        int max = Integer.parseInt(list[0]);
        int min = Integer.parseInt(list[0]);
        for (String s1 : list) {
            int be = Integer.parseInt(s1);
            min = Math.min(min, be);
            max = Math.max(max, be);
        }
        answer += min;
        answer += " " + max;
        return answer;
    }
}