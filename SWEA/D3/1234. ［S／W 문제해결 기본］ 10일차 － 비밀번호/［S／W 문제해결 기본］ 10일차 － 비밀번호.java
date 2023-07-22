import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
//		T=sc.nextInt();
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int N = sc.nextInt();
//			String string = sc.next();
			StringBuffer sb = new StringBuffer();
			sb.append(sc.next());

			while (true) {
				int delete = 0;
				for (int i = 1; i < sb.length(); i++) {
					if (sb.substring(i-1, i).equals(sb.substring(i, i + 1))) {
						sb.delete(i-1, i + 1);
						delete++;
                        break;
					}
				}
				if (delete == 0) {break;}
				
			}
			System.out.println("#" + test_case + " " + sb.toString());
		}
	}
}