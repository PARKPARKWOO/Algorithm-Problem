import java.util.*;

public class Main {
    static int R,C,N;
    static char[][] input, all;
    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        N = sc.nextInt();
        input = new char[R][C];
        all = new char[R][C];
        char[][] arr1 = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = sc.next();
            input[i] = str.toCharArray();
        }
        set(all);
        set(arr1);
        char[][] boom1 = boom(input);
        char[][] boom2 = boom(boom1);
        int time = N - 1;
        if (time == 0) print(input);
        else if (time % 2 == 1) print(all);
        else if (time % 4 == 0) print(boom2);
        else print(boom1);
    }

    static char[][] boom(char[][] arr) {
        char[][] response = new char[R][C];
        set(response);
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == 'O') {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                            response[nx][ny] = '.';
                        }
                    }
                    response[i][j] = '.';
                }
            }
        }
        return response;
    }

    static void set(char[][] arr) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                arr[i][j] = 'O';
            }
        }
    }

    static void print(char[][] arr) {
        for (int i = 0; i < R; i++) {
            System.out.println(Arrays.toString(arr[i]).replaceAll(", ", "").replaceAll("[\\[\\]]", ""));        }
    }


}