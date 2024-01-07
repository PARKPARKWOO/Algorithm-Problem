import java.util.*;

class Solution {
    private int[][] dp;
    int solution(int[][] land) {
        int answer = 0;
        dp = new int[land.length][land[0].length];
        for (int i = 0; i < land.length; i++) {
            Arrays.fill(dp[i], 0);
        }
        for (int i = 0; i < land[0].length; i++) {
            dp[0][i] = land[0][i];
        }
        for (int i = 1; i < land.length; i++) {
            int before = i - 1;
            for (int j = 0; j < land[0].length; j++) {
                for (int k = 0; k < land[0].length; k++) {
                    if (j != k) {
                        dp[i][j] = Math.max(dp[i][j], dp[before][k] + land[i][j]);
                    }
                }
            }
        }
        answer = Arrays.stream(dp[land.length - 1]).max().getAsInt();
        return answer;
    }
}