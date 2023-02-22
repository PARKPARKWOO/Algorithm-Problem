class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        double a = Double.valueOf(num1) / Double.valueOf(num2) * 1000;
        answer = (int) a;
        return answer;
    }
}