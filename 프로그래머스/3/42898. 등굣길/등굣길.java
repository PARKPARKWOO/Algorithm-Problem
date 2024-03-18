class Solution {
    private int[][] dp;
    public int solution(int m, int n, int[][] puddles) {
        dp = new int[n + 1][m + 1];
        int t = 1000000007;
        for(int i = 0; i < puddles.length; i++) {
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }
        dp[1][1] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (dp[i][j] == -1) continue;
                if (dp[i - 1][j] > 0) {
                    dp[i][j] += dp[i- 1][j] % t;
                }
                if (dp[i][j - 1] > 0) {
                    dp[i][j] += dp[i][j - 1] % t;
                }
            }
        }
        return dp[n][m] % t;
    }
}