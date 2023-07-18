import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			            int N = sc.nextInt();
            int[][] array = new int[N][N];
            for (int i = 0; i < N; i++) {
                String s = sc.next();
                for (int j = 0; j < s.length(); j++) {
                    array[i][j] = s.charAt(j) - '0';
                }
            }
            if (N == 1) {
                System.out.println("#" + test_case + " " + array[0][0]);
                continue;
            }

            int result = 0;
            int range = (N - 3) / 2 + 1;
            int mid = (N - 1) / 2;
            int sum = 0;
            sum += leftUp(array, range);
            sum += leftDown(array, mid);
            sum += rightDown(array, mid);
            sum += rightUp(array, mid, range);
            int leftUp = leftUp(array, range);
            int leftDown = leftDown(array, mid);
            int rightDown = rightDown(array, mid);
            int rightUp = rightUp(array, mid, range);
            for (int[] ints : array) {
                for (int anInt : ints) {
                    result += anInt;
                }
            }

            result -= sum;
            System.out.println("#" + test_case + " " + result);
		}
	}
        static int leftUp(int[][] array, int range) {
        int sum = 0;
        for (int i = 0; i < range; i++) {
            for (int j = 0; j < range - i; j++) {
                sum += array[i][j];
            }
        }

        return sum;
    }

    /**
     * @param start = mid + 1
     */
    static int leftDown(int[][] array, int mid) {
        int sum = 0;
        int start = mid + 1;
        int end = mid * 2;
        for (int i = start; i < end + 1; i++) {
            for (int j = 0; j < (i - start) + 1; j++) {
                sum += array[i][j];
            }
        }

        return sum;
    }

    static int rightDown(int[][] array, int mid) {
        int sum = 0;
        int start = mid + 1;
        int end = mid * 2;
        for (int i = start; i < end + 1; i++) {
            for (int j = mid + (end - i + 1); j < end + 1; j++) {
                sum += array[i][j];
            }
        }

        return sum;
    }

    static int rightUp(int[][] array, int mid, int range) {
        int sum = 0;
        int start = mid + 1;
        int end = mid * 2;
        for (int i = 0; i < range; i++) {
            for (int j = start + i; j < end + 1; j++) {
                sum += array[i][j];
            }
        }

        return sum;
    }
}