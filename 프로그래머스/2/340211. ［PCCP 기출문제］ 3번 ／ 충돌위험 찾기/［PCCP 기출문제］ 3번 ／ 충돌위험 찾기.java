import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        // t x y 로 확인
        Map<String, Integer> v = new HashMap<>();
        
        int answer = 0;
        PriorityQueue<Robot> q = new PriorityQueue<>();
        for (int[] route: routes) {
            int from = route[0] - 1;
            int[] f = points[from];
            
            q.add(new Robot(f[0], f[1], 0, route, points));
        }
        while (!q.isEmpty()) {
            Robot poll = q.poll();
            
            String key = getKey(poll);
            int vCnt = v.getOrDefault(key, 0);
            if (vCnt == 0) {
                v.put(key, 1);
            } else if (vCnt == 1) {
                answer++;
                v.put(key, 2);
            }
            if (poll.isArrive()) {
                if (!poll.setNextTargetIfAny()) {
                    continue;
                }
            }
            
            poll.move();
            q.add(poll);
        }
        return answer;
    }
    
    private String getKey(Robot r) {
        return r.time + ":" + r.x + ":" + r.y;
    }
}

class Robot implements Comparable<Robot>{
    int x;
    int y;
    int[] routes;
    int[][] points;
    int idx;
    int time;
    int dx;
    int dy;
    public Robot(int x, int y, int time, int[] routes, int[][] points) {
        this.x = x;
        this.y = y;
        this.points = points;
        this.time = time;
        this.routes = routes;
        this.idx = 1;
        int[] t = points[routes[idx] - 1];
        this.dx = t[0];
        this.dy = t[1];
    }
    public int compareTo(Robot o) {
        return Integer.compare(this.time, o.time);
    }

    public boolean isArrive() {
        return x == dx && y == dy;
    }
    
    public boolean setNextTargetIfAny() {
        if (idx + 1 >= routes.length) return false;
        idx++;
        int[] t = points[routes[idx] - 1];
        dx = t[0];
        dy = t[1];
        return true;
    }
    
    public void move() {
        this.time++;
        // x 부터
        if (x != dx) {
            if (x > dx) {
                this.x--;
            } else {
                this.x++;
            }
        } else {
            if (y > dy) {
                this.y--;
            } else {
                this.y++;
            }
        }
    }
}