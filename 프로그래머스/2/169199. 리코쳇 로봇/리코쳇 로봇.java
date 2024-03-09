import java.util.*;
class Solution {
    private char[][] map;
    private int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    private int[] dy = {0, 0, -1, 1};
    private int answer;
    private Nodes start;
    private Nodes goal;
    private boolean[][] v;
    public int solution(String[] board) {
        answer = Integer.MAX_VALUE;
        map = new char[board.length][board[0].length()];
        v = new boolean[board.length][board[0].length()];

        for (int i = 0; i < board.length; i++) {
            map[i] = board[i].toCharArray();
        }
        // init
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j <map[0].length; j++) {
                if (map[i][j] == 'R') start = new Nodes(i, j, 0);
                else if (map[i][j] == 'G') goal = new Nodes(i, j, 0);
            }
        }
        bfs();
        return answer;
    }

    private void bfs() {
        Queue<Nodes> q = new LinkedList<>();
        q.add(new Nodes(start.x, start.y, start.cnt));
        v[start.x][start.y] = true;
        while (!q.isEmpty()) {
            Nodes node = q.poll();
            int x = node.x;
            int y = node.y;
            if (goal.goal(x, y)) {
                answer = Math.min(answer, node.cnt);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                while (check(nx, ny)) {
                    nx += dx[i];
                    ny += dy[i];
                }
                nx -= dx[i];
                ny -= dy[i];
                if (v[nx][ny] ||(x == nx && ny == y)) continue;
                v[nx][ny] = true;
                q.add(new Nodes(nx, ny, node.cnt + 1));
            }
        }
        if (answer == Integer.MAX_VALUE) answer = -1;
    }



    private boolean check(int x, int y) {
        return x >= 0 && x < map.length && y >= 0 && y < map[0].length && map[x][y] != 'D';
    }
}

class Nodes {
    int x;
    int y;
    int cnt;
    public Nodes(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
    public boolean goal(int x, int y){
        return this.x == x && this.y == y;
    }
}