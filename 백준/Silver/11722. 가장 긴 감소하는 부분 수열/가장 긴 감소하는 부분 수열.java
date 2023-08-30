import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int N;
	static Integer[] dp, arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new Integer[N];
		dp = new Integer[N];
		
		// 감소하는 부분수열 
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt(); 
		}
		Arrays.fill(dp, 1);
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);		
				}
			}
		}
		int ans = 0;
		for (int d : dp) {
			ans = Math.max(ans, d);
		}
		System.out.println(ans);
	}
}