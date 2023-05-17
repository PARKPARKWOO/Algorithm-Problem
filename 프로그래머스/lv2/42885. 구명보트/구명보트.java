import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int a = 0;
        int b = people.length - 1;
        int[] temp = Arrays.stream(people).sorted().toArray();

        while (a < b) {
            if (temp[a] + temp[b] <= limit) {
                a++;
                answer++;
            }
            b--;
        }
        return people.length - answer;
    }
}