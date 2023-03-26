class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int num;
        while (true) {
            if (n < a) {
                break;
            }
            if (n % a == 0) {
                answer += (n/a) * b;
                n = (n/a) * b;
            }else if (n % a != 0){
                num = n % a;
                answer += (n/a) * b;
                n = (n/a) * b;
                n += num;
            }
        }

        return answer;
    }
}