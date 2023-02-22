class Solution {
    public int solution(int n) {
        int answer = 0;
        while (n > 7){
            n -= 7;
            answer += 1;
        }
        return answer + 1;
    }
}