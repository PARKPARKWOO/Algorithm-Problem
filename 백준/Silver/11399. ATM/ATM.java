import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        int wait = 0;
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
            wait += sum;
        }
        System.out.println(wait);

    }
}