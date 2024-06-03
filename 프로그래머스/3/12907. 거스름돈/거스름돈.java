import java.util.Arrays;

class Solution {
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 1; // 0원을 만드는 방법은 하나 (아무 것도 선택하지 않는 것)

        for (int coin : money) {
            for (int i = coin; i <= n; i++) {
                dp[i] += dp[i - coin];
                dp[i] %= 1000000007; // 결과를 1000000007로 나눈 나머지를 저장
            }
        }

        return dp[n];
    }
}
