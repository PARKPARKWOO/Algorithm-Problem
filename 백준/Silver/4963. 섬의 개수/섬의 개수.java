import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

// 부분집합 응용 바이너리 카운팅
public class Main {
	static int[][] map;
	static int W,H, Ans;
	static int[] dx = {-1, 1, 0, 0, -1, 1, -1 ,1};// 상 하 좌 우 좌상 좌하 우상 우하
	static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
	static boolean[][] vi;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		while (true) {
			W = sc.nextInt(); // 너비 
			H = sc.nextInt(); // 높이
			if (W == 0 && H == 0) break;
			map = new int[H][W];
			vi = new boolean[H][W];
			Ans = 0;
			// input
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j]= sc.nextInt();
				}
			}
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (!vi[i][j] && map[i][j]== 1 ) {
						Ans++;
						dfs(i, j);
					}
				}
			}
			System.out.println(Ans);
			
		}
	}
	
	static void dfs(int x, int y) {
		vi[x][y] = true; 
		
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < H && ny >= 0 && ny < W && !vi[nx][ny] && map[nx][ny]== 1  ) {
				dfs(nx, ny);
			}
		}
		
	}
}
