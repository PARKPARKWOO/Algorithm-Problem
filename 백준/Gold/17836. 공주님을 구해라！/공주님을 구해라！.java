import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Point{
        int x, y, cnt, gram;

        public Point(int x, int y, int cnt, int gram) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.gram = gram;
        }
    }
    static int N, M, ans, T;
    static int[][] arr;
    static boolean[][][] v;
    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        T = sc.nextInt();
        arr = new int[N][M];
        v = new boolean[N][M][2];
        ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
//        dfs(0, 0, 0, 0);
        bfs();
        if (ans == Integer.MAX_VALUE) {
            System.out.println("Fail");
        } else {
            System.out.println(ans);
        }
    }

    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0, 0));
        while (!q.isEmpty()) {
            Point poll = q.poll();
            int x = poll.x;
            int y = poll.y;
            int cnt = poll.cnt;
            int gram = poll.gram;

            if (x == N - 1 && y == M - 1) {
                ans = Math.min(ans, cnt);

            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                boolean canTime = (((N - 1) - x) + (M - 1) - y) + cnt <= T;
                boolean canMove = nx >= 0 && nx < N && ny >= 0 && ny < M && !v[nx][ny][gram] && canTime;
                if (gram == 0) {
                    if (canMove && arr[nx][ny] == 0) {
                        v[nx][ny][gram] = true;
                        q.add(new Point(nx, ny, cnt + 1, gram));
                    } else if (canMove && arr[nx][ny] == 2) {
                        v[nx][ny][gram] = true;
                        q.add(new Point(nx, ny, cnt + 1, 1));
                    }
                } else {
                    if (canMove && (arr[nx][ny] == 0 || arr[nx][ny] == 1)) {
                        v[nx][ny][gram] = true;
                        q.add(new Point(nx, ny, cnt + 1, gram));
                    }
                }
            }
        }
    }

    private static void dfs(int x, int y, int cnt, int gram) {
        // 그람이 없을때 0 있을때 1
        //범위 초과 시
        if (cnt > T) {
            return;
        } else if (x == N - 1 && y == M - 1) {
            ans = Math.min(ans, cnt);
            return;
        } else if (cnt > ans) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            boolean canTime = (((N - 1) - x) + (M - 1) - y) + cnt < T;
            boolean canMove = nx >= 0 && nx < N && ny >= 0 && ny < M && !v[nx][ny][gram] && canTime;
            // 그램 없을때
            if (gram == 0) {
                if (canMove && arr[nx][ny] == 0) {
                    v[nx][ny][gram] = true;
                    dfs(nx, ny, cnt + 1, gram);
                    v[nx][ny][gram] = false;
                } else if (canMove && arr[nx][ny] == 2) {
                    v[nx][ny][gram] = true;
                    dfs(nx, ny, cnt + 1, 1);
                    v[nx][ny][gram] = false;
                }
            } else {
                if (canMove && (arr[nx][ny] == 0 || arr[nx][ny] == 1)) {
                    v[nx][ny][gram] = true;
                    dfs(nx, ny, cnt + 1, gram);
                    v[nx][ny][gram] = false;
                }
            }
        }
    }
}