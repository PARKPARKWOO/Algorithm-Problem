class Solution {
    private int[][] result;
    private int num;
    public int[][] specialGrid(int n) {
        int size = (int) Math.pow(2, n);
        result = new int[size][size];
        num = 0;
        recursion(size, 0, 0);
        return result;
    }
    private void recursion(int n, int x, int y) {
        int half = n / 2;
        if (half == 0) {
            result[x][y] = num++;
            return;
        }
        recursion(half, x, y + half);
        recursion(half, x + half, y + half);
        recursion(half, x + half, y);
        recursion(half, x, y);
    }
}