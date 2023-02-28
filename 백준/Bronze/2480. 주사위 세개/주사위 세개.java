import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        sc.close();
        int money;
        int cnt; // 주사위 칸
        if (a == b && b == c){
            cnt = a;
            money = 10000 + (cnt * 1000);
        } else if (a == b && b != c) {
            cnt = a;
            money = 1000 + (cnt * 100);
        } else if (a == c && b != c) {
            cnt = a;
            money = 1000 + (cnt * 100);
        } else if (a != b && b == c) {
            cnt = b;
            money = 1000 + (cnt * 100);
        } else{
            cnt = (a > b) ? ((a > c) ? a : c ) : ((b > c) ? b : c );
            money = cnt * 100;
        }
        System.out.println(money);
    }
}
