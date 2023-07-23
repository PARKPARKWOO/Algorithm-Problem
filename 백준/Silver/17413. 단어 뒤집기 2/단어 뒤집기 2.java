import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack stack = new Stack();
        boolean stop = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                stop = true;
                stack(stack);
                System.out.print('<');
            } else if (s.charAt(i) == '>') {
                stack(stack);
                System.out.print(">");
                stop = false;
            } else {
                if (s.charAt(i) == ' ') {
                    stack(stack);
                    System.out.print(" ");
                } else {
                    if (stop) {
                        System.out.print(s.charAt(i));
                    } else {
                        stack.push(s.charAt(i));
                    }
                }
            }
        }
        stack(stack);

    }

    static void stack(Stack stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}