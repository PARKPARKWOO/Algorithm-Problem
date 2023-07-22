import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Integer> collect = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            collect.add(sc.nextInt());
        }
        int answer = 0;
        boolean end = false;
        for (int i = 0; i < N - 2; i++) {
            Integer iNum = collect.get(i);
            for (int j = i + 1; j < N - 1; j++) {
                Integer jNum = collect.get(j);
                for (int k = j + 1; k < N; k++) {
                    Integer kNum = collect.get(k);
                    if (iNum + jNum + kNum == M) {
                        answer = M;
                        end = true;
                        break;
                    }else if ((iNum + jNum + kNum) < M && (iNum + jNum + kNum) > answer) {
                        answer = iNum + jNum + kNum;
                    }
                }
                if (end) break;

            }
            if (end) break;
        }
        System.out.println(answer);
    }
}
