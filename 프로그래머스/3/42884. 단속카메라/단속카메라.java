import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        int temp = Integer.MIN_VALUE;
        for (int[] arr : routes) {
            if (temp < arr[0]) {
                temp = arr[1];
                answer++;
            }
        }
        return answer;
    }
}