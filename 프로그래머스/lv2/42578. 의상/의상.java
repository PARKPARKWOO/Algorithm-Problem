import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String[] clothe : clothes) {
            String type = clothe[1];
            hashMap.put(type, hashMap.getOrDefault(type, 0) + 1);
        }
        Iterator<Integer> iterator = hashMap.values().iterator();
        answer = 1;
        while (iterator.hasNext()) {
            answer *= iterator.next().intValue() + 1;
        }
        return answer - 1;
    }
}