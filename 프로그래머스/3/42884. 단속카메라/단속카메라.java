import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        int answer = 0;
        int camera = Integer.MIN_VALUE; // 현재 설치된 카메라의 위치를 나타내는 변수

        for (int[] route : routes) {
            // 현재 차량의 진입 지점이 마지막 카메라 위치보다 뒤에 있으면 새로운 카메라 설치 필요
            if (camera < route[0]) {
                answer++;
                camera = route[1]; // 새로운 카메라를 차량의 진출 지점에 설치
            }
        }

        return answer;
    }
}