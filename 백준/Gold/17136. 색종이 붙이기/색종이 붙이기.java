import java.util.*;
public class Main {
    private static int answer;
    public static int[][] arr = new int[10][10];
    private static int[] nums = {5, 5, 5, 5, 5};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        dfs(0, 0, 0);
        answer = answer == Integer.MAX_VALUE ? -1 : answer;
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int sum) {
        if (y == 10) {
            x = x + 1;
            y = 0;
        }

        if (x == 10) {
            answer = Math.min(answer, sum);
            return;
        }
        if (arr[x][y] == 0) {
            dfs(x, y + 1, sum);
            return;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            int size = i + 1;
            if (nums[i] > 0 && can(x, y, size)) {
                attach(x, y, size, 0);
                nums[i] = nums[i] - 1;
                dfs(x, y + 1, sum + 1);
                attach(x, y, size, 1);
                nums[i] = nums[i] + 1;
            }
        }
    }

    private static void attach(int x, int y, int size, int n) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                arr[i][j] = n;
            }
        }
    }

    private static boolean can(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (i > 9 || j > 9 || arr[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}