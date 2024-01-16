import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        Map<String , String> nickname = new HashMap<>();
        List<String > list = new ArrayList<>();

        for (String s : record) {
            String[] split = s.split(" ");
            String join = split[0];
            if (join.equals("Enter") || join.equals("Change")) nickname.put(split[1], split[2]);
            if (!join.equals("Change")) {
                if (join.equals("Enter")) join = "님이 들어왔습니다.";
                else if (join.equals("Leave")) join = "님이 나갔습니다.";
                list.add(split[1] + " " + join);
            }
        }
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            String[] split = list.get(i).split(" ");
            answer[i] = nickname.get(split[0]) + split[1] + " " + split[2];
        }
        return answer;
    }
}