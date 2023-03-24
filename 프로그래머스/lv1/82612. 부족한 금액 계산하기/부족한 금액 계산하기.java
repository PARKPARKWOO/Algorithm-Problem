class Solution {
    public long solution(int price, int money, int count) {
        long answer;
        long temp = 0;
        for (int i = 1; i <= count; i++) {
            temp += price * i;
        }
        if (temp > money){
            answer = temp - money;
        } else {answer = 0;}
        return answer;
    }
}