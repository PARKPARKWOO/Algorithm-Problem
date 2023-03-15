import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int last_index;
        int error;
        HashSet<String> hash = new LinkedHashSet<>();
        for (int i = 0; i < s.length(); i++) {
            hash.add(""+s.charAt(i));
            answer[i] = -1;
        }
        String[] arr = hash.toArray(new String[0]);
        for (int i = 0; i < arr.length; i++) {
            error = -1;
            last_index = 0;
            for (int j = 0; j < s.length(); j++) {
                if (arr[i].equals(s.charAt(j) + "")){
                    error++;
                    if (error >= 1){
                        answer[j] = j - last_index;
                        last_index = j;
                    } else {last_index = j;}
                }
            }
        }
        return answer;
    }
}