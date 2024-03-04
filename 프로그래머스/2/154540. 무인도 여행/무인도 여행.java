import java.util.*;
class Solution {
    private boolean[][] v;
    private char[][] map;
    private int[] dx = {-1, 1, 0, 0}; // 상하좌우
    private int[] dy = {0, 0, -1, 1};
    private List<Integer> answer;
    public int[] solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        v = new boolean[maps.length][maps[0].length()];
        answer = new ArrayList();
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }
        boolean error = true;
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[0].length; j++){
                if (!v[i][j] && map[i][j] != 'X') {
                    bfs(i, j);
                    error = false;
                }
            }
            if (i == map.length - 1 && error) {
                answer.add(-1);
            }
        }

        return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
    private void bfs(int x, int y) {
        int result = 0;
        Queue<Node> q = new LinkedList<>();
        Node n = new Node(x, y);
        q.add(n);
        v[x][y] = true;
        while (!q.isEmpty()) {
            Node poll = q.poll();
            result += (map[poll.x][poll.y] - '0');
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && map[nx][ny] != 'X' && !v[nx][ny]) {
                    q.add(new Node(nx, ny));
                    v[nx][ny] = true;
                }
            }
        }
        answer.add(result);
    }
}

class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}