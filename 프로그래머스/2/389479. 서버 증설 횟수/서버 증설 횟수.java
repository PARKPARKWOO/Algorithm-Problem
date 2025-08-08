class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] memo = new int[24 + k + 1];
        int server = 0;
        for (int i = 0; i < 24; i++) {
            int p = players[i];
            server -= memo[i];
            int n = p / m;
            int gap = n - server;
            if (gap > 0) {
                memo[i + k] = gap;
                server += gap;
                answer += gap;
            }
        }
        return answer;
    }
}