import java.util.*;

public class Main {
    private static int SIZE = 9;
    private static int[][] graph = new int[SIZE][SIZE];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        recursive(0, 0);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(graph[i][j]);
                if (j < 8) System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static boolean recursive(int x, int y) {
        if (x == SIZE) return true;
        if (y == SIZE) return recursive(x + 1, 0);

        if (graph[x][y] != 0) {
            return recursive(x, y + 1);
        }

        for (int i = 1; i <= 9; i++) {
            if (validate(x, y, i)) {
                graph[x][y] = i;
                if (recursive(x, y + 1)) {
                    return true;
                }
                graph[x][y] = 0;
            }
        }
        return false;
    }

    private static boolean validate(int x, int y, int n) {
        int[] g = graph[x];
        for (int i : g) {
            if (n == i) return false;
        }

        for (int i = 0; i < 9; i++) {
            int i1 = graph[i][y];
            if (i1 == n) return false;
        }

        int nx = (x / 3) * 3;
        int ny = (y / 3) * 3;
        for (int i = nx; i < nx + 3; i++) {
            for (int j = ny; j < ny + 3; j++) {
                int nn = graph[i][j];
                if (nn == n) return false;
            }
        }
        return true;
    }
}