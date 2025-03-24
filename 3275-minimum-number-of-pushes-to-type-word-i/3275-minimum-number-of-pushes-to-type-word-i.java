import java.util.*;

class Solution {
    public int minimumPushes(String word) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c: word.toCharArray()){
            int cnt = map.getOrDefault(c, 0);
            map.put(c, cnt + 1);
        }
        List<Character> keySet = new ArrayList(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        int idx = 1;
        int sum = 1;
        for (char key : keySet) {
            int cnt = map.getOrDefault(key, 0);
            if (cnt == 0 ) break;
            if (idx % 9 == 0) {
                sum++;
                idx = 1;
            }
            answer += sum;
            idx++;
        }
        return answer;
    }
}