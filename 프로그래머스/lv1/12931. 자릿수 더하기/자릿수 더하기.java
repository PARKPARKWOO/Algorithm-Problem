import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        String num = n + "";
        for (int i = 0; i < num.length(); i++) {
            answer += Integer.parseInt(num.charAt(i) +"");
        }
        return answer;
    }
}