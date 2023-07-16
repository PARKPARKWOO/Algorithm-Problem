import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = setList(n, sc);
            int[] b = setList(m, sc);

            int[] longer = a; int[] shorter = b;
            if (n < m) {
                longer = b;
                shorter = a;
            }
            int answer = Integer.MIN_VALUE;
            for (int i = 0; i < longer.length - shorter.length + 1; i++) {
                int temp = 0;
                for (int j = 0; j < shorter.length; j++) {
                    temp += longer[i + j] * shorter[j];
                }
                if (answer < temp) {
                    answer = temp;
                }
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }

    static int[] setList(int a, Scanner sc) {
        int[] arr = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}