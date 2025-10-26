class Solution {
    private int answer = 0;
    public int matrixScore(int[][] grid) {
        int rI = isRow(grid);
        while (rI != -1) {
            row(grid, rI);
            rI = isRow(grid);
        }
        int cI = isColumn(grid);
        while (cI != -1) {
            column(grid, cI);
            cI = isColumn(grid);
        }
        answer = getSum(grid);
        return answer;
    }
    private int isRow(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            int n = grid[i][0];
            if (n == 0) {
                return i;
            }
        }
        return -1;
    }

    private int isColumn(int[][] grid) {
        int z = 0;
        int o = 0;
        for (int i = 0; i < grid[0].length; i++) {
            for (int x = 0; x < grid.length; x++) {
                int n = grid[x][i];
                if (n == 0) {
                    z++;
                } else {
                    o++;
                }
            }
            if (z > o) {
                return i;
            }
            z = 0;
            o = 0;
        }
        return -1;
    }
    private void row(int[][] grid, int idx) {
        for (int i = 0; i < grid[0].length; i++) {
            int n = grid[idx][i];
            if (n == 0) {
                grid[idx][i] = 1;
            } else {
                grid[idx][i] = 0;
            }
        }
    }

    private void column(int[][] grid, int idx) {
        for (int i =0; i < grid.length; i++) {
            int n = grid[i][idx];
            if (n == 0) {
                grid[i][idx] = 1;
            } else {
                grid[i][idx] = 0;
            }
        }
    }
    private int getSum(int[][] grid) {
        int sum = 0;
        for (int[] row : grid) {
            int val = 0;
            for (int b : row) val = (val << 1) | (b & 1);
            sum += val;
        }
        return sum;
    }
}