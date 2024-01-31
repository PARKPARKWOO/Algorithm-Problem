import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int minIdx = 0;
        for (int i = people.length - 1; minIdx <= i; i--){
            if (people[i] + people[minIdx] <= limit) {
                minIdx++;
            }
            answer++;
        }
        return answer;
    }
}