import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        List<String> arr = Arrays.stream(strings).sorted()
                .sorted(Comparator.comparingInt(e -> e.charAt(n)))
                .map(String::toString).collect(Collectors.toList());// 자바 8부터 toList() 지원 
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }
}