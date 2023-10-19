class Solution {
    // 상 하 좌 우 에서 올때
    boolean[][][] v;
    int ans = 0;
    Point move(Point point, char direction){
        int x = point.x;
        int y = point.y;
        if (direction == 'U'){
            x++;
            if (x <= 10 && !v[x][y][0] && !v[x - 1][y][1]){
                v[x][y][0] = true;
                v[x - 1][y][1] = true;  
                ans++;
            }else if (x >= 11){
                x--;
            }
        }else if (direction == 'L'){
            y--;
            if (y >= 0 && !v[x][y][2] && !v[x][y + 1][3]){
                v[x][y][2] = true;
                v[x][y + 1][3] = true;
                ans++;
            }else if (y < 0){
                y++;
            }
        }else if (direction == 'R'){
            y++;
            if (y < 11 && !v[x][y][3] && !v[x][y - 1][2]){
                v[x][y][3] = true;
                v[x][y - 1][2] = true;
                ans++;
            }else if (y >= 11) {
                y--;
            }
        }else if (direction == 'D'){
            x--;
            if (x >= 0 && !v[x][y][1] && !v[x + 1][y][0]){
                v[x][y][1] = true;  
                v[x + 1][y][0] = true;
                ans++;
            }else if(x < 0){
                x++;
            }
        }
        return new Point(x, y);
    }
    public int solution(String dirs) {
        int answer = 0;
        v = new boolean[11][11][4];
        Point point = new Point(5, 5);
        for (int i = 0; i < dirs.length(); i++){
            point = move(point, dirs.charAt(i));
        }
        return ans;
    }
}
class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}