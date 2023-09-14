import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static List<Node> list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[9][9];
        list = new ArrayList<>();

        for(int i=0; i<9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0) {
                    list.add(new Node(i, j));
                }
            }
        }

        sudoku(0);

    }

    public static void print() {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void sudoku(int cnt) {
        if(cnt == list.size()) {
            print();
            System.exit(0);
        }

        Node current = list.get(cnt);
        for(int i=1; i<=9; i++) {
            if(check(current.r, current.c, i)) {
                arr[current.r][current.c] = i;
                sudoku(cnt+1);
                arr[current.r][current.c] = 0;
            }
        }
    }

    public static boolean check(int r, int c, int num) {
        for (int i=0; i<9; i++) {
            if(arr[i][c] == num) return false;
            if(arr[r][i] == num) return false;
        }

        int nr = r/3*3;
        int nc = c/3*3;
        for(int i=nr; i<nr+3; i++) {
            for(int j=nc; j<nc+3; j++) {
                if(arr[i][j] == num) return false;
            }
        }

        return true;
    }
    static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}

