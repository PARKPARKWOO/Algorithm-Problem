import java.io.IOException;
import java.util.*;

public class Main {
    static int N, M; // n = 스위치 개수 m = 학생수
    static int[] arr;
    static int[][] student;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i]= sc.nextInt();
        }
        M = sc.nextInt();
        student = new int[M][2];
        for (int i = 0; i < M; i++) {
            student[i][0] = sc.nextInt();
            student[i][1] = sc.nextInt();
        }
        switchOnOff();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + " ");
            if (i != 0 && (i + 1 )% 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb.toString().trim());
    }

    // 1 은 스위치 On  0 은 스위치 off
    static void switchOnOff() {
        for (int[] ints : student) {
            int gender = ints[0];
            int idx = ints[1];
            switch (gender) {
                case 1:
                    man(idx);
                    break;
                case 2:
                    girl(idx);
                    break;
            }
        }
    }

    static void man(int idx) {
        for (int i = idx - 1; i < arr.length; i+=idx) {
            arr[i] = arr[i] == 0 ? 1 : 0;
        }
    }

    static void girl(int idx) {
        int left = idx - 2;
        int right = idx;

        arr[idx - 1] = arr[idx - 1] == 0 ? 1 : 0;

        while (left >= 0 && right < arr.length && arr[left] == arr[right]) {
            arr[left] = arr[left] == 0 ? 1 : 0;
            arr[right] = arr[right] == 0 ? 1 : 0;
            left--;
            right++;
        }

    }
}
