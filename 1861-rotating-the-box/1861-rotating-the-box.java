class Solution {
    private char[][] answer;
    private int n;
    private int m;
    public char[][] rotateTheBox(char[][] boxGrid) {
        n = boxGrid[0].length;
        m = boxGrid.length;
        answer = new char[n][m];
        for (char[] row : answer) {
            Arrays.fill(row, '.');  
        }
        
        for (int i = 0; i < m; i++) {
            int temp = n - 1;    
            for (int j = n - 1; j >= 0; j--) {
                char c = boxGrid[i][j];
                if (c == '#') {
                    answer[temp][m - 1 - i] = '#';
                    temp--;
                } else if (c == '*') {
                    answer[j][m -1 -i] = '*';
                    temp = j - 1;
                }
            }
        }
        return answer;
    }
    
}