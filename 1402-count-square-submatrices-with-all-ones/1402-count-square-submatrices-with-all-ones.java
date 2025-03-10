class Solution {
    private boolean[][][] dp;
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int min = Math.min(m, n);
        int answer = 0;
        dp = new boolean[m][n][min];
        for (int i =0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    answer++;
                    dp[i][j][0] = true;
                    answer += re(matrix, i, j, 2, min);
                }
            }
        }
        return answer;
    }

    private int re(int[][] matrix, int x, int y, int side, int min) {
        if (side > min) return 0;
        if (matrix.length < x + side || matrix[0].length < y + side) return 0;
        int m = 0;
        for (int i = 0; i < min; i++) {
            boolean v = dp[x][y][i];
            if (v) {
                m = i;
            } else {
                break;
            }
        }

    for (int j = y; j < y + side; j++) {
        if (matrix[x + side - 1][j] == 0) return 0;
    }
    // Check the new right column (excluding the already checked bottom-right cell)
    for (int i = x; i < x + side - 1; i++) {
        if (matrix[i][y + side - 1] == 0) return 0;
    }
        dp[x][y][side-1] = true;
        return 1 + re(matrix, x, y, side + 1, min);
    }
}