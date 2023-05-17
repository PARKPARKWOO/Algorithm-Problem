import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> temp = new ArrayList<>();
        temp.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            String last = temp.get(temp.size() - 1);
            String now = words[i];
            if (last.charAt(last.length() - 1) == now.charAt(0) && !temp.contains(words[i])) {
                temp.add(words[i]);
            } else {
                answer[0] = (i % n) + 1;
                answer[1] = i / n + 1;
                break;
            }
        }
        return answer;
    }
}