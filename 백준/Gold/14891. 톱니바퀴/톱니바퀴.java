import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        // n = 0 s = 1 1은 시계 -1 반시계
        Scanner sc = new Scanner(System.in);
        arr = new int[4][8];
        // input
        for (int i = 0; i < 4; i++) {
            String str = sc.next();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        // 회전수
        int cnt = sc.nextInt();
        for (int i = 0; i < cnt; i++) {
            int top = sc.nextInt();
            int direction = sc.nextInt();
            top--;
            generate(direction, top);
        }

        int answer = 0;
        for(int i=0; i<4; i++) {
            if (arr[i][0] == 1) {
                answer += (int) Math.pow(2, i);
            }
        }
        System.out.println(answer);
    }
    private static void generate(int direction, int idx) {
        // 왼쪽
        left(idx - 1, -direction);
        // 오른쪽
        right(idx + 1, -direction);
        // 해당 회전
        onlyTurn(idx, direction);
    }
    public static void left(int idx, int direction) {
        if (idx < 0) return;
        // check
        if (arr[idx][2] == arr[idx + 1][6]) return;
        left(idx - 1, -direction);
        onlyTurn(idx, direction);
    }

    public static void right(int idx, int direction) {
        if (idx > 3) return;

        if (arr[idx][6] == arr[idx - 1][2]) return;

        right(idx + 1, -direction);
        onlyTurn(idx, direction);
    }
    // 회전
    public static void onlyTurn(int num, int direction) {
        if (num < 0 || num > 3) return;
        if(direction==1) {
            int tmp = arr[num][7];
            for(int i=7; i>0; i--) {
                arr[num][i] = arr[num][i-1];
            }
            arr[num][0] = tmp;
        }else {
            int tmp = arr[num][0];
            for(int i=0; i<7; i++) {
                arr[num][i] = arr[num][i+1];
            }
            arr[num][7] = tmp;
        }
    }
}