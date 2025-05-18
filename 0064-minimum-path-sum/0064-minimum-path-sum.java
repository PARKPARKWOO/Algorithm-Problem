import java.util.*;
class Solution {
    private int[] dx = {0, 1}; // 하 우
    private int[] dy = {1, 0};
    private int[][] dp;
    private int ans = Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = grid[0][0];
        recursion(grid, 0, 0, grid[0][0]);
        return ans;
    }

    private void recursion(int[][] grid, int x, int y, int sum) {
        if (x == grid.length - 1&& y == grid[0].length - 1) {
            ans = Math.min(ans, sum);
            return;
        }
        for (int i =0; i < 2; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && dp[nx][ny] > grid[nx][ny] + sum) {
                dp[nx][ny] = sum + grid[nx][ny];
                recursion(grid, nx, ny, sum + grid[nx][ny]);
            }
        }
    }
}