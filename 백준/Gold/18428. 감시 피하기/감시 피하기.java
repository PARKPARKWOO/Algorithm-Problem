import java.util.Scanner;

public class Main {
    static int N, as;
    static String[][] arr;
    static boolean check;
    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};
    static String ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new String[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.next();
            }
        }
        dfs(0, -1, 0);
        if (as == 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void dfs(int x, int y, int cnt) {
        if (cnt == 3) {
            boolean yes = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!arr[i][j].equals("T")) continue;
                    boolean a = find(i, j);
                    if (a) {
                        yes = false;
                        break;
                    }
                }
            }
            if (yes) {
                as = 1;
            }
            return;
        }
        for (int i = y + 1; i < N; i++) {
            if (!arr[x][i].equals("X")) continue;
            arr[x][i] = "O";
            dfs(x, i, cnt + 1);
            arr[x][i] = "X";
        }
        for (int i = x + 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!arr[i][j].equals("X")) continue;
                arr[i][j] = "O";
                dfs(i, j, cnt + 1);
                arr[i][j] = "X";
            }
        }
    }

    private static boolean find(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            while (true) {
                if (nx < 0 || nx >= N || ny < 0 || ny >= N){ break;}
                if (arr[nx][ny].equals("O")) break;
                if (arr[nx][ny].equals("S")) return true;
                nx += dx[i];
                ny += dy[i];
            }
        }
        return false;
    }
}