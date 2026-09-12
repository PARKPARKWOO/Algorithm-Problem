class Solution {
    int[] dx = new int[]{-1, 1, 0, 0}; // 상 하 좌 우
    int[] dy = new int[]{0, 0, -1, 1};
    boolean[][] v;
    int answer;
    public int numIslands(char[][] grid) {
        v = new boolean[grid.length][grid[0].length];
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (!v[x][y] && grid[x][y] == '1') {
                    bfs(grid, x, y);
                }
            }
        }
        return answer;
    }

    void bfs(char[][] grid, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        v[x][y] = true;
        answer++;
        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];
                if (
                    nx >= 0 && nx < grid.length &&
                    ny >= 0 && ny < grid[0].length &&
                    !v[nx][ny] && grid[nx][ny] == '1'
                ) {
                    v[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}