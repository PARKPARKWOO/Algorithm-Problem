import java.util.*;

public class Main {
    static class Point{
        int r,c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int N, M,ans;
    static int[][] map, dp;
    static boolean[][] v;
    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        map = new int[M][N];
        dp = new int[M][N];
        v = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        System.out.println(dfs(0, 0));

    }

    static int dfs(int x, int y) {
        if (x == M - 1 && y == N - 1) {
            return 1;
        }
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < M && ny >= 0 && ny < N && map[nx][ny] < map[x][y] && !v[nx][ny]) {
                v[nx][ny] = true;
                temp += dfs(nx, ny);
                v[nx][ny] = false;
            }
        }
        dp[x][y] = temp;
        return temp;
    }
}
