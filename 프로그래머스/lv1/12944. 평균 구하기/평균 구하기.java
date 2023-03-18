
class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        for (double num :
                arr) {
            answer += num;
        }
        return answer / arr.length;
    }
}