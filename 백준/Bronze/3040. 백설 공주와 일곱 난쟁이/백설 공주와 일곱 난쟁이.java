import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }
        int[] result = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = 0;
                for (int k = 0; k < arr.length; k++) {
                    if (i == k || j == k) continue;
                    sum += arr[k];
                }
                if (sum == 100) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (result[0] == i ) continue;
            if (result[1] == i) continue;
            System.out.println(arr[i]);
        }
    }

}