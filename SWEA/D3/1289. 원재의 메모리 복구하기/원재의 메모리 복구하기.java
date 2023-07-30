import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            String s = sc.next();
            int answer = 0;
            if (s.charAt(0) != '0') answer++;
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)){
                    continue;
                } else {
                    answer++;
                }
            }
            System.out.println("#" + tc + " " + answer);
        }
	}
}