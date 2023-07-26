import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int maxValue = sc.nextInt();
            int[] dump = new int[100];
            // 덤프 값 입력
            for (int i = 0; i < dump.length; i++) {
                dump[i] = sc.nextInt();
            }
            int idx = 0;
            while (idx < maxValue) {
                int maxInt = Arrays.stream(dump).max().getAsInt();
                int minInt = Arrays.stream(dump).min().getAsInt();
                if (maxInt == minInt) break;
                boolean minCheck = false;
                boolean maxCheck = false;
                for (int i = 0; i < dump.length; i++) {
                    int temp = 0;

                    if (dump[i] == maxInt && !maxCheck) {
                        dump[i]--;
                        temp++;
                        maxCheck = true;
                    }
                    if (dump[i] == minInt && !minCheck) {
                        dump[i]++;
                        minCheck = true;
                        temp++;
                    }
                    if (temp == 2) break;
                }
                idx++;
            }
            System.out.println("#" + test_case + " " + (Arrays.stream(dump).max().getAsInt() - Arrays.stream(dump).min().getAsInt()));
        }
	}
}