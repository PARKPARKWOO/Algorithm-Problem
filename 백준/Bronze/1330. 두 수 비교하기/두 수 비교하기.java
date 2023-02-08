import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner num = new Scanner(System.in);
        int a = num.nextInt();
        int b = num.nextInt();
        num.close();
        if (a>b) System.out.println(">");
        else if (a<b) System.out.println("<");
        else System.out.println("==");




    }
}