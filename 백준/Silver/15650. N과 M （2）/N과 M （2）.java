import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int[] sel;
    static int M,N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sel = new int[M];
        recursive (1,0);
    }

    static void recursive(int idx, int k) {
        if (k == M) {
            System.out.println(Arrays.toString(sel).replace("[","").replace("]","").replace(",",""));
            return;
        }
        for (int i = idx; i <= N; i++) {
            sel[k] = i;
            recursive(i + 1, k + 1);
        }

    }
}
