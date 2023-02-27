class Solution {
    public int solution(int n) {
        int answer = 0;
        int sq = (int) Math.sqrt(n);
        if (sq * sq == n){
            answer = 1;
        } else {answer = 2;}
        return answer;
    }
}