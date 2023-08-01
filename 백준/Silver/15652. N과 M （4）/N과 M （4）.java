import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int[] sel;
    static int M,N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sel = new int[M];
        recursive (1,0);
        System.out.println(sb.toString().replace("[","").replace("]","").replace(",",""));
    }

    static void recursive(int idx, int k) {
        if (k == M) {
//            System.out.println(Arrays.toString(sel).replace("[","").replace("]","").replace(",",""));
            sb.append(Arrays.toString(sel));
            sb.append("\n");
            return;
        }
        for (int i = idx; i <= N; i++) {
            sel[k] = i;
            recursive(i, k + 1);
        }

    }
}