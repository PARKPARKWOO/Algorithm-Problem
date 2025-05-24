import java.util.*;

public class Main {
    static int N;
    static int r;
    static int c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        int size = (int) Math.pow(2, N);
        search(r, c, size, 0);
    }

    private static void search(int x, int y, int size, int sum) {
        if (size == 1) {
            System.out.println(sum);
            return;
        }

        int half = size / 2;
        int quadrant;

        if (x < half && y < half) quadrant = 0;
        else if (x < half && y >= half) quadrant = 1;
        else if (x >= half && y < half) quadrant = 2;
        else quadrant = 3;

        sum += quadrant * half * half;

        int nx = (x % half);
        int ny = (y % half);

        search(nx, ny, half, sum);
    }
}
