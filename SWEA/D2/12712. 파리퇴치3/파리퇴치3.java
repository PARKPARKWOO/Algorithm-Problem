import java.io.IOException;
import java.util.*;

public class Solution {
    static int N, M, Ans; // n = 스위치 개수 m = 학생수
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();
            arr = new int[N][N];
            Ans = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    fly(i, j);
                }
            }
            System.out.println("#" + tc + " " + Ans);

        }
    }


    static void fly(int x, int y) {
        int[] dx = {-1, 1, 0, 0}; // 상하좌우 좌상 좌하 우상 우하
        int[] dy = {0, 0, -1, 1};
        int[] xdx = { -1, 1, -1, 1};
        int[] xdy = {-1, -1, 1, 1};

        int sumX = 0;
        int sumP = 0;
        for (int i = 0; i < 4; i++) {
            int ddx = x;
            int ddy = y;
            int dddx = x;
            int dddy = y;
            for (int j = 0; j < M - 1; j++) {
                ddx += dx[i];
                ddy += dy[i];
                if (ddx < 0 || ddy < 0 || ddx >= N || ddy >= N) break;
                sumP += arr[ddx][ddy];
            }
            for (int j = 0; j < M - 1; j++) {
                dddx += xdx[i];
                dddy += xdy[i];
                if (dddx < 0 || dddy < 0 || dddx >= N || dddy >= N) break;
                sumX += arr[dddx][dddy];
            }
        }
        if (sumX > sumP) Ans = Math.max(sumX + arr[x][y], Ans);
        else Ans = Math.max(sumP + arr[x][y], Ans);
    }
}
