import java.util.*;

public class Main {
    static int L, C;
    static char[] arr;
    static char[] sel;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        arr = new char[C];
        sel = new char[L];
        for (int i = 0; i < C; i++) {
            String next = sc.next();
            arr[i] = next.charAt(0);
        }
        Arrays.sort(arr);
        recursive(0, 0);
    }

    static void recursive(int idx, int k) {
        if (k == L) {
            boolean error = true;
            int cnt = 0;
            StringBuilder sb = new StringBuilder();
            for (char c : sel) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') error = false;
                else cnt++;
                sb.append(c);
            }
            if (!error && cnt >= 2) System.out.println(sb.toString());
            return;
        }
        for (int i = idx; i < C; i++) {
            sel[k] = arr[i];
            recursive(i + 1, k + 1);
        }
    }
}
