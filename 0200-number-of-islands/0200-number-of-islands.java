class Solution {
    private boolean[][] v;
    private int[] nx = new int[]{-1, 1, 0, 0}; // 상 하 좌 우
    private int[] ny = new int[]{0, 0, -1, 1};
    public int numIslands(char[][] grid) {
        v = new boolean[grid.length][grid[0].length];
        Queue<Data> q = new LinkedList<>();
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                char c = grid[i][j];
                if (c == '1' && !v[i][j]) {
                    answer++;
                    q.add(new Data(i, j));
                    while (!q.isEmpty()) {
                        Data poll = q.poll();
                        int x = poll.x;
                        int y = poll.y;
                        if (v[x][y]) continue;
                        v[x][y] = true;
                        for (int n = 0; n < 4; n++) {
                            int dx = nx[n] + x;
                            int dy = ny[n] + y;
                            if (
                                dx >= 0 && dx < grid.length &&
                                dy >= 0 && dy < grid[0].length &&
                                grid[dx][dy] == '1' && !v[dx][dy]
                            ) {
                                q.add(new Data(dx, dy));
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }
}

class Data {
    int x;
    int y;
    int depth;
    public Data(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Data(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}