class Solution {
    public int minFlips(int[][] grid) {
        int row = 0;
        int col = 0;
        for (int[] arr: grid) {
            row += rowPalindrome(arr);
        }
        for (int i = 0; i < grid[0].length; i++) {
            col += colPalindrome(grid, i);
        }
        return Math.min(row, col);
    }

    private int rowPalindrome(int[] arr) {
        int result = 0;
        int end = arr.length - 1;
        int start = 0;
        while (start < end) {
            if (arr[start] != arr[end]) {
                result++;
            }
            start++;
            end--;
        }
        return result;
    }
    private int colPalindrome(int[][] grid, int idx) {
        int result = 0;
        int end = grid.length - 1;
        int start = 0;
        while (start < end) {
            if (grid[start][idx] != grid[end][idx]) {
                result++;
            }
            start++;
            end--;
        }
        return result;
    }
}