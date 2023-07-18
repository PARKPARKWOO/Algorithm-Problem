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
		            String answer = "";
            String b = sc.next();
            String a = sc.next();

            String before = b.replaceAll("[ADOPQR]", "1").replaceAll("[CEFGHIJKLMNSTUVWXYZ]", "0");

            String after = a.replaceAll("[ADOPQR]", "1").replaceAll("[CEFGHIJKLMNSTUVWXYZ]", "0");

            if (before.equals(after)) {
                answer = "SAME";
            } else {
                answer = "DIFF";
            }
            System.out.println("#" + test_case + " " + answer);
		}
	}
}