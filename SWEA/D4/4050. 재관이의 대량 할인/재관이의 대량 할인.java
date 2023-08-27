import java.util.*;

public class Solution {
    static int N, cnt;
    static long ans, sum;
    static Integer[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            arr = new Integer[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            cnt = N / 3;
            int idx = 2;
            Arrays.sort(arr, Collections.reverseOrder());
            long mi = 0;
            for (int i = 0; i < cnt; i++) {
                mi += arr[idx];
                idx += 3;
            }
            sum = Arrays.stream(arr).mapToInt(Integer::intValue).sum();
            ans = sum - mi;
            System.out.println("#" + tc + " " + ans);
        }
    }
}
