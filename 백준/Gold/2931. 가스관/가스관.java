import java.util.*;

public class Main {
    private static char[][] graph;
    private static int M;
    private static int N;
    private static int dx;
    private static int dy;
    private static int x;
    private static int y;
    private static int ax;
    private static int ay;
    private static int cnt;
    private static String switchString;
    private static char[] elements = new char[]{'|', '-', '+', '1', '2', '3', '4'};
    private static int[] ddx = new int[]{-1, 1, 0, 0}; // 상 하 좌 우
    private static int[] ddy = new int[]{0, 0, -1, 1};
    private static boolean[][] v;
    private static int d;
    public static void main(String[] args) {
        init();
        for (int i = 0; i < 4; i++) {
            int nx = x + ddx[i];
            int ny = y + ddy[i];
            if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                continue;
            }
            switchString = null;
            d = i;
            dfs(x, y, 0, i);
        }
    }

    public static void init() {
        Scanner scanner = new Scanner(System.in);
        M = scanner.nextInt();
        N = scanner.nextInt();
        graph = new char[M][N];
        cnt = 1;
        scanner.nextLine();
        for (int i = 0; i < M; i++) {
            String line = scanner.nextLine();
            if (line.isEmpty()) i--;
            for (int j = 0; j < line.length(); j++) {
                graph[i][j] = line.charAt(j);
            }
        }
        v = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 'M') {
                    x = i;
                    y = j;
                } else if (graph[i][j] == 'Z') {
                    dx = i;
                    dy = j;
                } else if (graph[i][j] != '.') {
                    cnt++;
                }
            }
        }
    }

    private static void print() {
        System.out.printf("%d %d %s%n", ax + 1, ay + 1, switchString);
    }

    private static void dfs(int r, int c, int depth, int direction) {
        if (!inBounds(r, c)) return;
        if (graph[r][c] == 'Z' && switchString != null) {
            if (cnt + 1 == depth) {
                print();
            }
            return;
        }
//        if (graph[r][c] == 'Z' && switchString != null) {
//            print();
//            return;
//        }

        if (direction == -1) return;

        int nx = ddx[direction] + r;
        int ny = ddy[direction] + c;
        if (!inBounds(nx, ny)) return;

        char now = graph[nx][ny];
        int addDepth;
        if (now == '+' && v[nx][ny]) {
            addDepth = depth;
        } else  {
            addDepth = depth + 1;
        }
        if (now == '.') {
            // 블럭
            if (switchString == null) {
                for (int i = 0; i < 4; i++) {
                    int nnx = nx + ddx[i];
                    int nny = ny + ddy[i];
                    if (!inBounds(nnx, nny) || (direction ^ 1) == i) {
                        continue;
                    }
                    boolean neighborOpen = isOpen(graph[nnx][nny], i );
                    if (!neighborOpen) {
                        continue;
                    }
                    for (char element : elements) {
                        if (!isOpen(element, direction)) {
                            continue;
                        }
                        int nextDir = switchDirection(element, direction);
                        if (nextDir != i) continue;
                        if (!isNeighborOpen(nx, ny, nextDir, element)) continue;

                        ax = nx;
                        ay = ny;
                        switchString = String.valueOf(element);
                        graph[nx][ny] = element;
                        v[nx][ny] = true;
                        dfs(nx, ny, depth + 1, nextDir);
                        switchString = null;
                        v[nx][ny] = false;
                        graph[nx][ny] = '.';
                    }
                }
            }
        } else {
            int switchDirection = switchDirection(now, direction);
            v[nx][ny] = true;
            dfs(nx, ny, addDepth, switchDirection);
            v[nx][ny] = false;
        }
    }

    private static boolean isNeighborOpen(int nx, int ny, int direction, char element) {
        if (!inBounds(nx, ny)) return false;

        if (element != '+') return true;

        boolean isOpen = false;
        if (direction == 0 || direction == 1) {
            // 좌
            int lx = ddx[2] + nx;
            int ly = ddy[2] + ny;
            if (inBounds(lx, ly)) {
                char c = graph[lx][ly];
                if (c == '-' || c == '1' || c == '2' || c == '+') {
                    isOpen = true;
                }
            }
            // 우
            int rx = nx + ddx[3];
            int ry = ny + ddy[3];
            if (inBounds(rx, ry)) {
                char c = graph[rx][ry];
                if (c == '-' || c == '3' || c == '4' || c == '+') {
                    isOpen = true;
                }
            }
            return isOpen;
        }
        int ux = ddx[0] + nx;
        int uy = ddy[0] + ny;
        if (inBounds(ux, uy)) {
            char c = graph[ux][uy];
            if (c == '|' || c == '+' || c == '1' || c == '4') {
                isOpen = true;
            }
        }
        int downX = ddx[1] + nx;
        int downY = ddy[1] + ny;
        if (inBounds(downX, downY)) {
            char c = graph[downX][downY];
            if (c == '|' || c == '+' || c == '2' || c == '3') {
                isOpen = true;
            }
        }
        return isOpen;
    }

    private static boolean isOpen(char ch, int dir) {
        return switch (ch) {
            case '|' -> dir == 0 || dir == 1;
            case '-' -> dir == 2 || dir == 3;
            case '+', 'Z', 'M' -> true;
            case '1' -> dir == 0 || dir == 2;
            case '2' -> dir == 1 || dir == 2;
            case '3' -> dir == 1 || dir == 3;
            case '4' -> dir == 0 || dir == 3;
            default -> false;
        };
    }


    private static boolean inBounds(int r, int c) {
        return 0 <= r && r < M && 0 <= c && c < N;
    }

    private static int switchDirection(char now, int i) {
        if (now == 'Z') return -1;
        if (now == '|') return (i == 0 || i == 1) ? i : -1;
        if (now == '-') return (i == 2 || i == 3) ? i : -1;
        if (now == '+') return i;

        if (now == '1') {
            if (i == 0) return 3;
            if (i == 2) return 1;
            return -1;
        }
        if (now == '2') {
            if (i == 1) return 3;
            if (i == 2) return 0;
            return -1;
        }
        if (now == '3') {
            if (i == 1) return 2;
            if (i == 3) return 0;
            return -1;
        }
        if (now == '4') {
            if (i == 0) return 2;
            if (i == 3) return 1;
            return -1;
        }
        return -1;
    }
}
