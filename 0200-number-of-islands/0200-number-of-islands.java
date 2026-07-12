class Solution {
    int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    int[] dy = {0, 0, -1, 1};
    int answer;
    public int numIslands(char[][] grid) {
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j <grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i , j);
                    answer++;
                }
            }
        }
        return answer;
    }

    void bfs(char[][] grid, int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        
        while (!q.isEmpty()) {
            Node poll = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + poll.x;
                int ny = dy[i] + poll.y;
                if (
                    nx >= 0 && ny >= 0 &&
                    nx < grid.length && ny < grid[0].length &&
                    grid[nx][ny] == '1'
                ) {
                    q.add(new Node(nx, ny));
                    grid[nx][ny] = '0';
                }
            }
        }
    }
}

class Node {
    int x;
    int y;
    public Node(int x, int y ){ 
        this.x = x;
        this.y = y;
    }
}