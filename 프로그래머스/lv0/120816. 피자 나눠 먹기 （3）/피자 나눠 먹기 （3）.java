class Solution {
    public int solution(int slice, int n) {
        int answer = 0;
        int num = 0;
        if (n % slice != 0){
            num++;
        }

        answer = (n / slice == 0) ? 1 : (int) Math.floor( n / slice) + num;
        return answer;
    }
}