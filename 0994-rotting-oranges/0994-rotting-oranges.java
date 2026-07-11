class Solution {
    private boolean[][] v;
    private int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    private int[] dy = {0, 0, -1, 1};
    private int answer;
    public int orangesRotting(int[][] grid) {
        v = new boolean[grid.length][grid[0].length];
        Queue<Data> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int g = grid[i][j];
                if (g == 2) {
                    q.add(new Data(i, j, 0));
                    v[i][j] = true;
                }
            }
        }    
        bfs(grid, q);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }

        return answer;
    }

    void bfs(int[][] grid, Queue<Data> q) {
        int maxNum = 0;
        while (!q.isEmpty()) {
            Data poll = q.poll();
            int xx = poll.x;
            int yy = poll.y;
            maxNum = Math.max(maxNum, poll.depth);
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + xx;
                int ny = dy[i] + yy;

                if (
                    nx >= 0 && ny >= 0 &&
                    nx < grid.length && ny < grid[0].length &&
                    grid[nx][ny] == 1
                ) {
                    grid[nx][ny] = 2;
                    q.add(new Data(nx, ny, poll.depth + 1));
                    v[nx][ny] = true;
                }
            }
        }
        answer = maxNum;
    }
}

class Data {
    int x;
    int y;
    int depth;
    public Data(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}