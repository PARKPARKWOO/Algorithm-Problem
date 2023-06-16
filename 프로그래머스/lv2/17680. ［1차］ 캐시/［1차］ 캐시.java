import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        LinkedList<String> q = new LinkedList<>();
        for (String city : cities) {
            city = city.toLowerCase();
            if (q.remove(city)) {
                answer += 1;
            }
            else {
                answer += 5;
                if (q.size() >= cacheSize) {
                    q.remove(0);
                }
            }
            q.add(city);
        }
        return answer;
    }
}