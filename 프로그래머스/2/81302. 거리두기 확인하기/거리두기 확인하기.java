import java.util.*;
class Solution {
    private char[][][] map;
    private int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    private int[] dy = {0, 0, -1, 1};
    private boolean[][] v;
    public int[] solution(String[][] places) {
        // 거리두기 조건 거리 2 초과, 파티션이 사이에 있을경우
        map = new char[places.length][places[0].length][places[0][0].length()];
        int[] answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            for(int j = 0; j < places[0].length; j++) {
                map[i][j] = places[i][j].toCharArray();
            }
        }
        for (int i = 0; i < places.length; i++) {
            answer[i] = queue(i);
        }
        return answer;
    }
    
    // 각 대기실
    private int queue(int queue) {
        char[][] it = map[queue];
        for (int i = 0; i < it.length; i++) {
            for (int j = 0; j < it[0].length; j++) {
                if (it[i][j] == 'P') {
                    if (!check(i, j, it)) return 0;
                }
            }
        }
        return 1;
    }
    
    // 지켰을때 true
    private boolean check(int x, int y, char[][] it) {
        v = new boolean[it.length][it[0].length];
        Queue<Nodes> q = new LinkedList<>();
        q.add(new Nodes(x, y, 0, false));
        v[x][y] = true;
        while (!q.isEmpty()) {
            Nodes poll = q.poll();
            if (poll.depth >= 2) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if (inRange(nx, ny) && !v[nx][ny]) {
                    if (it[nx][ny] == 'X') {
                        q.add(new Nodes(nx, ny, poll.depth + 1, true));
                    
                    } else if (it[nx][ny] == 'P' && !poll.canMak) return false;
                    else q.add(new Nodes(nx, ny, poll.depth + 1, poll.canMak));
                    v[nx][ny] = true;
                }
            }
        }
        return true;
    }
    
    
    private boolean inRange(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }
}

class Nodes {
    int x;
    int y;
    int depth;
    boolean canMak;
    public Nodes(int x, int y, int depth, boolean canMak) {
        this.x = x;
        this.y = y;
        this.depth = depth;
        this.canMak = canMak;
    }
}