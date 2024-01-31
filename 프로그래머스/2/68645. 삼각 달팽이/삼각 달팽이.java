class Solution {
    public int[] solution(int n) {
        int size = 0;
        for (int i =1; i <= n; i++) {
            size += i;
        }
        int[] answer = new int[size];
        int[][] map = new int[n][n];
        int num = 1;
        int x = -1;
        int y = 0;
    
        for (int i =0; i< n; i++){
            for (int j=i; j<n; j++){
                if (i % 3 == 0){
                    x++;
                }else if( i % 3 == 1) {
                    y++;
                }else {
                    x--;
                    y--;
                }
                map[x][y] = num++;
            }
        }
        int k = 0;
        for (int i=0; i< n; i++){
            for (int j=0; j<n; j++){
                if (map[i][j] == 0) break;
                answer[k++] = map[i][j];
            }
        }
        return answer;
    }
}