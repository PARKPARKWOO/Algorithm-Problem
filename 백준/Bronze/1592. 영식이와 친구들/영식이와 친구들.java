import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();
        int answer = 0;
        int idx = 0;
        int temp;
        int[] arr = new int[N];
        while (true) {
            arr[idx]++;
            if (arr[idx] == M) break;
            else if (arr[idx] % 2 != 0) { // 홀수라면
                temp = idx + L;
                if (temp >= N) {
                    idx = (temp - (N-1))-1;
                } else {
                    idx += L;
                }
            } else {
                temp = idx - L;
                if (temp < 0) {
                    idx = (N + temp);
                } else {
                    idx -= L;
                }
            }
            answer++;
        }
        System.out.println(answer);
    }
}