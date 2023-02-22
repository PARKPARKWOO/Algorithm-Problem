class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        int num = n / 10;
        k -= num;
        answer += (n * 12000) + (k * 2000);       
        return answer;
    }
}