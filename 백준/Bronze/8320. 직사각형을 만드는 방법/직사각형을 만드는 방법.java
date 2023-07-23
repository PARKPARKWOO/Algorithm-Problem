import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        int[] dp = new int[n + 1];

        if (n == 1) {
            System.out.println(1);
            return;
        } else if (n == 2) {
            System.out.println(2);
            return;
        }
        for (int i = 3; i <= n; i++) {
            int temp = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    temp++;
                }
            }
            answer += temp / 2;
            int sqrt = (int) Math.sqrt(i);
            if (i == sqrt * sqrt) {
                answer++;
            }
        }
        System.out.println(answer + 2);

    }
}