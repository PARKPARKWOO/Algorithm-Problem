class Solution {
    private int rows, cols;
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) return true;
        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != word.charAt(index)) return false;
        
        char temp = board[i][j];
        board[i][j] = '#'; // 방문 처리 (임시 마커)
        boolean found = dfs(board, word, i - 1, j, index + 1)
                     || dfs(board, word, i + 1, j, index + 1)
                     || dfs(board, word, i, j - 1, index + 1)
                     || dfs(board, word, i, j + 1, index + 1);
        board[i][j] = temp; // 방문 해제 (백트래킹)
        return found;
    }
}
