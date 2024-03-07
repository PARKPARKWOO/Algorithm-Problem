class Solution
{
    public int solution(int [][]board)
    {
        int answer = 1234;
        int x = board.length;
        int y = board[0].length;
        if (x == 1 && y == 1) {
            return 1;
        }
        int len = 0;
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = Math.min(board[i - 1][j], Math.min(board[i][j -1], board[i -1][j -1])) + 1;
                }
                len = Math.max(board[i][j], len);
            }
        }
        return len * len;
    }
}