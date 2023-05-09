class Solution {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int temp = i;
            if (temp == n) {
                answer++;
                continue;
            }
            for (int j = i + 1; j <= n; j++) {
                temp += j;
                if (temp > n) {
                    break;
                } else if (temp < n) {
                    continue;
                } else {
                    answer++;
                }
            }
        }
        return answer;
    }
}