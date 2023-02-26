class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int num = n / i;
            if (num * i == n){
                answer++;
            }
        }
        return answer;
    }
}