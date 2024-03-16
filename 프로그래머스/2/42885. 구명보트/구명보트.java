import java.util.*; 
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int start = 0;
        for (int end = people.length - 1; start <= end; end--) {
            if (limit >= people[start] + people[end]) {
                start++;
            }
            answer++;
        }
        return answer;
    }
}