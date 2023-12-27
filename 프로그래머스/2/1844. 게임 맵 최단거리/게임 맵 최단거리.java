import java.util.*;
class Solution {
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    private int ans;
    public int solution(int[][] maps) {
        int answer = 0;
        ans = Integer.MAX_VALUE / 2;
        bfs(maps);
        answer = ans == Integer.MAX_VALUE / 2 ? -1 : ans;
        return answer;
    }

    class Node {
        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    private void bfs(int[][] maps) {
        int maxX = maps.length;
        int maxY = maps[0].length;
        boolean[][] v = new boolean[maxX][maxY];
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                v[i][j] = false;
            }
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));
        v[0][0] = true;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int x = poll.x;
            int y = poll.y;
            int cnt = poll.cnt;
            if (x == maxX -1 && y == maxY - 1) {
                ans = Math.min(cnt, ans);
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < maxX && nx >= 0 && ny < maxY && ny >= 0 && maps[nx][ny] == 1 && !v[nx][ny]) {
                    queue.add(new Node(nx, ny, cnt + 1));
                    v[nx][ny] = true;
                }
            }
        }
    }
}