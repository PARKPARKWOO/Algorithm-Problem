import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isFirst = true;
        while (true) {
            int k = sc.nextInt();
            int[] s = new int[k];
            if (k == 0) break;
            for (int i = 0; i < k; i++) {
                s[i] = sc.nextInt();
            }
            if (!isFirst) {
                System.out.println();
            }
            isFirst = false;
            solve(s, new int[6], 0, 0);
        }
    }

    private static void solve(int[] s, int[] result, int sourceIdx, int targetIdx) {
        if (targetIdx == result.length) {
            for (int i = 0; i < 6; i++) {
                System.out.print(result[i]);
                if (i < 5) System.out.print(' ');
            }
            System.out.println();
            return;
        }
        for (int i = sourceIdx; i < s.length; i++) {
            result[targetIdx] = s[i];
            solve(s, result, i + 1, targetIdx + 1);
        }
    }
}
