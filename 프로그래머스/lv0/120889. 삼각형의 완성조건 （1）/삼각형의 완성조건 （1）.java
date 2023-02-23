import java.util.*;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        Arrays.sort(sides);
        if (sides[2] - sides[1] - sides[0] >= 0){
            answer = 2;
        } else {answer = 1;}
        return answer;
    }
}