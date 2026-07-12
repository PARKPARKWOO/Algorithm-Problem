class Solution {
    Queue<Node> q = new LinkedList<>();
    int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    int[] dy = {0, 0, -1, 1};
    public int orangesRotting(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) q.add(new Node(i, j, 0));
            }
        }
        int answer =0;
        while (!q.isEmpty()) {
            Node poll = q.poll();
            answer = Math.max(answer, poll.depth );
            for (int i =0; i< 4; i++) {
                int nx = dx[i] + poll.x;
                int ny = dy[i] + poll.y;
                if (
                    nx >= 0 && ny >= 0 &&
                    nx < grid.length && ny < grid[0].length &&
                    grid[nx][ny] == 1
                ) {
                    grid[nx][ny] = 2;
                    q.add(new Node(nx, ny, poll.depth + 1 ));
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return answer;
    }
}

class Node {
    int x;
    int y;
    int depth;
    public Node(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}