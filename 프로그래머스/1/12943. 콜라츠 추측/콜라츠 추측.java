class Solution {
    public int solution(int num) {
        int answer = 0;
        int cnt = 0;
        long temp = num;
        while (true) {
            if (temp == 1) {
                answer = cnt;
                break;
            }
            cnt++;
            if (temp % 2 == 0) {
                temp /= 2;
            }
            else {
                temp = (temp * 3) + 1;
            }
            if (cnt == 500) {
                answer = -1;
                break;
            }
        }
        System.out.println(answer);
        return answer;
    }
}