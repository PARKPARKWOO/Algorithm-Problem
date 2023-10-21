class Solution {
    int[] dp;
    public int solution(int n) {
        int answer = 0;
        dp = new int[n + 1];
        dp[1] = 1;
        if(n >= 2) dp[2] = 2;
        if (n >= 3) dp[3] = 3;
        for (int i = 4; i <= n; i++){
            dp[i] = (dp[i - 1] + dp[i -2]) % 1000000007;
        }
        // 1 => 1
        // 2 => 2
        // 3 => 3
        // 4 => 5
        // 5 => 8
        // 6 => 13
        
        return dp[n];
    }
}