class Solution {
    private String[] constants = {"a", "e", "i", "o", "u"};
    private int[] dp;
    public int countVowelStrings(int n) {
        dp = new int[5];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            dp[0] = dp[0] + dp[1] + dp[2] + dp[3] + dp[4];
            dp[1] = dp[1] + dp[2] + dp[3] + dp[4];
            dp[2] = dp[2] + dp[3] + dp[4];
            dp[3] = dp[3] + dp[4];
        }
        int answer = 0;
        for (int d: dp) {
            answer += d;
        }
        return answer;
    }

}