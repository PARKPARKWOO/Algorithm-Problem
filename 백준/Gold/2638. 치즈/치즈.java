import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	static int N, M, ans, meltingCnt;
	static int[][] arr;
	static List<Point> cList;
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0};  // 상 하 좌 우 
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		cList = new ArrayList<>();
		for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) {
			int temp = sc.nextInt();
			arr[i][j] = temp;
			if (temp == 1) {
				cList.add(new Point(i, j));
				meltingCnt++;
			}
		}
		
		
		while (meltingCnt != 0) {
			ans++;
			v = new boolean[N][M];
			bfs(0, 0);
			melting();
		}
		System.out.println(ans);
	}
	
	static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));
		v[x][y] = true;
		arr[x][y] = 2;
		while (!queue.isEmpty()) {
			Point poll = queue.poll();
			int x2 = poll.x;
			int y2 = poll.y;
			for (int i = 0; i < 4; i++) {
				int nx = x2 + dx[i];
				int ny = y2 + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && !v[nx][ny] && arr[nx][ny] != 1 ) {
					queue.add(new Point(nx, ny));
					arr[nx][ny] = 2; 
					v[nx][ny] = true;
				}
			}
		}
	}
	
	static void melting() {
		for (int i = 0; i < cList.size(); i++) {
			int x = cList.get(i).x;
			int y = cList.get(i).y;
			int cnt = 0;
			for (int j = 0; j < 4; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 2) {
					cnt++;
				}
			}	
			if (cnt >= 2) {
				arr[x][y] = 0;
				meltingCnt--;
				cList.remove(i);
				i--;
			}
		}
		
	}
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
