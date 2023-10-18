
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	static class Point{
		int idx;
		int cnt;
		public Point(int idx, int cnt) {
			super();
			this.idx = idx;
			this.cnt = cnt;
		}
	}
    static int N, M, ans;
    static boolean[] v;
    static int[] arr, count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[100];
        v = new boolean[100];
        N = sc.nextInt();
        M = sc.nextInt();
        count = new int[100];
        ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x - 1] =  y - 1;
		}
        for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x - 1] =  y - 1;
		}
        bfs();
//        System.out.println(ans);
    }
    private static void bfs() {
    	Queue<Integer> q = new LinkedList<>();
    	q.add(0);
    	v[0] = true;
    	while (!q.isEmpty()) {
    		Integer idx = q.poll();
    		if (idx == 99){
    			System.out.println(count[idx]);
    			return;
    		}
    		for (int i = 1; i <= 6; i++) {
    			int num = idx + i;
    			if (num >= 100) continue;
    			if (v[num]) continue;
				v[num] = true;
				if (arr[num] != 0) {
					if (!v[arr[num]]) {
						q.add(arr[num]);
						count[arr[num]] = count[idx] + 1;
						v[arr[num]] = true;
					}
				}else {
					q.add(num);
					count[num] = count[idx] + 1;
				}
			}
    	}
    }
}