import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, ans;
	static int[][] arr;
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][2];
		dp = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt(); // 상담 완료 하는데 걸리는 기간 
			arr[i][1] = sc.nextInt(); // 받을 수 있는 금액 
		}
		if (arr[0][0] < N + 1) {
			dp[0] = arr[0][1];
		}
		for (int i = 1; i < N; i++) {
			int temp = 0;
			if (i + arr[i][0] < N + 1) {
				temp = arr[i][1];
				dp[i] = temp; // 현재 받을 수 있는 금액 	
			}else continue;
		
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j][0] + j <= i) {
					dp[i] = Math.max(dp[i], temp + dp[j]);
				}
			}
		}
		ans = Arrays.stream(dp).max().orElse(0);
//		for (int d : dp) {
//			ans = Math.max(ans, d);
//		}
		System.out.println(ans);
	}
}
