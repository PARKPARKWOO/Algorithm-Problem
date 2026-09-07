class Solution {
    boolean[][] v;
    int answer = 0;
    int[] dx = new int[]{-1, 1, 0, 0}; // 상 하 좌 우
    int[] dy = new int[]{0, 0, -1, 1};
    public int numIslands(char[][] grid) {
        v = new boolean[grid.length][grid[0].length]; 
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !v[i][j]) {
                    answer++;
                    bfs(i, j, grid);
                }
            }
        }
        return answer;
    }

    void bfs(int x, int y, char[][] grid) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y ));
        v[x][y] = true;
        while (!q.isEmpty()) {
            Node poll = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if (
                    nx >= 0 && ny >= 00 &&
                    nx < grid.length && ny < grid[0].length &&
                    grid[nx][ny] == '1' && !v[nx][ny]
                ) {
                    q.add(new Node(nx, ny));
                    v[nx][ny] = true;
                }
            }
        }
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