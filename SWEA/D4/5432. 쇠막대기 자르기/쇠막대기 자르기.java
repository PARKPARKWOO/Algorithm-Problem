import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            String str = sc.next();
            Stack<Character> stack = new Stack<>();
            int answer = 0;
            int cnt = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                switch (c) {
                    case '(':
                        stack.push(c);
                        cnt++;
                        break;
                    case ')':
                        if (stack.peek() == '(') {
                            answer += --cnt;
                            stack.push(c);
                        }
                        else {
                            stack.push(c);
                            cnt--;
                            answer++;
                        }
                }
            }
            System.out.println("#" + tc + " " + answer);
		}
	}
}