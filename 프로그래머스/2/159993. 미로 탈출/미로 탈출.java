import java.util.*;
class Solution {
    private char[][] map;
    private int answer;
    private int[] started;
    private int[] lev;
    private int[] end;
    private int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    private int[] dy = {0, 0, -1, 1};
    public int solution(String[] maps) {
        answer = Integer.MAX_VALUE;
        map = new char[maps.length][maps[0].length()];
        started = new int[2];
        lev = new int[2];
        end = new int[2];
        for (int i =0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'S') {
                    started[0] = i;
                    started[1] = j;
                }
                if (map[i][j] == 'L') {
                    lev[0] = i;
                    lev[1] = j;
                }
                if (map[i][j] == 'E') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        // 1차로 레버
        answer = bfs(started, lev);
        // 2차 도착지
        if (answer == -1) {
            return -1;
        }  else {
            int temp = bfs(lev, end);
            if (temp == -1) {
                return -1;
            }
            return answer+= temp;
        }

    }

    private int bfs(int[] start, int[] target) {
        Queue<Nodes> q = new LinkedList<>();
        q.add(new Nodes(start[0], start[1], 0));
        boolean[][] v = new boolean[map.length][map[0].length];
        v[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            Nodes poll = q.poll();
            if (target[0] == poll.x && target[1] == poll.y) {
                return poll.cnt;
            }
            for (int i =0; i < 4; i++) {
                int nx = dx[i] + poll.x;
                int ny = dy[i] + poll.y;
                if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && !v[nx][ny] && map[nx][ny] != 'X') {
                    q.add(new Nodes(nx, ny, poll.cnt + 1));
                    v[nx][ny] = true;
                }
            }
        }
        return -1;
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
}