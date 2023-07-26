import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int[][] s = new int[9][9];
            // 입력
            for (int i = 0; i < s.length; i++) {
                for (int j = 0; j < s[i].length; j++) {
                    s[i][j] = sc.nextInt();
                }
            }
            boolean error = false;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (i % 3 == 0 && j % 3 == 0) {
                        if (!squareCheck(s, i, j)) {
                            error = true;
                            break;
                        }
                    }
                    if (!rowCheck(s, i, j) || !colCheck(s, i, j)) {
                        error = true;
                        break;
                    }
                }
                if (error) break;
            }

            if (error) System.out.println("#" + test_case + " 0");
            else System.out.println("#" + test_case + " 1");
        }
    }
    static boolean rowCheck(int[][] arr, int row, int col){
        int sum =0;
        for (int i = 0; i < 9; i++) {
            sum += arr[i][col];
        }
        return sum == 45;
    }

    static boolean colCheck(int[][] arr, int row, int col) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += arr[row][i];
        }
        return sum == 45;
    }

    static boolean squareCheck(int[][] arr, int startRow, int startCol) {
        int sum = 0;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                sum += arr[i][j];
            }
        }
        return sum == 45;
    }
}