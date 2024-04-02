import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        // init
        for (int i = 0; i < 26; i++) {
            char temp = (char) ('A' + i);
            map.put(String.valueOf(temp), i + 1);
        }
        
        for (int start = 0, end = 0; start < msg.length();) {
            end = start + 1;
            while (end <= msg.length() && map.containsKey(msg.substring(start, end))) {
                end++;
            }
            
            if (end <= msg.length()) {
                map.put(msg.substring(start, end), map.size() + 1);
            }
            list.add(map.get(msg.substring(start, end - 1)));
            start = end - 1;
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}
