class Solution {
    int answer;
    public int minimumOperations(int[][] grid) {
        for (int i = 0; i < grid[0].length; i++) {
            recursive(grid, 1, i);
        }
        return answer;
    }
    
    // start index 1
    void recursive(int[][] grid, int x, int y) {
        if (x == grid.length) {
            return;
        }

        if (grid[x - 1][y] >= grid[x][y]) {
            int increase = Math.abs(grid[x - 1][y] - grid[x][y]) + 1;
            grid[x][y] = grid[x][y] + increase;
            answer += increase;
        }

        recursive(grid, x + 1, y);
    }
}