import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) return cities.length * 5;
        Queue<String> cache = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
            String str = cities[i].toLowerCase();
            if (cache.remove(str)) {
                answer++;
            } else {
                if (cache.size() >= cacheSize) {
                    cache.poll();
                }
                answer += 5;
            }
            cache.add(str);
        }
        return answer;
    }
}