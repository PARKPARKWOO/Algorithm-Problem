import java.util.*;
class Solution {
    private int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    private int[] dy = {0, 0, -1, 1};
    private boolean[][] v;
    private int result;
    public int solution(int[][] maps) {
        int answer = 0;
        result = 0;
        int x = maps.length;
        int y = maps[0].length;
        v = new boolean[x][y];
        bfs(maps, x, y);
        return maps[x - 1][y - 1] == 1 ? -1 : maps[x-1][y-1];
    }
    private void bfs(int[][] maps, int xlen, int ylen) {
        Queue<Nodes> q = new LinkedList<>();
        q.add(new Nodes(0, 0));
        while (!q.isEmpty()) {
            Nodes poll = q.poll();
            int x = poll.x;
            int y = poll.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < xlen && ny >= 0 && ny < ylen && !v[nx][ny] && maps[nx][ny] != 0) {
                    q.add(new Nodes(nx, ny));
                    v[nx][ny] = true;
                    maps[nx][ny] = maps[x][y] + 1;
                }
            }
        }
    }
}
class Nodes {
    int x;
    int y;
    public Nodes(int x, int y) {
        this.x = x;
        this.y = y;
    
    }
}