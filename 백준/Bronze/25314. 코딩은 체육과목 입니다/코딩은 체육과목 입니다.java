import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        List<String> lst = new ArrayList<>();
        int a = scan.nextInt();
        scan.close();
        int b = a / 4;
        for (int i = 0; i < b; i++) {
            sb.append("long ");
        }
        System.out.println(sb + "int");
    }
}