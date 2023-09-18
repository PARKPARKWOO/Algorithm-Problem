import java.io.IOException;
import java.util.*;

public class Main {
    static int M, N, ans;
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        adj = new ArrayList<>();
        v = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        for (int i = 1; i <= N; i++) {
            if (!v[i]) bfs(i);
        }
        System.out.println(ans);
    }

    static void bfs(int num) {
        ans++;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        v[num] = true;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            int listSize = adj.get(poll).size();
            for (int i = 0; i < listSize; i++) {
                int temp = adj.get(poll).get(i);
                if (!v[temp]) {
                    queue.add(temp);
                    v[temp] = true;
                }
            }
        }
    }

}
